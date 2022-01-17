package com.form.springboot.service;

import java.util.regex.Pattern;

import javax.validation.ValidationException;

public class ValidationService {
	
    private static final String EMAIL_REGEXP = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Integer MAX_NAME_LENGHT = 120;
    private static final Integer MAX_ADDRESS_LENGHT = 240;

	private static boolean patternMatches(String emailAddress, String regexPattern) {
	    return Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE)
	      .matcher(emailAddress)
	      .matches();
	}
	
	public static void checkEmail(String emailAddress) {
        if(!patternMatches(emailAddress,EMAIL_REGEXP)) {
            throw new ValidationException("Email Format not Correct: " + emailAddress);
        }
	}
	
	public static void checkName(String name) {
        if(name.length()>MAX_NAME_LENGHT) {
            throw new ValidationException("Exceeded characters for value: " + name);
        }
	}
	
	public static void checkAddress(String address) {
        if(address.length()>MAX_ADDRESS_LENGHT) {
            throw new ValidationException("Exceeded characters for address: " + address);
        }
	}

}
