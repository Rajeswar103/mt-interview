package com.mouritech.appointmentscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
	
	private Integer id;
	private String userName;
	private String password;
	private String accessKey;
	private String role;


}
