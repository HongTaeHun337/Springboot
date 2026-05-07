package com.test.java.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.model.AddressDao;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {
	
	private final AddressDao dao;
	
	@GetMapping("/count")
	public int count(){
		
		return dao.count();
	}

}
