package com.form.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.form.springboot.model.User;
import com.form.springboot.service.ValidationService;

@Controller
public class FormController {
	
    @GetMapping("/")
    public String index() {
        return "redirect:/form";
    }

    @GetMapping("/form")
    public String formGet() {
        return "form";
    }

    @PostMapping("/form")
    public String formPost(User user, Model model) {
    	ValidationService.checkEmail(user.getEmail());
    	ValidationService.checkName(user.getName());
    	ValidationService.checkName(user.getSurname());
    	ValidationService.checkAddress(user.getUserAddress());
        model.addAttribute("user", user);
        return "form";
    }
}
