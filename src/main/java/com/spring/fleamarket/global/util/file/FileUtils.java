package com.spring.fleamarket.global.util.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.fleamarket.global.util.file.exception.NotAcceptableImageFileFormatException;

import lombok.extern.log4j.Log4j;

@Log4j
public class FileUtils {
	
	public static String uploadCroppedImageFile(MultipartFile file, String uploadPath, int x, int y, int width, int height, int resize) throws Exception {
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		String savedPath = getCurrentDayPath(uploadPath);
		
		File target = new File(savedPath, fileName);
		BufferedImage src = ImageIO.read(file.getInputStream());
		
		String formatName = getFileFormatName(fileName);
		if (!isImageFormat(formatName)) {
			throw new NotAcceptableImageFileFormatException();
		}
		
		BufferedImage croppedImage = Scalr.crop(src, x, y, width, height);
		BufferedImage savedImage = Scalr.resize(croppedImage, resize);
		
		ImageIO.write(savedImage, formatName, target);
		
		log.info("File upload success");
		return savedPath.substring(uploadPath.length() + File.separator.length()) + File.separator + fileName;
	}
	
	public static String uploadFile(MultipartFile file, String uploadPath) {
		String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		String savedPath = getCurrentDayPath(uploadPath);
		File target = new File(savedPath, fileName);
		
		try {
			FileCopyUtils.copy(file.getBytes(), target);
		} catch (IOException e) {
			log.warn("File upload fail");
		}
		
		return savedPath + File.separator + fileName;
	}
	
	public static void deleteFile(String pathName) {
		File file = new File(pathName);
		if (!file.exists()) {
			log.info("File not exist");
			return;
		}
		
		while (file.exists()) {
			file.delete();
		}
		
		log.info("File delete success");
	}
	
	
	private static String getCurrentDayPath(String uploadRootPath) {
		Calendar currentDay = Calendar.getInstance();
		
		int year = currentDay.get(Calendar.YEAR);
		int month = currentDay.get(Calendar.MONTH) + 1;
		int day = currentDay.get(Calendar.DATE);
		
		return makeDir(uploadRootPath, 
					   String.valueOf(year), 
					   String.format("%02d", month),
					   String.format("%02d", day));
	}
	
	private static String makeDir(String uploadRootPath, String... paths) {
		StringBuilder sb = new StringBuilder(uploadRootPath);
		for (String path : paths) {
			sb.append(File.separator + path);
			File tmp = new File(sb.toString());
			if (!tmp.exists()) {
				tmp.mkdir();
			}
		}
		
		return sb.toString();
	}
	
	private static String getFileFormatName(String fileName) {
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index+1).toUpperCase();
	}
	
	private static boolean isImageFormat(String fileFormat) {
		for (ImageFormat format : ImageFormat.values()) {
			if (format.name().equals(fileFormat)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static MediaType getMediaTypeFromFileName(String fileName) throws NotAcceptableImageFileFormatException {
		String fileFormat = getFileFormatName(fileName);
		if (!isImageFormat(fileFormat)) {
			throw new NotAcceptableImageFileFormatException();
		}
		
		return ImageFormat.valueOf(fileFormat).getMediaType();
	}
}
