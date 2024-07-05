package com.mouritech.appointmentscheduling.service;

import java.util.List;

import com.mouritech.appointmentscheduling.dto.SchedulerDto;
import com.mouritech.appointmentscheduling.exceptions.ApprovedDetailsExcepection;
import com.mouritech.appointmentscheduling.exceptions.DetailsNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.EmptyException;
import com.mouritech.appointmentscheduling.exceptions.IdNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.NotEligibleException;
import com.mouritech.appointmentscheduling.exceptions.SearchNotFoundException;
import com.mouritech.appointmentscheduling.exceptions.UserNameNotExist;

public interface SchedulerService  {
	
	
	
	public Object createSchedules(SchedulerDto scheduleDto) throws DetailsNotFoundException,NotEligibleException, UserNameNotExist;
	public Object updateSchedules(SchedulerDto  scheduleDto) throws DetailsNotFoundException;
	public List<SchedulerDto> getAllSchedules() throws EmptyException;
	public Object updateSchedulesById(Integer id,SchedulerDto schedulerDto) throws IdNotFoundException;
	public List<SchedulerDto> getAllSchedulesBasedOnCategory(String category) throws EmptyException, SearchNotFoundException;
	public List<SchedulerDto> getAllSchedulesBasedOnCategoryAndApproval(String category) throws  EmptyException, ApprovedDetailsExcepection;
	public List<SchedulerDto> getAllSchedulesBasedOnUserName(String username) throws  EmptyException;
	
	
	

}
