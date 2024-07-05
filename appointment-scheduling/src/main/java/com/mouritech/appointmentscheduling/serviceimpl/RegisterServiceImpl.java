package com.mouritech.appointmentscheduling.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mouritech.appointmentscheduling.dao.RegisterRepository;
import com.mouritech.appointmentscheduling.dto.RegisterDto;
import com.mouritech.appointmentscheduling.entity.Register;
import com.mouritech.appointmentscheduling.exceptions.DetailsNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.NotEligibleRegisterException;
import com.mouritech.appointmentscheduling.exceptions.UserNameExistsException;
import com.mouritech.appointmentscheduling.service.RegisterService;
@Profile(value = { "dev","appoinmentscheduling" })
@Service
public class RegisterServiceImpl implements RegisterService{
	
	
	@Autowired
	private RegisterRepository registerRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Object register(RegisterDto registerDto) throws NotEligibleRegisterException, DetailsNotFoundException, UserNameExistsException {
		Register response = mapToEntity(registerDto);
		if(Objects.isNull(response))
		{
			throw new DetailsNotFoundException();
		}
		List<Register> list = registerRepository.findAll();
		boolean usernameExists = list.stream().anyMatch(s -> s.getUserName().equals(registerDto.getUserName()));
		if(usernameExists)
		{
			throw new UserNameExistsException();
		}
		String password=response.getPassword();
		if(response.getAccessKey().equals("Admin$%@!"))
		{
			response.setRole("ADMIN");
			response.setPassword(passwordEncoder.encode(password));
			registerRepository.save(response);
			return "{\"Hello Admin..............\"}";
			
		}
		else if(response.getAccessKey().equals("Minister$%@!"))
		{
			response.setRole("MINISTER");
			response.setPassword(passwordEncoder.encode(password));
			registerRepository.save(response);
			return "{\"Hello Minister.....................\"}";
		}
		else if(response.getAccessKey().equals("Scheduler$%@!"))
		{
			response.setRole("SCHEDULER");
			response.setPassword(passwordEncoder.encode(password));
			registerRepository.save(response);
			return "{\"Hello Scheduler...................\"}";
		}
		throw new NotEligibleRegisterException();
	}
	
	private Register mapToEntity(RegisterDto registerDto)
	{
		return modelMapper.map(registerDto,Register.class);
		
	}

	

}
