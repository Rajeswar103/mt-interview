package com.mouritech.appointmentscheduling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.appointmentscheduling.dto.SchedulerDto;
import com.mouritech.appointmentscheduling.entity.RequestJwtToken;
import com.mouritech.appointmentscheduling.exceptions.ApprovedDetailsExcepection;
import com.mouritech.appointmentscheduling.exceptions.DetailsNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.EmptyException;
import com.mouritech.appointmentscheduling.exceptions.IdNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.NotEligibleException;
import com.mouritech.appointmentscheduling.exceptions.SearchNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.UserNameNotExist;
import com.mouritech.appointmentscheduling.service.SchedulerService;
import com.mouritech.appointmentscheduling.serviceimpl.JwtService;

@RestController
public class SchedulerController {
	
	
	@Autowired
	private SchedulerService schduleService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	
	@Autowired
	private JwtService jwtService;
	
	
	
	@PostMapping("/schedulemettings")
	public ResponseEntity<Object> createScheduleDetails(@RequestBody SchedulerDto schedulerDto) throws DetailsNotFoundException, NotEligibleException, UserNameNotExist
	{
		return new ResponseEntity<Object>(schduleService.createSchedules(schedulerDto),HttpStatus.CREATED);
		
	}
	@GetMapping("/getallmettingsdetails")
	public ResponseEntity<?> getAllSchedules() throws EmptyException
	{
		return new ResponseEntity<List<SchedulerDto>>(schduleService.getAllSchedules(),HttpStatus.OK);
		
	}
	@PutMapping("/updateschedulemeetings")
	public ResponseEntity<Object> upadateScheduleMeetings(@RequestBody SchedulerDto schedulerDto,@RequestParam(name="id") Integer id ) throws IdNotFoundException
	{
		return new ResponseEntity<Object>(schduleService.updateSchedulesById(id, schedulerDto),HttpStatus.CREATED);
		
	}
	@PutMapping("/updateallschedulemeetings")
	public ResponseEntity<Object> updateAllScheduleMeetings(@RequestBody SchedulerDto schedulerDto) throws DetailsNotFoundException
	{
		return new ResponseEntity<Object>(schduleService.updateSchedules(schedulerDto),HttpStatus.CREATED);
		
	}
	@GetMapping("/getallmettingsbasedoncategory")
	public ResponseEntity<?> getAllSchedulerBasedOnCategory(@RequestParam(name="category")String category) throws SearchNotFoundException, EmptyException
	{
		return new ResponseEntity<List<SchedulerDto>>(schduleService.getAllSchedulesBasedOnCategory(category),HttpStatus.OK);
		
	}
	@GetMapping("/getAllmettingsbasedoncategoryandapproval")
	public ResponseEntity<?> getAllSchedulesBasedOnCategoryAndApproval(@RequestParam(name="category")String category) throws EmptyException, ApprovedDetailsExcepection
	{
		return new ResponseEntity<List<SchedulerDto>>(schduleService.getAllSchedulesBasedOnCategoryAndApproval(category),HttpStatus.OK);
		
	}
	@GetMapping("/getAllmettingsbasedonusername")
	public ResponseEntity<?> getAllSchedulesBasedOnUserName(@RequestParam(name="username")String username) throws EmptyException
	{
		return new ResponseEntity<List<SchedulerDto>>(schduleService.getAllSchedulesBasedOnUserName(username),HttpStatus.OK);
		
	}

	@PostMapping("/generatejwttoken")
	public ResponseEntity<?> generateToken(@RequestBody RequestJwtToken requestJwtToken ) 
	{
		Authentication auth = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(requestJwtToken.getUsername(), requestJwtToken.getPassword()));
		if (auth.isAuthenticated()) {
			return new ResponseEntity<String>(jwtService.generateTokens(requestJwtToken.getUsername()), HttpStatus.CREATED);
		}
		return null;
		
		
	}

}
