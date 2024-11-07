package com.bobby.category.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bobby.category.jwt.webToken.JwtService;
import com.bobby.category.jwt.webToken.LoginForm;

@RestController
public class ContentController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private MyUserDetailService myUserDetailService;

	
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
		
	Authentication authentication =	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginForm.username(), loginForm.password()
				));
	
	            if(authentication.isAuthenticated()) {
	            return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.username()));
	            } else {
	            	throw new UsernameNotFoundException("Invalid Credintials");
	            }
	            	
		
	}
	
}
