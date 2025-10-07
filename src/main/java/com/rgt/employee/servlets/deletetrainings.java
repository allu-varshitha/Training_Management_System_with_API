package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dao.TrainingDAOImpl;
import com.rgt.employee.dto.Training;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletetraining")
public class deletetrainings extends HttpServlet{
   @Override
protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   resp.setContentType("application/json");
       
       PrintWriter out = resp.getWriter();
       int tid=Integer.parseInt(req.getParameter("tid"));
       
       Training t =new Training();  
       t.setTid(tid);
       
       TrainingDAO tdao = new TrainingDAOImpl();
       boolean result=tdao.deleteTraining(t);
       if(result) {
       	out.print("delete success");
       }else {
       	out.println("delete fail");
       }
}
}
