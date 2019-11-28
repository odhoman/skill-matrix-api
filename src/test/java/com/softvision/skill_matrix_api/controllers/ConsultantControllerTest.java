package com.softvision.skill_matrix_api.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.softvision.skill_matrix_api.model.Consultant;

public class ConsultantControllerTest extends SkillMatrixTestBase {

	@Test
	public void testGetConsultantById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/consultants/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(2))).andDo(print());
	}

	@Test
	public void testGetConsultantNotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/consultants/99999").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError()).andExpect(jsonPath("$.message", is("Consultant Not Found")))
				.andDo(print());
	}

	@Test
	public void testPostNewConsultant() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/consultants/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(getConsultantTest()))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201))
				.andDo(print());
	}
	
	@Test
	public void testPutNewConsultant() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/consultants/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(getConsultantTest()))
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201))
				.andDo(print());
	}

	public Consultant getConsultantTest() {
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
