package com.softvision.skill_matrix_api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softvision.skill_matrix_api.model.Candidate;
import com.softvision.skill_matrix_api.repositories.CandidateRepository;
import com.softvision.skill_matrix_api.services.CandidateService;
import com.softvision.skill_matrix_api.services.exceptions.CandidateServiceException;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public Candidate getCandidateById(Long id) throws CandidateServiceException {
		return candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate Not Found"));
	}

	@Override
	public Candidate save(Candidate user) {
		return candidateRepository.save(user);
	}

	@Override
	public void update(Long id, Candidate candidate) {
		candidateRepository.save(candidateRepository.findById(id).map((value) -> {
			candidate.setId(id);
			return candidate;
		}).orElseThrow(() -> new CandidateNotFoundException("Candidate Not Found")));
	}

}
