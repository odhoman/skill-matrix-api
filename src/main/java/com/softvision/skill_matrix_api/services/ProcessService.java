package com.softvision.skill_matrix_api.services;

import java.util.List;

import com.softvision.skill_matrix_api.model.Process;
import com.softvision.skill_matrix_api.model.Stage;

public interface ProcessService {
	
	public abstract Process getProcessById(Long id);

	public abstract Process save(Process process);

	public void update(Long id, Process process);

	public void delete(Long id);
	
	public List<Stage> getStagesByProcessId(Long processId);
	
	public Stage createStageByProcessId(Long processId, Stage stage);
	
	public void updateStageByProcessIdAndStageId(Long processId, Stage stage, Long stageId);
	
	public void deleteStageByProcessIdAndStageId(Long processId, Long stageId);
	
	public Stage getStageByProcessIdStageId(Long processId, Long stageId);

}
