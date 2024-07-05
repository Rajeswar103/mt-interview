package com.mouritech.appointmentscheduling.exceptions;

public class SearchNotFoundException extends Exception{
	
	public String getMessage()
	{
		return "{\"your enter data is incorrect pls enter these fileds only VIP,TTD,Public\"}";
		
	}

}
