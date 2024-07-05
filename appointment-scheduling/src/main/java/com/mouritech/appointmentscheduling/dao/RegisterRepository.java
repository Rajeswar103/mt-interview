package com.mouritech.appointmentscheduling.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.appointmentscheduling.entity.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer> {
	
	
	Register findByUserName(String username);

}
