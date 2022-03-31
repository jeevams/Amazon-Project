package com.example.amazon.exception;

public enum BusinessExceptionReason {
	
	USER_NAME_ALREADY_REGSITER("user name already register"),
	PRODUCT_NAME_ALREADY_REGSITER("product name already register");
	
	String code ;
	String message;
	
	BusinessExceptionReason(String message) {
		this.message=message;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
