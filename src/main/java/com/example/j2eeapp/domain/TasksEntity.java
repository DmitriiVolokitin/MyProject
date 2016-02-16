package com.example.j2eeapp.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;


/**
 * Entity to hold application user data - first name, last name, etc.
 * 
 * @author Arthur Vin
 */

@SuppressWarnings("deprecation")
@Entity
@Table(name="tasks")
public class TasksEntity extends BaseEntity {
	private static final long serialVersionUID = -8789920462809744548L;

	private String short_name;
	private String full_name;
	
	public String getShort_Name() {
		return short_name;
	}
	public void setShort_Name(String short_name) {
		this.short_name = short_name;
	}
	public String getFull_Name() {
		return full_name;
	}
	public void setFull_Name(String full_name) {
		this.full_name = full_name;
	}
		
}
