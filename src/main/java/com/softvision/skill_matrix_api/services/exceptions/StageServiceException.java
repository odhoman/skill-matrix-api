package com.softvision.skill_matrix_api.services.exceptions;

public class StageServiceException extends RuntimeException {

	public StageServiceException(String message) {
		super(message);
	}

	public StageServiceException(String message, Throwable e) {
		super(message, e);
	}

}
