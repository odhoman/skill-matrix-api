package com.softvision.skill_matrix_api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softvision.skill_matrix_api.model.Process;
import com.softvision.skill_matrix_api.model.Stage;
import com.softvision.skill_matrix_api.repositories.ProcessRepository;
import com.softvision.skill_matrix_api.repositories.StageRepository;
import com.softvision.skill_matrix_api.services.ProcessService;
import com.softvision.skill_matrix_api.services.exceptions.ProcessServiceException;

@Service
public class ProcessServiceImpl implements ProcessService {

	private ProcessRepository repository;

	private StageRepository stageRepository;

	@Autowired
	public ProcessServiceImpl(ProcessRepository repository, StageRepository stageRepository) {
		super();
		this.repository = repository;
		this.stageRepository = stageRepository;
	}

	@Override
	public Process getProcessById(Long id) throws ProcessServiceException {
		return repository.findById(id).orElseThrow(() -> getProcessNotFoundException());
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
		}).orElseThrow(() -> getProcessNotFoundException()));
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Stage createStageByProcessId(Long processId, Stage stage) {
		stage.setProcess(getProcessById(processId));
		return stageRepository.save(stage);
	}

	@Override
	public void updateStageByProcessIdAndStageId(Long processId, Stage stage, Long stageId) {
		stage.setProcess(getStageByProcessIdAndStageId(processId, stageId).getProcess());
		stage.setId(stageId);
		stageRepository.save(stage);
	}
	
	@Override
	public void deleteStageByProcessIdAndStageId(Long processId, Long stageId) {
		getProcessById(processId);
		stageRepository.deleteById(stageId);
	}
	
	@Override
	public Stage getStageByProcessIdAndStageId(Long processId, Long stageId) {
		getProcessById(processId);
		return stageRepository.findById(stageId).orElseThrow(() -> new StageNotFoundException("Stage Not Found"));
	}
	
	@Override
	public List<Stage> getStagesByProcessId(Long processId) {
		return getProcessById(processId).getStages();
	}
	
	private ProcessNotFoundException getProcessNotFoundException(){
		return new ProcessNotFoundException("Process Not Found");
	}

}
