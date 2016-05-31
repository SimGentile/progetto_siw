package it.uniroma3.controller.action;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Autentica extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    					throws IOException, ServletException {

		String prossimaPagina = "/fallimento.jsp";
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
    					throws IOException, ServletException {
		String prossimaPagina = "/fallimento.jsp";
		loginAction login = new loginAction();
		String esito = login.perform(request);
		if (esito.equals("OK"))
			prossimaPagina = "/risorsaProtetta.jsp";
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}
}