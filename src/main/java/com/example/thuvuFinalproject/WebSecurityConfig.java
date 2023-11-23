package com.example.thuvuFinalproject;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.example.thuvuFinalproject.web.UserDetailServiceImplement;
import com.example.thuvuFinalproject.domain.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImplement userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(antMatcher("/")).permitAll()
				.requestMatchers(antMatcher("/teaminfo")).permitAll()
				.requestMatchers(antMatcher("/u8")).permitAll()
				.requestMatchers(antMatcher("/u9")).permitAll()
				.requestMatchers(antMatcher("/u10")).permitAll()
				.requestMatchers(antMatcher("/u11")).permitAll()
				.requestMatchers(antMatcher("/css/**")).permitAll()
				.requestMatchers(antMatcher("/signup")).permitAll()
				.requestMatchers(antMatcher("/saveuser")).permitAll()
				.anyRequest().authenticated()
			)
			
			.formLogin(formlogin -> formlogin
					.loginPage("/login")
	                .successHandler(successHandler())
	                .permitAll()
	         )
			.logout(logout -> logout
				.permitAll()
				.logoutSuccessUrl("/")
			);
		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
    public AuthenticationSuccessHandler successHandler() {
        return new SimpleUrlAuthenticationSuccessHandler() {
            @Override
            
            protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response,
                    Authentication authentication) {
            	
            	CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
                AppUser appUser = customUserDetails.getAppUser();
                String teamName = appUser.getTeam().getName();
                return "/info?team=" + teamName;
            }
        };
	}
	
}

