package com.softvision.skill_matrix_api.controllers;

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
		service.update(id,process);
	}
	
	@DeleteMapping("/processes/{id}")
	public void deleteProcess(@PathVariable Long id) {
		service.delete(id);
	}

}
