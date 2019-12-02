package com.softvision.skill_matrix_api.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.softvision.skill_matrix_api.model.Candidate;
import com.softvision.skill_matrix_api.model.Consultant;
import com.softvision.skill_matrix_api.model.Process;

public class ProcessControllerTest extends SkillMatrixTestBase {

	private static final String PROCESSES_PATH = "/processes/";
	
	@Test
	public void testProcessById() throws Exception {
		int id = 1;
		performSimpleGet(PROCESSES_PATH + id)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(id)))
				.andExpect(jsonPath("$.candidate.createdBy", is("2e2e2e2e2e2e2")))
				.andExpect(jsonPath("$.consultantOwner.name", is("Consultant Name 2")))
				.andExpect(jsonPath("$.consultantDelegate.lastName", is("Consultant Last Name17")))
				.andDo(print());
	}

	@Test
	public void testPostNewProcess() throws Exception {
		performSimplePost(PROCESSES_PATH, getProcessTest())
				.andExpect(status().is(201)).andDo(print());
	}
	

	@Test
	public void testPutProcess() throws Exception {
		int id = 2;
		performSimplePut(PROCESSES_PATH + id, getProcessTest())
				.andExpect(status().is(200)).andDo(print());
		
		performSimpleGet(PROCESSES_PATH + id)
			.andExpect(jsonPath("$.id", is(id)))
			.andExpect(jsonPath("$.candidate.createdBy", is("Creater")))
			.andExpect(jsonPath("$.consultantOwner.name", is("Consultant Name 2")))
			.andExpect(jsonPath("$.consultantDelegate.name", is("Consultant Name 2"))).andDo(print());
	}

	@Test
	public void testDeleteProcess() throws Exception {
		int id = 3;
		performSimpleDelete(PROCESSES_PATH , id).andDo(print())
				.andExpect(status().is(200));
		performSimpleGet(PROCESSES_PATH + id)
				.andExpect(status().is4xxClientError()).andDo(print());
	}
	
	
	private Process getProcessTest() {

		Consultant consultantOwner = new Consultant();
		consultantOwner.setId(8L);
		
		Consultant consultantDelegate = new Consultant();
		consultantDelegate.setId(9L);
		
		Candidate can = new Candidate();
		can.setId(22L);

		Process p = new Process();
		p.setCreatedBy("createdBy");
		p.setCreatedDate(new Date());
		p.setLastModifiedBy("lastModifiedBy");
		p.setLastModifiedDate(new Date());
		p.setEndDate(new Date());
		p.setStartDate(new Date());
		p.setStatus(3L);
		p.setVersion(1L);
		p.setProfile("profile");
		p.setRejectionReason("RejectionReason");
		p.setEnglishLevel("englishLevel");
		p.setActualSalary(new BigDecimal(200000));
		p.setWantedSalary(new BigDecimal(300000));
		p.setSeniority("seniority");
		
		p.setConsultantOwner(consultantOwner);
		p.setConsultantDelegate(consultantDelegate);
		p.setCandidate(can);

		return p;
	}
}
