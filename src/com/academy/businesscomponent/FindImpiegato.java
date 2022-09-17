package com.academy.businesscomponent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.academy.businesscomponent.model.Impiegato;

public class FindImpiegato {
	public static void main(String[] args) {
		EntityManagerFactory emF = Persistence.createEntityManagerFactory("ProgettoJPA");
		//creo l'entity manager tramite il factory
		EntityManager em = emF.createEntityManager();
		
		em.getTransaction().begin();
		//avvio la transazoine
		
		Impiegato imp = em.find(Impiegato.class, 1); //l'1 � il parametro di ricerca, l'ID
		System.out.println(imp);
		
		imp.setStipendio(2200.00);
		em.getTransaction().commit();
		System.out.println(imp);
		
		em.close();
		emF.close();
	
	}
}
