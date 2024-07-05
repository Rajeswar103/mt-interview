package com.mouritech.appointmentscheduling.exceptions;

public class ApprovedDetailsExcepection extends Exception {
	
	
	
	public String getMessage()
	{
		return "{\"your enter data is incorrect pls enter these fileds only VIP,TTD,Public or based on Category and Approved Details are not found\"}";
		
	}

}
