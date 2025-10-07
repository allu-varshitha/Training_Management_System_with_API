package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dao.TrainingDAOImpl;
import com.rgt.employee.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteuser")
public class deleteuser extends HttpServlet{

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        
        PrintWriter out = resp.getWriter();
        int uid=Integer.parseInt(req.getParameter("uid"));
        
        User u=new User();
        u.setUid(uid);
        
        TrainingDAO tdao = new TrainingDAOImpl();
        boolean result=tdao.deleteUser(u);
        if(result) {
        	out.print("delete success");
        }else {
        	out.println("delete fail");
        }
        
        
		
	}
}
