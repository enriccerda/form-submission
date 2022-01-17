package com.form.springboot.test;

import static org.junit.Assert.assertThrows;

import javax.validation.ValidationException;
import org.junit.Test;

import com.form.springboot.model.User;
import com.form.springboot.service.ValidationService;

public class ValidationServiceTest {
	
	@Test
	public void testMailUsingStrictRegex() {
	    assertThrows(ValidationException.class,
	            ()->{
	            	ValidationService.checkEmail(getUser().getEmail());
	            });
	}
	
	@Test
	public void testNameLenght() {
	    assertThrows(ValidationException.class,
	            ()->{
	            	ValidationService.checkName(getUser().getName());
	            });
	}
	
	@Test
	public void testSurnameLenght() {
	    assertThrows(ValidationException.class,
	            ()->{
	            	ValidationService.checkName(getUser().getSurname());
	            });
	}
	
	@Test
	public void testAddressLenght() {
	    assertThrows(ValidationException.class,
	            ()->{
	            	ValidationService.checkName(getUser().getUserAddress());
	            });
	}

    private User getUser() {
    	User user = new User();
    	user.setEmail("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmail@@mail.com");
    	user.setName("Nanemooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
    	user.setSurname("Surnameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    	user.setCity("Barcelona");
    	user.setUserAddress("C/Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 "
    			+ "Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 Fantasia 77 ");
    	user.setMessage("This is a Message");
		return user;    	
    }
}
