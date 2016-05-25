package it.uniroma3.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.model.TipologiaDiEsame;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("controller-unit");
		EntityManager em = emf.createEntityManager();

		TipologiaDiEsame tipo1 = new TipologiaDiEsame();
		tipo1.setNome("ARSTANG");
		tipo1.setPrezzo(3.5);
		tipo1.setDescrizione("A wonderful bla bla");
		EntityTransaction tx = em.getTransaction();
		tx.begin(); 
		em.remove(tipo1); 
		tx.commit();
		emf.close();
	}
}
