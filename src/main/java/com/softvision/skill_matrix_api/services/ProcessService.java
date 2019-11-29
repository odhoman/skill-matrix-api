package com.softvision.skill_matrix_api.services;

import com.softvision.skill_matrix_api.model.Process;

public interface ProcessService {
	
	public abstract Process getProcessById(Long id);

	public abstract Process save(Process process);

	public void update(Long id, Process process);

	public void delete(Long id);

}
