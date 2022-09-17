package com.academy.businesscomponent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.academy.businesscomponent.model.Impiegato;

public class DeleteImp {
	public static void main(String[] args) {
	EntityManagerFactory emF = Persistence.createEntityManagerFactory("ProgettoJPA");
	//creo l'entity manager tramite il factory
	EntityManager em = emF.createEntityManager();
	
	em.getTransaction().begin();
	//avvio la transazoine
	
	Impiegato imp = em.find(Impiegato.class, 1); 
	
	em.remove(imp);
	
	em.getTransaction().commit();
	
	em.close();
	emF.close();
	
}

}
