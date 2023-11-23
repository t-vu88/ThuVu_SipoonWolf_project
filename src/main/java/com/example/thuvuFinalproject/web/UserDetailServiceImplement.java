package com.example.thuvuFinalproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.thuvuFinalproject.domain.*;


@Service
public class UserDetailServiceImplement implements UserDetailsService  {
	private final AppUserRepository AppUserRepo;

	@Autowired
	public UserDetailServiceImplement(AppUserRepository userRepository) {
		this.AppUserRepo = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	AppUser curruser = AppUserRepo.findByUsername(username);
        return new CustomUserDetails(curruser);
        		
    }   
} 

