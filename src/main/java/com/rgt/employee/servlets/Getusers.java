package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dao.TrainingDAOImpl;
import com.rgt.employee.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/getusers")
public class Getusers extends HttpServlet {
    private TrainingDAO tdao=new TrainingDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = tdao.getUser();

        Gson gson = new Gson();
        String jsonresponse = gson.toJson(users);

        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();
        out.print(jsonresponse);
        out.flush();
    }
}