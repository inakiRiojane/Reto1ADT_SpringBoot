package com.grupo2.reto1.globalExceptionHandler;


import java.util.List;

public class ErrorResponse {
	String name;
	int value;
	List<ErrorMessageDto> validationErrorDetails;
	
	public ErrorResponse() {};
	
	public ErrorResponse(String name, int value, List<ErrorMessageDto> validationErrorDetails) {
		super();
		this.name = name;
		this.value = value;
		this.validationErrorDetails = validationErrorDetails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<ErrorMessageDto> getValidationErrorDetails() {
		return validationErrorDetails;
	}

	public void setValidationErrorDetails(List<ErrorMessageDto> validationErrorDetails) {
		this.validationErrorDetails = validationErrorDetails;
	}

	@Override
	public String toString() {
		return "ErrorResponse [name=" + name + ", value=" + value + ", validationErrorDetails=" + validationErrorDetails
				+ "]";
	}
	
}

