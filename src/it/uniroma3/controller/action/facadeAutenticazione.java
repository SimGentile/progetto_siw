	package it.uniroma3.controller.action;

import it.uniroma3.model.Utente;

public interface facadeAutenticazione {
 		public Utente login(String username, String password);
 	}
