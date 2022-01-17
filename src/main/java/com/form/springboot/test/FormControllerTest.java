package com.form.springboot.test;

import static org.junit.Assert.assertThrows;

import javax.validation.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.form.springboot.FormController;
import com.form.springboot.model.User;
import com.form.springboot.service.ValidationService;

import ch.qos.logback.classic.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FormControllerTest {
	
    private static final Logger logger = (Logger) LoggerFactory.getLogger(FormControllerTest.class);
	
    @Autowired
    MockMvc mockMvc;
 
    @Autowired
    ObjectMapper objectmapper;
 
    @Test
    public void testGetForm() throws Exception{   	
    	mockMvc.perform(MockMvcRequestBuilders
                .get("/form")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());   
    }
    
    @Test
    public void testPostForm() throws Exception{   	   	
    	MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/form")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectmapper.writeValueAsString(getUser()));
    	
    	mockRequest.param("name", getUser().getName());
    	mockRequest.param("surname", getUser().getSurname());
    	mockRequest.param("userAddress", getUser().getUserAddress());
    	mockRequest.param("email", getUser().getEmail());
    	mockRequest.param("city", getUser().getCity());
    	mockRequest.param("message", getUser().getMessage());

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    private User getUser() {
    	User user = new User();
    	user.setEmail("mail@mail.com");
    	user.setName("Nanemo");
    	user.setSurname("Surname");
    	user.setCity("Barcelona");
    	user.setUserAddress("C/Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77");
    	user.setMessage("This is a Message");
		return user;    	
    }
}
