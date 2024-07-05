package com.mouritech.appointmentscheduling.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mouritech.appointmentscheduling.dao.RegisterRepository;
import com.mouritech.appointmentscheduling.dao.SchedulerRepository;
import com.mouritech.appointmentscheduling.dto.SchedulerDto;
import com.mouritech.appointmentscheduling.entity.Register;
import com.mouritech.appointmentscheduling.entity.Scheduler;
import com.mouritech.appointmentscheduling.exceptions.ApprovedDetailsExcepection;
import com.mouritech.appointmentscheduling.exceptions.DetailsNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.EmptyException;
import com.mouritech.appointmentscheduling.exceptions.IdNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.NotEligibleException;
import com.mouritech.appointmentscheduling.exceptions.SearchNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.UserNameNotExist;
import com.mouritech.appointmentscheduling.service.SchedulerService;
@Profile(value = { "dev","appoinmentscheduling" })
@Service
public class SchedulerserviceImpl implements SchedulerService{
	
	
	@Autowired
	private SchedulerRepository schedulerRepository;
	
	
	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Object createSchedules(SchedulerDto scheduleDto) throws DetailsNotFoundException, NotEligibleException, UserNameNotExist {
		Scheduler response = modelMapper.map(scheduleDto,Scheduler.class);
		if(Objects.isNull(response))
		{
			throw new DetailsNotFoundException();
		}
		List<Register> list = registerRepository.findAll();
		
		boolean usernameExists = list.stream().anyMatch(s -> s.getUserName().equals(scheduleDto.getUserName()) && s.getRole().equals("SCHEDULER"));
		if(Objects.isNull(response.getApproval()) && Objects.isNull(response.getApprovalComments()))
		{
			if(usernameExists)
			{	
	        schedulerRepository.save(response);
	        return "{\"your schedule details are saved.............\"}";
			}
			else
			{
				throw new UserNameNotExist();
			}
		}
		 throw new NotEligibleException();
	   
	}

	@Override
	public Object updateSchedules(SchedulerDto scheduleDto) throws DetailsNotFoundException {
		
		Scheduler response = modelMapper.map(scheduleDto,Scheduler.class);
		if(Objects.isNull(response))
		{
			throw new DetailsNotFoundException();
		}
	        schedulerRepository.save(response);
	        return "{\"updated.............\"}";
	}

	@Override
	public List<SchedulerDto> getAllSchedules() throws EmptyException {
		
		List<Scheduler> listOfSchedules = schedulerRepository.findAll();
		if(Objects.isNull(listOfSchedules))
		{
			throw new EmptyException();
		}
		List<SchedulerDto> listOfSchedulesDto=new ArrayList<>();
		for(Scheduler s:listOfSchedules)
		{
			SchedulerDto response = mapToDto(s);
			listOfSchedulesDto.add(response);
		}
		return listOfSchedulesDto;
	}
	
	public SchedulerDto mapToDto(Scheduler schedule)
	{
		return modelMapper.map(schedule,SchedulerDto.class);
		
	}
	@Override
	public Object updateSchedulesById(Integer id, SchedulerDto schedulerDto) throws IdNotFoundException {
		Optional<Scheduler> schedulerOption = schedulerRepository.findById(id);
		Scheduler scheduler = schedulerOption.get();
		if(Objects.isNull(scheduler.getId()))
		{
			throw new IdNotFoundException();
		}
		scheduler.setApproval(schedulerDto.getApproval());
		scheduler.setApprovalComments(schedulerDto.getApprovalComments());
		schedulerRepository.save(scheduler);
		return "Updated Successfully........";
		
	}

	@Override
	public List<SchedulerDto> getAllSchedulesBasedOnCategory(String category) throws SearchNotFoundException, EmptyException {
		 List<Scheduler> listOfSchedules = schedulerRepository.findBymeetingCategory(category);
		 if(Objects.isNull(listOfSchedules))
		 {
			throw new EmptyException();
		 }
		 if(schedulerRepository.findBymeetingCategory(category).isEmpty())
		 {
			 throw new SearchNotFoundException();
		 }
		 List<SchedulerDto> listOfSchedulesDto=new ArrayList<>();
		 for(Scheduler s:listOfSchedules)
		 {
			 SchedulerDto response = mapToDto(s);
				listOfSchedulesDto.add(response);
		 }
		return listOfSchedulesDto;
	}

	@Override
	public List<SchedulerDto> getAllSchedulesBasedOnCategoryAndApproval(String category) throws EmptyException, ApprovedDetailsExcepection {
		List<Scheduler> listOfSchedules = schedulerRepository.findBymeetingCategoryAndApproval(category,true);
		List<SchedulerDto> listOfSchedulesDto=new ArrayList<>();
		 if(Objects.isNull(listOfSchedules))
		 {
			 throw new EmptyException();
		 }
		 if(schedulerRepository.findBymeetingCategoryAndApproval(category,true).isEmpty())
		 {
			 throw new ApprovedDetailsExcepection();
		 }
		for(Scheduler s:listOfSchedules)
		{
			SchedulerDto response = mapToDto(s);
			listOfSchedulesDto.add(response);
		}
		return listOfSchedulesDto;
	}

	@Override
	public List<SchedulerDto> getAllSchedulesBasedOnUserName(String username) throws EmptyException {
		
		List<Scheduler> listOfUserNames = schedulerRepository.findByuserName(username);
		List<SchedulerDto> listOfSchedulerDto=new ArrayList<>();
		if(Objects.isNull(listOfSchedulerDto))
		throw new EmptyException();
		
		for(Scheduler s:listOfUserNames)
		{
			SchedulerDto dto = mapToDto(s);
			listOfSchedulerDto.add(dto);
		}
		
		return listOfSchedulerDto;
	}

	

	
	
	

	

}
