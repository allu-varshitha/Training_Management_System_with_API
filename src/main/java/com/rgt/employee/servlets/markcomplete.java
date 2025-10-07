package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dao.TrainingDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/markcomplete")
public class markcomplete extends HttpServlet{

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TrainingDAO tdao = new TrainingDAOImpl();
        PrintWriter out=resp.getWriter();
    	int uid = Integer.parseInt(req.getParameter("uid"));
        int tid = Integer.parseInt(req.getParameter("tid"));
        
        boolean result = tdao.markcomplete(uid, tid);

        resp.setContentType("application/json");
        out.print(result);
		
	}
}
