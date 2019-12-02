package com.softvision.skill_matrix_api.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.softvision.skill_matrix_api.model.Consultant;

public class ConsultantControllerTest extends SkillMatrixTestBase {

	private static final String CONSULTANTS_PATH = "/consultants/";

	@Test
	public void testGetConsultantById() throws Exception {
		int id = 2;
		performSimpleGet(CONSULTANTS_PATH + id)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(id)))
				.andDo(print());
	}

	@Test
	public void testGetConsultantNotFound() throws Exception {
		performSimpleGet(CONSULTANTS_PATH + 9999)
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.message", is("Consultant Not Found")))
				.andDo(print());
	}

	@Test
	public void testPostNewConsultant() throws Exception {
		performSimplePost(CONSULTANTS_PATH, getConsultantTest())
				.andExpect(status().is(201))
				.andDo(print());
	}

	@Test
	public void testPutConsultant() throws Exception {
		int id = 2;
		performSimplePut(CONSULTANTS_PATH + id,getConsultantTest())
				.andExpect(status().is(200))
				.andDo(print());

		performSimpleGet(CONSULTANTS_PATH + id).andExpect(jsonPath("$.createdBy", is("createdBy")))
				.andExpect(jsonPath("$.lastModifiedBy", is("lastModifiedBy")))
				.andDo(print());
	}

	@Test
	public void testDeleteConsultant() throws Exception {
		int id = 6;
		performSimpleDelete(CONSULTANTS_PATH , id)
				.andExpect(status().is(200))
				.andDo(print());

		performSimpleGet(CONSULTANTS_PATH + id)
				.andExpect(status().is4xxClientError())
				.andDo(print());
	}
	
	@Test
	public void testGetCandidatesByConsultantId() throws Exception {
		int id = 2;
		performSimpleGet(CONSULTANTS_PATH + id + CandidateControllerTest.CANDIDATES_PATH)
				.andExpect(jsonPath("$", Matchers.not(Matchers.empty())))
				.andDo(print());
	}

	private Consultant getConsultantTest() {
		Consultant c = new Consultant();
		c.setVersion(5L);
		c.setCreatedBy("createdBy");
		c.setCreatedDate(new Date());
		c.setLastModifiedDate(new Date());
		c.setLastModifiedBy("lastModifiedBy");
		c.setName("Consultant Test Name");
		c.setLastName("Consultant Test Last Name");
		c.setPhoneNumber("134134134");
		c.setEmailAddress("adsfasdf@gmail.com");
		c.setAdditionalInformation("aditional info");

		return c;
	}

}
