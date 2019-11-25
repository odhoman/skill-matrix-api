package com.softvision.skill_matrix_api.services.impl;

import com.softvision.skill_matrix_api.services.exceptions.ConsultantServiceException;

public class ConsultantNotFoundException extends ConsultantServiceException{

	public ConsultantNotFoundException(String message) {
		super(message);
	}

	public ConsultantNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
