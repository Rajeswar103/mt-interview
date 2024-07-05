package com.mouritech.appointmentscheduling.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulerDto {
	
	private Integer id;
	private String title;
    private LocalDate scheduledDate;
    private LocalTime timeSlotStart;
    private LocalDate endDate;
    private LocalTime timeSlotEnd;
    private String meetingMode;
    private String meetingCategory;
    private String location;
    private String detailedDescription;
    private String agenda;
    private String priority;
    private String approvalComments;
    private Boolean approval;
    private String userName;

}
