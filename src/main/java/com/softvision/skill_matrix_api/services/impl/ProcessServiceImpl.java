package com.softvision.skill_matrix_api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softvision.skill_matrix_api.model.Process;
import com.softvision.skill_matrix_api.repositories.ProcessRepository;
import com.softvision.skill_matrix_api.services.ProcessService;
import com.softvision.skill_matrix_api.services.exceptions.ProcessServiceException;

@Service
public class ProcessServiceImpl implements ProcessService{
	
	private ProcessRepository repository;

	@Autowired
	public ProcessServiceImpl(ProcessRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public Process getProcessById(Long id) throws ProcessServiceException {
		return repository.findById(id)
				.orElseThrow(() -> new ProcessNotFoundException("Process Not Found"));
	}

	@Override
	public Process save(Process process) {
		return repository.save(process);
	}

	@Override
	public void update(Long id, Process process) {
		repository.save(repository.findById(id).map((value) -> {
			process.setId(id);
			return process;
		}).orElseThrow(() -> new ProcessNotFoundException("Process Not Found")));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
