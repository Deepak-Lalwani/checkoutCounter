package com.mediaocean.exceptions;

public class MediaOceanException extends Exception {
	private String errorMessage;
	private int errorCode;
	private String message;

	public MediaOceanException(String errorMessage, int errorCode, String message) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.message = message;
	}

	public MediaOceanException() {
		super();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getMessage() {
		return message;
	}
}
