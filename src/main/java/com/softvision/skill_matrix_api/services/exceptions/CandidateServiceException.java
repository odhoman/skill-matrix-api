package com.softvision.skill_matrix_api.services.exceptions;

public class CandidateServiceException extends RuntimeException {

	public CandidateServiceException(String message) {
		super(message);
	}

	public CandidateServiceException(String message, Throwable e) {
		super(message, e);
	}

}
