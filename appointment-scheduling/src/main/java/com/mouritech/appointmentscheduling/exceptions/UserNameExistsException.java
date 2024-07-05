package com.mouritech.appointmentscheduling.exceptions;

public class UserNameExistsException  extends Exception{
	
	
	public String getMessage()
	{
		return "{\"user name is already exists pls try another username\"}";
		
	}

}
