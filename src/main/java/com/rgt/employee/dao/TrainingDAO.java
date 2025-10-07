package com.rgt.employee.dao;

import java.util.ArrayList;
import java.util.List;

import com.rgt.employee.dto.Training;
import com.rgt.employee.dto.User;

public interface TrainingDAO {
	
	public boolean insertUsers(User u);
	public boolean insertTraining(Training t);
	public ArrayList<User> getUser();
	public User getUserById(int uid);
	public ArrayList<Training> getTraining();
	public boolean deleteUser(User u);
	public boolean deleteTraining(Training t);
	public boolean updateUser(User u);
	public boolean updateTraining(Training t);
	public boolean assigntraining(int uid,int tid);
	public boolean markcomplete(int uid,int tid);
	public ArrayList<Training> getoverdue();
	public ArrayList<Training> getassignedtrainings(int uid);	
	public List<Training> searchkey(String title);
	public void multipleuserspending(List<Integer> uid,int tid);
	public List<Training> getduebydate(String date);
	public List<Training> gettrainingwithinrange(String from,String to);
	
}
