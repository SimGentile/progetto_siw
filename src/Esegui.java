import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Utente;

public class Esegui {
	public static void main(String[] args) {
		Utente utente = new Utente("Simona","simona",1);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("controller-unit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(utente);
		tx.commit();
		em.close();
		emf.close();
		
	}
}
