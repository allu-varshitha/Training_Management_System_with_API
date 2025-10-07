package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dto.Training;
import com.rgt.employee.dao.TrainingDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gettrainings")
public class gettrainings extends HttpServlet {
	 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
    	
    	resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        
    	 TrainingDAO tdao = new TrainingDAOImpl();
         List<Training> trainings = tdao.getTraining();

         Gson gson = new Gson();
         String jsonresponse = gson.toJson(trainings);
         
         
         out.print(jsonresponse);
         out.flush();
    }


}
