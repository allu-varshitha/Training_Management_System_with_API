package com.rgt.employee.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.rgt.employee.dao.TrainingDAOImpl;
import com.rgt.employee.dao.TrainingDAO;
import com.rgt.employee.dto.Training;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatetraining")
public class updatetraining extends HttpServlet {

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    resp.setContentType("application/json");
		    Gson gson=new Gson();
		    PrintWriter out = resp.getWriter();

		    Training t = gson.fromJson(req.getReader(), Training.class);
             
            TrainingDAO tdao= new TrainingDAOImpl();
		    boolean result = tdao.updateTraining(t);

		    if (result) {
		        out.print("Data updated successfully");
		    } else {
		        out.print("Data not updated");
		    }

		    out.flush();

}
}
