package com.softvision.skill_matrix_api.services;

import com.softvision.skill_matrix_api.model.Consultant;

public interface ConsultantService {

	public abstract Consultant getConsultantById(Long id);

	public abstract Consultant save(Consultant consultant);

	public void update(Long id, Consultant consultant);

	public void delete(Long id);

}
