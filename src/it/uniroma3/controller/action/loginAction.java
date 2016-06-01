package it.uniroma3.controller.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import it.uniroma3.*;
import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Utente;

@WebServlet("/loginAction")
public class loginAction extends HttpServlet implements Action,facadeAutenticazione {
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
		UtenteFacade utenteF = new UtenteFacade();
		return utenteF.getUtente(username);
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