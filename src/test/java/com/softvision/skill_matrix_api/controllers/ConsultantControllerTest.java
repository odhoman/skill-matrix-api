package com.softvision.skill_matrix_api.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.softvision.skill_matrix_api.model.Consultant;

public class ConsultantControllerTest extends SkillMatrixTestBase {

	@Test
	public void testGetConsultantById() throws Exception {
		int id = 2;
		performGetConsultant(id).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(id))).andDo(print());
	}

	@Test
	public void testGetConsultantNotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/consultants/99999").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError()).andExpect(jsonPath("$.message", is("Consultant Not Found")))
				.andDo(print());
	}

	@Test
	public void testPostNewConsultant() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/consultants/").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(getConsultantTest())).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(201)).andDo(print());
	}

	@Test
	public void testPutNewConsultant() throws Exception {
		int id = 2;
		mockMvc.perform(MockMvcRequestBuilders.put("/consultants/" + id).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(getConsultantTest())).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200)).andDo(print());

		performGetConsultant(id).andExpect(jsonPath("$.createdBy", is("createdBy")))
				.andExpect(jsonPath("$.lastModifiedBy", is("lastModifiedBy"))).andDo(print());
	}

	@Test
	public void testDeleteConsultant() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/consultants/6").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().is(200));
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

	private ResultActions performGetConsultant(int id) throws Exception {
		return mockMvc.perform(MockMvcRequestBuilders.get("/consultants/" + id).accept(MediaType.APPLICATION_JSON));
	}

}
