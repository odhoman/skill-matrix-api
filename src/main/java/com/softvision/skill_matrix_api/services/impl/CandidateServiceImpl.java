package com.softvision.skill_matrix_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.softvision.skill_matrix_api.model.Candidate;
import com.softvision.skill_matrix_api.model.Consultant;
import com.softvision.skill_matrix_api.repositories.CandidateRepository;
import com.softvision.skill_matrix_api.services.CandidateService;
import com.softvision.skill_matrix_api.services.exceptions.CandidateServiceException;

@Service
public class CandidateServiceImpl implements CandidateService {

	private CandidateRepository candidateRepository;

	@Autowired
	public CandidateServiceImpl(CandidateRepository candidateRepository) {
		super();
		this.candidateRepository = candidateRepository;
	}

	@Override
	public Candidate getCandidateById(Long id) throws CandidateServiceException {
		return candidateRepository.findById(id)
				.orElseThrow(() -> new CandidateNotFoundException("Candidate Not Found"));
	}

	@Override
	public Candidate save(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public void update(Long id, Candidate candidate) {
		candidateRepository.save(candidateRepository.findById(id).map((value) -> {
			candidate.setId(id);
			return candidate;
		}).orElseThrow(() -> new CandidateNotFoundException("Candidate Not Found")));
	}

	@Override
	public void delete(Long id) {
		getCandidateById(id);
		candidateRepository.deleteById(id);
	}
	
	@Override
	public List<Candidate> getCandidatesByConsultantId(Long consultantId){
		
		Consultant con = new Consultant();
		con.setId(consultantId);
		Candidate candidate = new Candidate();
		candidate.setConsultant(con);
		
		return candidateRepository.findAll(Example.of(candidate));
	}

}
