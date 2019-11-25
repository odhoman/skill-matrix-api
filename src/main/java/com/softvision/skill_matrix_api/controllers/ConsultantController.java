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

import com.softvision.skill_matrix_api.model.Consultant;
import com.softvision.skill_matrix_api.services.ConsultantService;

@RestController
public class ConsultantController {
	
	@Autowired
	private ConsultantService service;

	@GetMapping("/consultants/{id}")
	public Consultant getConsultantById(@PathVariable Long id) {
		return service.getConsultantById(id);
	}

	@PostMapping("/consultants")
	public ResponseEntity<Object> createConsultant(@RequestBody Consultant consultant) {
		Consultant savedConsultant = service.save(consultant);

		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedConsultant.getId()).toUri()).build();
	}
	
	@PutMapping("/consultants/{id}")
	public void updateConsultant(@PathVariable Long id, @RequestBody Consultant consultant) {
		service.update(id,consultant);
	}
	
	@DeleteMapping("/consultants/{id}")
	public void deleteConsultant(@PathVariable Long id) {
		service.delete(id);
	}

}
