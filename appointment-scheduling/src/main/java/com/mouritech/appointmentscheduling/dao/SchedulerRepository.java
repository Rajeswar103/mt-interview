package com.mouritech.appointmentscheduling.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.appointmentscheduling.entity.Scheduler;


@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler,Integer>{
	
	
	List<Scheduler> findBymeetingCategory(String category);
	List<Scheduler>findBymeetingCategoryAndApproval(String catergory,Boolean approval);
	List<Scheduler> findByuserName(String username);

}
