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

@WebServlet("/getwithindates")
public class getwithindates extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Gson gson=new Gson();

        String date1 = req.getParameter("date1");
        String date2= req.getParameter("date2");

        TrainingDAO tdao = new TrainingDAOImpl();
        List<Training> duelist = tdao.gettrainingwithinrange(date1,date2);

        String json = gson.toJson(duelist);
        out.print(json);
        out.flush();
		
	}
}