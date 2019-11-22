package com.softvision.skill_matrix_api.services;

import com.softvision.skill_matrix_api.model.Candidate;

public interface CandidateService {
	
	public abstract Candidate getCandidateById(Long id);

	public abstract Candidate save(Candidate user);
	
	public void update(Long id, Candidate candidate);
	
}
