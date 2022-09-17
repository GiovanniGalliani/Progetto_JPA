package com.academy.businesscomponent;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Select {
	public static void main(String[] args) {
		
	
	EntityManagerFactory emF = Persistence.createEntityManagerFactory("ProgettoJPA");
	EntityManager em = emF.createEntityManager();
	
	//JPQL -> query di interrograzione tramite JPA
	Query q = em.createQuery(
			"select upper(i.nome) from Impiegato i");
	List<?> lista = q.getResultList();
	
	for(Object i : lista)
		System.out.println("Impiegato: " +i);
	
	Query q2 = em.createQuery("Select count(i.stipendio) from Impiegato i"); //count richiama long
	long conteggio = (Long) q2.getSingleResult();
	System.out.println("Conteggio: "+conteggio);
	
	Query q3 = em.createQuery("Select i from Impiegato i where i.nome like 'M%' order by i.nome, i.stipendio desc"); //per select all non si usa * ma i
	List<?> lista2 = q3.getResultList();
	for(Object i : lista2)
		System.out.println("Impiegato: " +i);
	
	Query q4 = em.createNamedQuery("Cerca impiegato per ID");
	q4.setParameter("id", 8);
	List<?> lista3 = q4.getResultList();
	for(Object i : lista3)
		System.out.println("Impiegato: "+i);
	
	Query q5 = em.createQuery("Select i from Impiegato i where i.id = :id");
	q5.setParameter("id", 8);
	List<?> lista5 = q5.getResultList();
	for(Object i : lista5)
		System.out.println("Impiegato: "+i);

	}
		
}
