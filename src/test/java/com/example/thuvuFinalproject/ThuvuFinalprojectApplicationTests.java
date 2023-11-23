package com.example.thuvuFinalproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import com.example.thuvuFinalproject.web.TeamController;

@SpringBootTest
@AutoConfigureMockMvc
class ThuvuFinalprojectApplicationTests {

	@Autowired
	private TeamController teamController;
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(teamController).isNotNull();
	}

	@Test
    void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
	@Test
    void testU8GeneralInfoPage() throws Exception {
        mockMvc.perform(get("/u8"))
                .andExpect(status().isOk())
                .andExpect(view().name("generalInfo"));
    }
	
	@Test
    void testVisitorPage() throws Exception {
        mockMvc.perform(get("/teaminfo?team=U8"))
                .andExpect(status().isOk())
                .andExpect(view().name("teaminfoForVisitor"));
    }
}

