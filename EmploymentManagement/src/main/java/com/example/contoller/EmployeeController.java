package com.example.contoller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.requestBody.EmployeeRequest;
import com.example.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody EmployeeRequest request) {
		return service.createUser(request);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getUser(@PathVariable Integer id){
		return service.getusers(id);
	}
	
	@PutMapping
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody EmployeeRequest request){
		return service.updateUser(request);
	}
	
	@DeleteMapping
	public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody EmployeeRequest request){
		return service.deleteUser(request);
	}
}
