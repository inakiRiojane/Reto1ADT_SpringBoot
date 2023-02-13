package com.grupo2.reto1.globalExceptionHandler;



public class ErrorMessageDto {

	private String objectName;
	private String field;
	private String defaultMessage;
	private String rejectedValue;
	
	public ErrorMessageDto() {}
	
	public ErrorMessageDto(String objectName, String field, String defaultMessage, String rejectedValue) {
		super();
		this.objectName = objectName;
		this.field = field;
		this.defaultMessage = defaultMessage;
		this.rejectedValue = rejectedValue;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	public String getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(String rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	@Override
	public String toString() {
		return "ErrorMessageDto [objectName=" + objectName + ", field=" + field + ", defaultMessage=" + defaultMessage
				+ ", rejectedValue=" + rejectedValue + "]";
	}
	
}
