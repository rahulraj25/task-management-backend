package com.hackerrank.stackhack.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class TaskModel {
	
	@Id
	String id;
	//Add name
	String description;
	String label;
	Date dueDate;
	Date createdDate;
	String status;
	
	
	public TaskModel() {
		this.description = "Demo Desctiption";
		this.label = "Demo Label";
		this.dueDate = new Date();
		this.createdDate = new Date();
		this.status = "demo Status";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
