package com.example.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.example.requestBody.EmployeeRequest;

public interface EmployeeService {

	ResponseEntity<Map<String, Object>> createUser(EmployeeRequest request);

	ResponseEntity<Map<String, Object>> getusers(Integer id);

	ResponseEntity<Map<String, Object>> updateUser(EmployeeRequest request);

	ResponseEntity<Map<String, Object>> deleteUser(EmployeeRequest request);

}
