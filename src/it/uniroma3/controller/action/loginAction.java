package it.uniroma3.controller.action;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import it.uniroma3.*;
import it.uniroma3.model.Utente;

public class loginAction implements Action,facadeAutenticazione {
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

	@Override
	public Utente login(String username, String password) {
		Utente utente = new Utente();
		utente.setPassword(getPassword());
		utente.setRuolo(getRuolo());
		utente.setUsername(getUsername());
		return utente;
	}

	public String esegui(HttpServletRequest request) throws ServletException  {
		facadeAutenticazione authService = new loginAction();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utente utente = authService.login(username, password);
		if (utente!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("utente",utente);
			return "OK";
		} else
			return "KO";
	}
}