package com.softvision.skill_matrix_api.services;

import java.util.List;

import com.softvision.skill_matrix_api.model.Candidate;

public interface CandidateService {
	
	public abstract Candidate getCandidateById(Long id);

	public abstract Candidate save(Candidate candidate);
	
	public void update(Long id, Candidate candidate);
	
	public void delete(Long id);
	
	public List<Candidate> getCandidatesByConsultantId(Long recruiteId);
	
}
