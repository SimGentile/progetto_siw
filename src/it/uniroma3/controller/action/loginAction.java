package it.uniroma3.controller.action;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import it.uniroma3.*;
import it.uniroma3.model.Utente;

public class loginAction implements Action {
	private String username="";
	private String password="";
	private int ruolo=0;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRuolo() {
		return ruolo;
	}

	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}

	public loginAction(){}

	public Utente Login(String username, String password) {
		Utente utente = new Utente();
		utente.setPassword(getPassword());
		utente.setRuolo(getRuolo());
		utente.setUsername(getUsername());
		return utente;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {			
		String prossimaPagina = "fallimento.jsp";
		loginAction login = new loginAction();
		String esito = login.perform(request);
		if (esito.equals("OK"))
			prossimaPagina = "/risorsaProtetta.jsp";
		ServletContext application  = request.getSession().getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(prossimaPagina);
		rd.forward(request, response);
	}


public String perform(HttpServletRequest request) {
	username = request.getParameter("username");
	password = request.getParameter("password");
	Utente utente = Login(username, password);
	if (utente!=null) {
		HttpSession session = request.getSession();
		session.setAttribute("utente",utente);
		return "OK";
	} else
		return "KO";
}
}