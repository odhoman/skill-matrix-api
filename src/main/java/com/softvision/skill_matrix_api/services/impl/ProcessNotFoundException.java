package com.softvision.skill_matrix_api.services.impl;

import com.softvision.skill_matrix_api.services.exceptions.ProcessServiceException;

public class ProcessNotFoundException extends ProcessServiceException{

	public ProcessNotFoundException(String message) {
		super(message);
	}

	public ProcessNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
