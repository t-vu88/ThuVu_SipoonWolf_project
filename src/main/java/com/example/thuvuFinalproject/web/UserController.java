package com.example.thuvuFinalproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import jakarta.validation.*;

import com.example.thuvuFinalproject.domain.*;

@Controller
public class UserController {
	@Autowired
    private AppUserRepository userRepo;
	
	@Autowired
    private TeamRepository teamRepo; 
	
    @RequestMapping(value = "signup")
    public String addUser(Model model){	
    	model.addAttribute("signupform", new SignupForm());
        return "signup";
    }	
    
    /**
     * Create new user
     * Check if user already exists & form validation
     * 
     * @param signupForm
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "saveuser", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
    	if (!bindingResult.hasErrors()) { // validation errors
    		if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) { // check password match		
	    		String pwd = signupForm.getPassword();
		    	BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		    	String hashPwd = bc.encode(pwd);
	
		    	AppUser newUser = new AppUser();
		    	newUser.setPasswordHash(hashPwd);
		    	newUser.setUsername(signupForm.getUsername());
		    	newUser.setRole("PARENT");
		    	newUser.setEmail(signupForm.getEmail());
		    	
		    	Team team = teamRepo.findByName(signupForm.getTeamName()).get(0);
                newUser.setTeam(team); 
                
                if (userRepo.findByEmail(signupForm.getEmail()) != null) {
                    bindingResult.rejectValue("email", "err.email", "Email already exists");
                    return "signup";
                }
                
		    	if (userRepo.findByUsername(signupForm.getUsername()) == null) { // Check if user exists
		    		userRepo.save(newUser);
		    	}
		    	else {
	    			bindingResult.rejectValue("username", "err.username", "Username already exists");    	
	    			return "signup";		    		
		    	}
    		}
    		else {
    			bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");    	
    			return "signup";
    		}
    	}
    	else {
    		return "signup";
    	}
    	return "redirect:/login";    	
    }    
    
}

