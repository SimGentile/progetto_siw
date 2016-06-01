package it.uniroma3.controller;
import javax.persistence.*;

import java.io.IOException;
import java.util.Scanner;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.controller.action.Action;


public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String nextPage = null;
		String actionName = path2action(request);
		Action action;
		try {
			action = (Action)Class.forName(actionName).newInstance();
			nextPage = action.esegui(request);
		} catch (Exception e) {
			nextPage = "/index.jsp";
		} 
		nextPage = response.encodeURL(nextPage);
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	private String path2action(HttpServletRequest request) {

		String path = request.getPathInfo(); 

		String modelCommand = path.substring(1);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(modelCommand).useDelimiter("\\.");
		String model = scanner.next();
		model = model.substring(0,1).toUpperCase() + model.substring(1);

		String action = scanner.next();
		action = action.substring(0,1).toUpperCase() + action.substring(1);

		return "it.uniroma3.controller.action." + action + model;


	}
}
