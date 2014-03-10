package com.ipp.findagame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

@Test
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class HomePageControllerTest extends AbstractTestNGSpringContextTests{
	
	@Autowired 
	private WebApplicationContext ctx;
	 
	private MockMvc mockMvc;
	
	@BeforeClass
	public void beforeClass() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}


	@Test
	public void getDummyPlayer() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/welcome","")).
		andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.request().attribute("message", "whatsup!"));
	}

	@Test
	public void welcome() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/player","")).
		andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.
				content().contentTypeCompatibleWith("application/json"));
	}
}
