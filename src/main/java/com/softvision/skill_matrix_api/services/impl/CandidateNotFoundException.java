package com.softvision.skill_matrix_api.services.impl;

import com.softvision.skill_matrix_api.services.exceptions.CandidateServiceException;

public class CandidateNotFoundException extends  CandidateServiceException{
	
	public CandidateNotFoundException(String message) {
		super(message);
	}

	public CandidateNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
