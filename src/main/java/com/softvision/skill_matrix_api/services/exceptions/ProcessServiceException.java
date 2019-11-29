package com.softvision.skill_matrix_api.services.exceptions;

public class ProcessServiceException extends RuntimeException {

	public ProcessServiceException(String message) {
		super(message);
	}

	public ProcessServiceException(String message, Throwable e) {
		super(message, e);
	}

}
