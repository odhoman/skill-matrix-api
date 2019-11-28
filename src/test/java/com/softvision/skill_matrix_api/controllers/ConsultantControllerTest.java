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

	private static final String CONSULTANTS_PATH = "/consultants/";

	@Test
	public void testGetConsultantById() throws Exception {
		int id = 2;
		performSimpleGetById(CONSULTANTS_PATH, id).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(id)))
				.andDo(print());
	}

	@Test
	public void testGetConsultantNotFound() throws Exception {
		performSimpleGetById(CONSULTANTS_PATH, 9999).andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.message", is("Consultant Not Found"))).andDo(print());
	}

	@Test
	public void testPostNewConsultant() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(CONSULTANTS_PATH).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(getConsultantTest())).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201)).andDo(print());
	}

	@Test
	public void testPutNewConsultant() throws Exception {
		int id = 2;
		mockMvc.perform(MockMvcRequestBuilders.put(CONSULTANTS_PATH + id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(getConsultantTest())).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200)).andDo(print());

		performSimpleGetById(CONSULTANTS_PATH, id).andExpect(jsonPath("$.createdBy", is("createdBy")))
				.andExpect(jsonPath("$.lastModifiedBy", is("lastModifiedBy"))).andDo(print());
	}

	@Test
	public void testDeleteConsultant() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/consultants/6").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().is(200));
	}

	public static Consultant getConsultantTest() {
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
