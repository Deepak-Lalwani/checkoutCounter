package com.mediaocean.exceptions;


public class ErrorResponse {
private int errorCode;
	
	private String message;
	private String errorMessage;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

    @Override
    public String toString() {
        return "{" +
            "\""+"errorCode"+"\""+":" +errorCode +
            "," +"\""+"message"+"\""+":" + "\""+ message +  "\"" +
            "," +"\""+"errorMessage"+"\""+":" +"\""+ errorMessage + "\"" +
            "}";
    }
}
