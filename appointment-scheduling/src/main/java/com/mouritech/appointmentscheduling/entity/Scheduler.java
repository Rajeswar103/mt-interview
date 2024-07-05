package com.mouritech.appointmentscheduling.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="scheduler_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scheduler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "title",nullable = false)
	private String title;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "scheduled_date",nullable = false)
    private LocalDate scheduledDate;
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name = "time_slot_start",nullable = false)
    private LocalTime timeSlotStart;
	@Column(name = "end_date",nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
	@JsonFormat(pattern = "HH:mm:ss")
	@Column(name = "time_slot_end",nullable = false)
    private LocalTime timeSlotEnd;
	@Column(name = "meeting_mode",nullable = false)
    private String meetingMode;
	@Column(name = "meeting_category",nullable = false)
    private String meetingCategory;
	@Column(name = "location",nullable = false)
    private String location;
	@Column(name = "detailed_description",nullable = false)
    private String detailedDescription;
	@Column(name = "agenda",nullable = false)
    private String agenda;
	@Column(name = "priority",nullable = false)
    private String priority;
	@Column(name = "approval_comments")
    private String approvalComments;
	@Column(name = "approval")
    private Boolean approval;
	private String userName;
}
