package com.rgt.employee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import com.google.gson.Gson;
import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dao.TrainingDAOImpl;
import com.rgt.employee.dto.Training;

@WebServlet("/addtrainings")
public class addtrainings extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json"); 
	    PrintWriter out = resp.getWriter();
	    Gson gson=new Gson();
	    Training t = gson.fromJson(req.getReader(), Training.class);
	    
	    TrainingDAO tdao = new TrainingDAOImpl();
	    boolean result = tdao.insertTraining(t);
	    if (result) {
	        out.print("Data saved successfully");
	    } else {
	        out.print("Data not saved");
	    }

	    out.flush();

		}
    }

 

