package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;
import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dao.TrainingDAOImpl;
import com.rgt.employee.dto.Training;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getduebydate")
public class getduebydate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Gson gson=new Gson();

        String date = req.getParameter("date");

        TrainingDAO tdao = new TrainingDAOImpl();
        List<Training> duelist = tdao.getduebydate(date);

        String json = gson.toJson(duelist);
        out.print(json);
        out.flush();
    }
		
	}
	

