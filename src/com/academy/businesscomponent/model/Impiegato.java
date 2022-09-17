package com.academy.businesscomponent.model;

import javax.persistence.Column;
import javax.persistence.Entity; //i pacchetti di EE7 iniziano tutti con javaX
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//metto l'annotation come entity - gli sto dicendo di creare una tabella da qui
@Entity 
@Table(name = "IMPIEGATO")
@NamedQuery(name = "Cerca impiegato per ID", query = "Select i from Impiegato i where i.id = :id") 
public class Impiegato { 
	//Per AI si possono usare sia le sequenze che l'AI. In Oracle meglio usare sequenze
//	@GeneratedValue(strategy=GenerationType.AUTO) 
	@GeneratedValue(generator="impiegato_gen") 
	@SequenceGenerator(name="impiegato_gen",sequenceName="imp_seq", allocationSize=1)
	@Column(name="ID_IMP") 
	@Id 
	private int id; //campi tramite attributi
	private String nome;
	@Column(name="STIPENDIO")
	private double stipendio;
	@Column(name="REPARTO")
	private String reparto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Impiegato(int id, String nome, double stipendio, String reparto) {
		  this.id = id;
		  this.nome = nome;
		  this.stipendio = stipendio;
		  this.reparto = reparto;
		 }
		 
		 public Impiegato() {
		 }
		 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	public String getReparto() {
		return reparto;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	@Override
	public String toString() {
		return "Impiegato [id=" + id + ", nome=" + nome + ", stipendio=" + stipendio + ", reparto=" + reparto + "]";
	}
	
	//il costruttore deve essere per forza quello vuoto, quindi o non lo metto o lo devo creare

	
}
