package com.rgt.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rgt.employee.connection.Connector;
import com.rgt.employee.dto.Training;
import com.rgt.employee.dto.User;

public class TrainingDAOImpl implements TrainingDAO{

	ArrayList<User> ulist=new ArrayList<>();
	ArrayList<Training> tlist=new ArrayList<>();
	
	private Connection con;	
	public TrainingDAOImpl() {
		this.con = Connector.requestConnection();
	}

	@Override
	public boolean insertUsers(User u) {
		String query= "insert into users values(0,?,?)";
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,u.getUname());
			ps.setString(2,u.getUrole());
			
			i=ps.executeUpdate();//i=1
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean insertTraining(Training t) {
		String query ="insert into training values(0,?,?)";
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, t.getTitle());
			ps.setObject(2, t.getDuedate());
		
			i=ps.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	public ArrayList<User> getUser() {
		String query="select *from users ";		
		ArrayList<User> ulist1=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();		
			while(rs.next()) {
				User u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUrole(rs.getString("urole"));
				ulist1.add(u);				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ulist1;
	}

	@Override
	public ArrayList<Training> getTraining() {
		String query="select * from training ";
		ArrayList<Training> tlist1=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()) {
				Training t=new Training();
			t.setTid(rs.getInt("tid"));
//			System.out.println("id added");
//			System.out.println(rs.getInt("tid"));
				t.setTitle(rs.getString("title"));
				t.setDuedate(rs.getDate("dueDate").toString());
              	t.setMapstatus(getstatus(rs.getInt("tid")));
				tlist1.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return tlist1;
	}

	@Override
	public boolean deleteUser(User u) {
		String query="delete from users where uid=?";
		PreparedStatement ps;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, u.getUid());
			i=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteTraining(Training t) {
		String query="delete from training where tid=?";
		PreparedStatement ps;
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, t.getTid());
			i=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}else {
			return false;
		}	
	}

	@Override
	public boolean updateUser(User u) {
		String query="update users set uname=?,urole=? where uid=?";
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,u.getUname());
			ps.setString(2, u.getUrole());
			ps.setInt(3, u.getUid());
			i=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}else {
			return false;

		}

}

	@Override
	public boolean updateTraining(Training t) {
         String query = "update training set title=?,duedate=? where tid=?";
         int i=0;
         try {
        	 PreparedStatement ps=con.prepareStatement(query);
        	 ps.setString(1, t.getTitle());
        	 ps.setObject(2,t.getDuedate());
        	 ps.setInt(3, t.getTid());
        	 i=ps.executeUpdate();
         }catch(SQLException e) {
        	 e.printStackTrace();
         }
         if(i>0) {
        	 return true;
         }else {
         
        	 return false;
         }
         
	}
    public Map<Integer,String> getstatus(int tid){
    	
    	String query="select uid,status from trainingassignment where tid=?";
    	 Map<Integer,String> getstatus=new HashMap<>();
    	try {
    		PreparedStatement ps=con.prepareStatement(query);
    		ps.setInt(1, tid);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next()) {
    			int uid=  rs.getInt("Uid");
    		 String status=rs.getString("status");
//    		 System.out.println(rs.getString("status"));   		 
    		 getstatus.put(uid,status);
   
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		return getstatus;
    	
    }


	@Override
	public boolean assigntraining(int uid, int tid) {
         String query = "insert into trainingassignment values (?,?,?)";
         int i=0;
         try {
        	 PreparedStatement ps=con.prepareStatement(query);
        	 ps.setInt(1,uid);
        	 ps.setInt(2, tid);
        	 ps.setString(3, "pending");
        	 i=ps.executeUpdate();
         }catch(SQLException e) {
        	 e.printStackTrace();
         }
         if(i>0) {
        	 return true;
         }else {
     		return false;

         }
	
	}

	@Override
	public boolean markcomplete(int uid,int tid) {
      String query=" update trainingassignment set status=? where uid=? and tid=? ";
      int i=0;
      try {
    	  PreparedStatement ps=con.prepareStatement(query);
    	  ps.setString(1, "completed");
    	  ps.setInt(2, uid);
    	  ps.setInt(3, tid);
    	  i=ps.executeUpdate();
      }catch(SQLException e) {
    	  e.printStackTrace();
      }
      if(i>0) {
    	  return true;
      }
      else {
		return false;
	}
}

	@Override
	public ArrayList<Training> getoverdue() {
		String query=" select * from training where duedate <? ";// to print due dates
//		String query=" select * from training where duedate >? ";// to print future due dates
//		String query=" select * from training where duedate =? ";// to priint todays due dtae

		ArrayList<Training> duelist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setObject(1,LocalDate.now());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Training t=new Training();
				t.setTid(rs.getInt("Tid"));
				t.setTitle(rs.getString("Title"));
				t.setDuedate(rs.getDate("duedate").toString());
				t.setMapstatus(getstatus(t.getTid()));//status to training object
				duelist.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return duelist;
	}

	
	@Override
	public ArrayList<Training> getassignedtrainings(int uid) {
	
		String query="select tid from trainingassignment where uid=?";
		ArrayList<Training> assigntraining=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			ArrayList<Training> training=getTraining();
			while(rs.next()) {
				int tid=rs.getInt("Tid");
				for(int i=0;i<training.size();i++) {
					Training t= training.get(i);
					if(t.getTid()==tid) {
						assigntraining.add(t);
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return assigntraining;
	}

	@Override
	public List<Training> searchkey(String title) {

		String query="select * from training where title like ?";
		
		ArrayList<Training> searchkey = new ArrayList<>();
		try {
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,"%"+title+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Training t=new Training();
				t.setTid(rs.getInt("Tid"));
				t.setTitle(rs.getString("Title"));
				t.setDuedate(rs.getDate("duedate").toString());
				t.setMapstatus(getstatus(t.getTid()));
				
				searchkey.add(t);				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return searchkey;
	}

	@Override
	public void multipleuserspending(List<Integer> uids, int tid) {

		String query="insert into trainingassignment values(?,?,?)";
		int i=0;
		for(int j=0;j<uids.size();j++) {
			
//			assigntraining(uids.get(j), tid); 
			
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1,uids.get(j));
				ps.setInt(2, tid);
				ps.setString(3, "pending");
				i=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(i>0) {
				System.out.println("Training assigned successfully to user: "+uids.get(j));
			}else {
				System.out.println("Training not assigned to user: "+uids.get(j));
			}
		}
	}

	@Override
	public List<Training> getduebydate(String date) {
		String query=" select * from training where duedate <= ?  ";

		ArrayList<Training> duelist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setObject(1,date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Training t=new Training();
				t.setTid(rs.getInt("Tid"));
				t.setTitle(rs.getString("Title"));
				t.setDuedate(rs.getDate("duedate").toString());
				t.setMapstatus(getstatus(t.getTid()));
				duelist.add(t);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return duelist;
	}

	@Override
	public User getUserById(int uid) {

		String query="select * from users where uid=?";
		User u=new User();

		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUrole(rs.getString("urole"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Training> gettrainingwithinrange(String fromdate, String todate) {

		String query="select * from Training where duedate>=? and duedate<=?";
		ArrayList<Training> duelist=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setObject(1, fromdate);
			ps.setObject(2, todate);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Training t=new Training();
				t.setTid(rs.getInt("tid"));
				t.setTitle(rs.getString("title"));
				t.setDuedate(rs.getDate("duedate").toString());
				t.setMapstatus(getstatus(t.getTid()));
				duelist.add(t);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return duelist;
	}
	
	
}



	


