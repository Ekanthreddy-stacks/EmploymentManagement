package com.example.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;
import com.example.requestBody.EmployeeRequest;
import com.example.service.EmployeeService;
import com.example.utility.ResponseHandler;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	@Override
	public ResponseEntity<Map<String, Object>> createUser(EmployeeRequest request) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.isActive();
		entity.onCreate();
		entity.setEmail(request.getEmail());
		entity.setPassword(request.getPassword());
		entity.setRole(request.getRole());
		entity.onUpdate();
		entity.setUsername(request.getUsername());
	    entity =repository.save(entity);
		try {
			return ResponseHandler.response(null,"sucessfully created",true);
		} catch (Exception e) {
			return ResponseHandler.response(null,"Failed created",false);
		}
	}
	@Override
	public ResponseEntity<Map<String, Object>> getusers(Integer id) {
		EmployeeEntity users = repository.findById(id).orElse(null);
		if(users !=null) {
			return ResponseHandler.response(users,"sucessfully Fetech user details",true);
		}
		return ResponseHandler.response(null,"data not found",true);
	}
	@Override
	public ResponseEntity<Map<String, Object>> updateUser(EmployeeRequest request) {
		EmployeeEntity user = repository.findById(request.getId()).orElse(null);
		if(user !=null) {
			user.onUpdate();
			repository.save(user);
			return ResponseHandler.response(user,"sucessfully update user details",true);
		}
		return ResponseHandler.response(null,"sucessfully Fetech user details",true);
	}
	@Override
	public ResponseEntity<Map<String, Object>> deleteUser(EmployeeRequest request) {
		repository.deleteById(request.getId());
		return ResponseHandler.response(null,"sucessfully delete user details",true);
	}

}
