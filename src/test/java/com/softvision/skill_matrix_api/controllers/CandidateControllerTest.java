package com.softvision.skill_matrix_api.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;

import com.softvision.skill_matrix_api.model.Candidate;
import com.softvision.skill_matrix_api.model.Consultant;

public class CandidateControllerTest extends SkillMatrixTestBase {

	private static final String CANDIDATES_PATH = "/candidates/";

	@Test
	public void testGetCandidateById() throws Exception {
		int id = 19;
		performSimpleGet(CANDIDATES_PATH, id)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(id)))
				.andExpect(jsonPath("$.consultant.createdBy", is("Creator"))).andDo(print());
	}

	@Test
	public void testPostNewCandidate() throws Exception {
		performSimplePost(CANDIDATES_PATH, getCandidateTest())
				.andExpect(status().is(201)).andDo(print());
	}

	@Test
	public void testPutCandidate() throws Exception {
		int id = 23;
		performSimplePut(CANDIDATES_PATH + id, getCandidateTest())
				.andExpect(status().is(200)).andDo(print());
		performSimpleGet(CANDIDATES_PATH, id)
				.andExpect(jsonPath("$.createdBy", is("createdBy")))
				.andExpect(jsonPath("$.lastName", is("lastName")))
				.andExpect(jsonPath("$.consultant.name", is("Consultant Name 2"))).andDo(print());
	}

	@Test
	public void testDeleteCandidate() throws Exception {
		int id = 23;
		performSimpleDelete(CANDIDATES_PATH, id).andDo(print())
				.andExpect(status().is(200));
		performSimpleGet(CANDIDATES_PATH, id)
				.andExpect(status().is4xxClientError()).andDo(print());
	}

	private Candidate getCandidateTest() {

		Consultant con = new Consultant();
		con.setId(2L);

		Candidate c = new Candidate();
		c.setCreatedBy("createdBy");
		c.setCreatedDate(new Date());
		c.setDni(234234234L);
		c.setEmailAddress("email@gmail.com");
		c.setEnglishLevel("englishLevel");
		c.setLastModifiedBy("lastModifiedBy");
		c.setLastModifiedDate(new Date());
		c.setLastName("lastName");
		c.setLinkedInProfile("linkedInProfile");
		c.setName("name");
		c.setPhoneNumber("32342342");
		c.setStatus(3L);
		c.setVersion(1L);

		c.setAdditionalInformation("AditionalInfo");
		c.setConsultant(con);

		return c;
	}

}
