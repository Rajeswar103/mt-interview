package com.mouritech.appointmentscheduling.exceptions;

public class EmptyException extends Exception{
	public String getMessage()
	{
		return "{\"your databse is empty \"}";
		
	}

}
