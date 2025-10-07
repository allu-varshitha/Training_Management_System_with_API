package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.rgt.employee.dto.Training;
import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dao.TrainingDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getoverdue")
public class getoverdue extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
         
    	  resp.setContentType("application/json");
          PrintWriter out = resp.getWriter();

          TrainingDAO tdao = new TrainingDAOImpl();
          ArrayList<Training> duelist = tdao.getoverdue();

          Gson gson = new Gson();
          String json = gson.toJson(duelist);
          out.print(json);
          out.flush();
          
    } 	
}
