package it.uniroma3.facade;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.model.Utente;

@Stateless 
public class UtenteFacade {
	@PersistenceContext(unitName = "controller-unit")
	private EntityManager em;
	
	private Map<String,Utente> utenti;
	
	public UtenteFacade() {
	this.utenti = new HashMap<String,Utente>();
	Utente utente = new Utente("Roberto","Roberto",1);
	utenti.put(utente.getUsername(), utente);
	
	utente = new Utente("Simona","Simona",2);
	utenti.put(utente.getUsername(), utente);
	
	}
	
	public Utente inserisciUtente(String username, String password, int ruolo) {
		Utente utente = new Utente(username,password,ruolo);
		em.persist(utente);
		return utente;
		}
	public Utente getUtente(String username) {
		Utente utente = em.find(Utente.class, username);
		return utente;
	}
	

}
