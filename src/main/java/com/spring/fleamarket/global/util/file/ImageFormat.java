package com.spring.fleamarket.global.util.file;

import org.springframework.http.MediaType;

public enum ImageFormat {
	
	JPG(MediaType.IMAGE_JPEG),
	PNG(MediaType.IMAGE_PNG);
	
	private MediaType mediaType;
	
	ImageFormat(MediaType mediaType) {
		this.mediaType = mediaType;
	}
	
	public MediaType getMediaType() {
		return mediaType;
	}
	
}
