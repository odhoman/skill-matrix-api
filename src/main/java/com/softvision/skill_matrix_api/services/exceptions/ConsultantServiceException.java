package com.softvision.skill_matrix_api.services.exceptions;

public class ConsultantServiceException extends RuntimeException {

	public ConsultantServiceException(String message) {
		super(message);
	}

	public ConsultantServiceException(String message, Throwable e) {
		super(message, e);
	}

}
