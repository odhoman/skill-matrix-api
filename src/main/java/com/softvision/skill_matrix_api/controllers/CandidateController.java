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

import com.softvision.skill_matrix_api.model.Candidate;
import com.softvision.skill_matrix_api.services.CandidateService;

@RestController
public class CandidateController {

	private CandidateService service;
	
	@Autowired
	public CandidateController(CandidateService service) {
		super();
		this.service = service;
	}

	public CandidateService getService() {
		return service;
	}

	public void setService(CandidateService service) {
		this.service = service;
	}

	@GetMapping("/candidates/{id}")
	public Candidate getCandidateById(@PathVariable Long id) {
		return service.getCandidateById(id);
	}

	@PostMapping("/candidates")
	public ResponseEntity<Object> createCandidate(@RequestBody Candidate candidate) {
		Candidate savedCandidate = service.save(candidate);

		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCandidate.getId()).toUri()).build();
	}
	
	@PutMapping("/candidates/{id}")
	public void updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
		service.update(id,candidate);
	}
	
	@DeleteMapping("/candidates/{id}")
	public void deleteCandidate(@PathVariable Long id) {
		service.delete(id);
	}

}
