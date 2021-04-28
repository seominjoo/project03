package com.spring.fleamarket.global.util.file.exception;

public class NotAcceptableImageFileFormatException extends Exception {

	private final static String MSG = "Not Acceptable Image File Format";
	
	public NotAcceptableImageFileFormatException() {
		super(MSG);
	}
}
