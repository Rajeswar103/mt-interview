package com.mouritech.appointmentscheduling.exceptions;

public class NotEligibleException extends Exception {
	
	public String getMessage()
	{
		return "{\"approval and approvalcomments these fields are for only admin perseptive pls these fields be empty \"}";
		
	}

}
