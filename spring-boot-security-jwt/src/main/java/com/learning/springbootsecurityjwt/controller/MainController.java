package com.learning.springbootsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springbootsecurityjwt.model.AuthenticationRequest;
import com.learning.springbootsecurityjwt.model.AuthenticationResponse;
import com.learning.springbootsecurityjwt.service.MyUserDetailsService;
import com.learning.springbootsecurityjwt.util.JwtUtil;

@RestController
public class MainController {
	
	//Before Java 9 it used to be a default bean but it doesn't exist anymore so we have to override it in SecquirityConfiguration class
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello User !";
	}
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		
		//first we need to authenticate the request, and for that we need to get handle to AuthenticationManger instance
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
		}catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		 final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
}
