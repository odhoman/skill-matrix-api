package com.softvision.skill_matrix_api.controllers;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softvision.skill_matrix_api.SkillMatrixApp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SkillMatrixApp.class)
@SpringBootTest
public abstract class SkillMatrixTestBase {
	
	protected MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;
	
    @Autowired
    protected ObjectMapper objectMapper;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	protected ResultActions performSimpleGet(String path, int id) throws Exception {
		return performSimpleAction(MockMvcRequestBuilders.get(path + id));
//		return mockMvc.perform(MockMvcRequestBuilders.get(path + id).accept(MediaType.APPLICATION_JSON));
	}
	
	protected ResultActions performSimpleDelete(String path, int id) throws Exception {
		return performSimpleAction(MockMvcRequestBuilders.delete(path + id));
//		return mockMvc.perform(MockMvcRequestBuilders.get(path + id).accept(MediaType.APPLICATION_JSON));
	}
	
	protected ResultActions performSimplePost(String path, Object o) throws Exception {
		return performModificationAction(MockMvcRequestBuilders.post(path),o);
//		return mockMvc.perform(MockMvcRequestBuilders.post(path).contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsBytes(o)).accept(MediaType.APPLICATION_JSON));
	}
	
	protected ResultActions performSimplePut(String path,  Object o) throws Exception {
		return performModificationAction(MockMvcRequestBuilders.put(path),o);
//		return mockMvc.perform(MockMvcRequestBuilders.put(path).contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsBytes(o)).accept(MediaType.APPLICATION_JSON));
	}
	
	protected ResultActions performSimpleAction(MockHttpServletRequestBuilder mHSRB) throws Exception {
		return mockMvc.perform(mHSRB.accept(MediaType.APPLICATION_JSON));
	}
	
	private ResultActions performModificationAction(MockHttpServletRequestBuilder mHSRB,Object o) throws Exception{
		return mockMvc.perform(mHSRB.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(o)).accept(MediaType.APPLICATION_JSON));
	} 

}
