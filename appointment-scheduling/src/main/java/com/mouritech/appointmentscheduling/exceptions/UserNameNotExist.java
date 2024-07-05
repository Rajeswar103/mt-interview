package com.mouritech.appointmentscheduling.exceptions;

public class UserNameNotExist  extends Exception{
	
	public String getMessage()
	{
		return "{\"Your UserName is not exist....\"}";
		
	}

}
