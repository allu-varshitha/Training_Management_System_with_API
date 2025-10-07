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

@WebServlet("/assigntraining")
public class assigntraining extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out=resp.getWriter();
         
    	TrainingDAO tdao = new TrainingDAOImpl();
    	
    	int uid = Integer.parseInt(req.getParameter("uid"));
        int tid = Integer.parseInt(req.getParameter("tid"));
        
        boolean result = tdao.assigntraining(uid, tid);

        out.print(result);
    }
        
}
