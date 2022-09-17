package com.academy.businesscomponent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.academy.businesscomponent.model.Impiegato;
//DEVO CREARE IL GESTORE DELLE ENTITY E POI FARE LE TRANSAZIONI CON QUELLO
public class CreateImpiegato {
	public static void main(String[] args) {
		EntityManagerFactory emF = Persistence.createEntityManagerFactory("ProgettoJPA");
		//creo l'entity manager tramite il factory
		EntityManager em = emF.createEntityManager();
		
		em.getTransaction().begin();
		//avvio la transazoine
		
		Impiegato imp = new Impiegato();
		imp.setNome("Massimo");
		imp.setStipendio(2000);
		imp.setReparto("Vendite");
		
		em.persist(imp); //equivalente di save
		em.getTransaction().commit();
		
		//una volta ftta la transazione chiudo tutte cose
		em.close();
		emF.close();
	}
}
