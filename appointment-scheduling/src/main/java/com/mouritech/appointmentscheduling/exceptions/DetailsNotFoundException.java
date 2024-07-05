package com.mouritech.appointmentscheduling.exceptions;

public class DetailsNotFoundException  extends Exception{
	
	public String getMessage()
	{
		return "{\"your are details are empty\"}";
		
	}

}
