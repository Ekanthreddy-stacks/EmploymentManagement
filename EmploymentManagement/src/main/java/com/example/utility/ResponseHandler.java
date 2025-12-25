package com.example.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public class ResponseHandler {

	private static final Map<String, Object> map = new HashMap<>();
	public static ResponseEntity<Map<String, Object>> response(Object data,String message ,boolean status){
		map.put("data", data);
		map.put("message", message);
		map.put("status", status);
		return ResponseEntity.ok(map);
	}
}
