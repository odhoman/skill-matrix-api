package com.softvision.skill_matrix_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softvision.skill_matrix_api.model.Process;
import com.softvision.skill_matrix_api.model.Stage;
import com.softvision.skill_matrix_api.services.ProcessService;

@RestController
public class ProcessController {

	private ProcessService service;

	@Autowired
	public ProcessController(ProcessService service) {
		super();
		this.service = service;
	}

	@GetMapping("/processes/{id}")
	public Process getProcessById(@PathVariable Long id) {
		return service.getProcessById(id);
	}

	@PostMapping("/processes")
	public ResponseEntity<Object> createProcess(@RequestBody Process process) {
		Process savedProcess = service.save(process);

		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProcess.getId()).toUri()).build();
	}

	@PutMapping("/processes/{id}")
	public void updateProcess(@PathVariable Long id, @RequestBody Process process) {
		service.update(id, process);
	}

	@DeleteMapping("/processes/{id}")
	public void deleteProcess(@PathVariable Long id) {
		service.delete(id);
	}

	@GetMapping("/processes/{processId}/stages")
	public List<Stage> getStagesByProcessId(@PathVariable Long processId) {
		return service.getStagesByProcessId(processId);
	}

	@GetMapping("/processes/{processId}/stages/{stageId}")
	public Stage getStageByProcessId(@PathVariable Long processId, @PathVariable Long stageId) {
		return service.getStageByProcessIdStageId(processId,stageId);
	}

	@PostMapping("/processes/{processId}/stages")
	public ResponseEntity<Object> createStageByProcessId(@PathVariable Long processId, @RequestBody Stage stage) {
		Stage stageSaved = service.createStageByProcessId(processId, stage);
		
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{stageId}")
				.buildAndExpand(stageSaved.getId()).toUri()).build();
	}

	@PutMapping("/processes/{processId}/stages/{stageId}")
	public void updateStageByProcessIdAndStageId(@PathVariable Long processId, @RequestBody Stage stage,
			@PathVariable Long stageId) {
		service.updateStageByProcessIdAndStageId(processId, stage, stageId);
	}

	@DeleteMapping("/processes/{processId}/stages/{stageId}")
	public void deleteStageByProcessIdAndStageId(@PathVariable Long processId, @PathVariable Long stageId) {
		service.deleteStageByProcessIdAndStageId(processId, stageId);
	}

}
