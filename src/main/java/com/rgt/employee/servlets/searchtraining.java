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

@WebServlet("/searchtraining")
public class searchtraining extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("application/json");
        Gson gson=new Gson();
        PrintWriter out = resp.getWriter();

        String title = req.getParameter("title");
        if (title == null) {
        	title = ""; 
        }

        TrainingDAO tdao = new TrainingDAOImpl();
        List<Training> trainings = tdao.searchkey(title);

        String json = gson.toJson(trainings);
        out.print(json);
        out.flush();
    }
}
