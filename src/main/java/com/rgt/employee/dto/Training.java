package com.rgt.employee.dto;

import java.util.HashMap;
import java.util.Map;

public class Training {

	private int tid;
	private String title;
	private String duedate;
	private Map<Integer,String> mapstatus = new HashMap<>();
	
	
	public Training(String title, String duedate, Map<Integer, String> mapstatus) {
		this.title = title;
		this.duedate = duedate;
		this.mapstatus = mapstatus;
	}
	public Training() {
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDuedate() {
		return duedate.toString();
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate.toString();
	}
	
	
	public Map<Integer, String> getMapstatus() {
		return mapstatus;
	}
	public void setMapstatus(Map<Integer, String> mapstatus) {
		this.mapstatus = mapstatus;
	}
	public void assignTraining(int uid2) {

		this.mapstatus.put(uid2,"pending");
	}

	public void markcomplete(int uid3) {
		this.mapstatus.put(uid3, "completed");
	}
	
	
}
