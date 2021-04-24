package com.spring.fleamarket.global.util.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",	
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class FileUtilsTest {

	@Resource(name = "accountFileUploadPath")
	String accountUploadPath;
	
	private MultipartFile file;
	
	@Before
	public void initialize() throws IOException {
		String fileDir = "src/test/resources/file";
		String fileName = "image1.png";
		file = new MockMultipartFile("file", 
									 fileName, 
									 null, 
									 new FileInputStream(fileDir + File.separator + fileName));
		log.info(file.getOriginalFilename());
	}
	
	@Test
	public void cropTest() {
		
		try {
			FileUtils.uploadCroppedImageFile(file, accountUploadPath, 100, 50, 400, 400, 300);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		
	}
	
	
}
