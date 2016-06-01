package it.uniroma3.facade;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

import it.uniroma3.controller.action.facadeAutenticazione;
import it.uniroma3.model.Utente;

@Stateless 
public class UtenteFacade {
	@PersistenceContext(unitName = "controller-unit")
	private EntityManager em;
	private Map<String,Utente> utenti;
	
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}
	public Map<String, Utente> getUtenti() {
		return utenti;
	}
	public void setUtenti(Map<String, Utente> utenti) {
		this.utenti = utenti;
	}
	
	public UtenteFacade() {
	this.utenti = new HashMap<String,Utente>();
	Utente utente = new Utente("Roberto","Roberto",1);
	utenti.put(utente.getUsername(), utente);
	inserisciUtente(utente.getUsername(),utente.getPassword(),utente.getRuolo());
	
	utente = new Utente("Simona","Simona",2);
	utenti.put(utente.getUsername(), utente);
	inserisciUtente(utente.getUsername(),utente.getPassword(),utente.getRuolo());
	
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
