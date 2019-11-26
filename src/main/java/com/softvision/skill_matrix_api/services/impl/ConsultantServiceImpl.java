package com.softvision.skill_matrix_api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softvision.skill_matrix_api.model.Consultant;
import com.softvision.skill_matrix_api.repositories.ConsultantRepository;
import com.softvision.skill_matrix_api.services.ConsultantService;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	private ConsultantRepository repository;

	@Autowired
	public ConsultantServiceImpl(ConsultantRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Consultant getConsultantById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ConsultantNotFoundException("Consultant Not Found"));
	}

	@Override
	public Consultant save(Consultant consultant) {
		return repository.save(consultant);
	}

	@Override
	public void update(Long id, Consultant consultant) {
		repository.save(repository.findById(id).map((value) -> {
			consultant.setId(id);
			return consultant;
		}).orElseThrow(() -> new ConsultantNotFoundException("Consultant Not Found")));

	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
