package com.softvision.skill_matrix_api.services.impl;

import com.softvision.skill_matrix_api.services.exceptions.StageServiceException;

public class StageNotFoundException extends StageServiceException{

	public StageNotFoundException(String message) {
		super(message);
	}

	public StageNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
