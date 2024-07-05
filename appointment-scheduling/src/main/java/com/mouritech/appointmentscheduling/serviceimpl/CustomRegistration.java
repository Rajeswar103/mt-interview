package com.mouritech.appointmentscheduling.serviceimpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mouritech.appointmentscheduling.dao.RegisterRepository;
import com.mouritech.appointmentscheduling.entity.Register;


@Service
public class CustomRegistration implements UserDetailsService {
	
	@Autowired
	private RegisterRepository registerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Register user = registerRepository.findByUserName(username);
	     RegistrationInfo registrationInfo=null;
		if(user==null)
		{
			throw new UsernameNotFoundException(username);
		}
		registrationInfo=new RegistrationInfo();
		registrationInfo.setRegister(user);
		return registrationInfo;
	}

}
