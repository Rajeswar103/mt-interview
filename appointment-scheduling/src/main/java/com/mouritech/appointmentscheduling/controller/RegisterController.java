package com.mouritech.appointmentscheduling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.appointmentscheduling.dto.RegisterDto;
import com.mouritech.appointmentscheduling.exceptions.DetailsNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.NotEligibleRegisterException;
import com.mouritech.appointmentscheduling.exceptions.UserNameExistsException;
import com.mouritech.appointmentscheduling.service.RegisterService;

@RestController
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	
	
	@PostMapping("/regestration")
	public ResponseEntity<Object> register(@RequestBody RegisterDto registerDto) throws NotEligibleRegisterException, DetailsNotFoundException, UserNameExistsException
	{
		return new ResponseEntity<Object>(registerService.register(registerDto),HttpStatus.CREATED);
		
	}
	
	
}
