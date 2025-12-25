package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.repository.UserRepository;
import com.example.request.AuthenticationRequest;
import com.example.response.AuthenticationResponse;

@Service
public class AuthenticationService {
	private final UserRepository repository;
	private final JwtService jwtService ;
	private final AuthenticationManager authenticationManager;
	@Autowired
	public AuthenticationService(JwtService jwtService,UserRepository repository,AuthenticationManager authenticationManager) {
		this.jwtService=jwtService;
		this.authenticationManager=authenticationManager;
		this.repository=repository;
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails user = repository.findByUsername(request.getUsername());
		var jwt = jwtService.generateToken(user);
		 return new AuthenticationResponse(jwt);

	}

}
