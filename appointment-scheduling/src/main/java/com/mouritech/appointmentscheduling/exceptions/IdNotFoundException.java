package com.mouritech.appointmentscheduling.exceptions;

public class IdNotFoundException extends Exception{

	public String getMessage()
	{
		return "{\"your Id is not found\"}";
		
	}

}
