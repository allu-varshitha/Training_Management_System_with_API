package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dao.TrainingDAOImpl;
import com.rgt.employee.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addusers")   //assigning the url
public class Addusers extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("application/json");
	    Gson gson=new Gson();
	    PrintWriter out = resp.getWriter();
	    
	    User u = gson.fromJson(req.getReader(), User.class);
	    
	    TrainingDAO tdao = new TrainingDAOImpl();
	    boolean result = tdao.insertUsers(u);
	    
	    if (result) {
	        out.print("Data saved successfully");
	    } else {
	        out.print("Data not saved");
	    }
	    out.flush();

		}
}