package com.mouritech.appointmentscheduling.service;

import com.mouritech.appointmentscheduling.dto.RegisterDto;
import com.mouritech.appointmentscheduling.exceptions.DetailsNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.NotEligibleRegisterException;
import com.mouritech.appointmentscheduling.exceptions.UserNameExistsException;

public interface RegisterService {
	
	
	public Object register(RegisterDto registerDto) throws NotEligibleRegisterException,DetailsNotFoundException,UserNameExistsException;
	

}
