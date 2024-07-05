package com.mouritech.appointmentscheduling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestJwtToken {
	
	
	private String username;
	private String password;
	
	
	

}
