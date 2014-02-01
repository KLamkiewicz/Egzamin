package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name ="gasnica.getAllGasnice" , query = "Select g FROM Gasnica g ")
public class Gasnica {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double pojemnosc;
	private int rokProdukcji;
	@ManyToOne
	private Producent producent;
	@ManyToMany
	private List<Wlasciciel> wlasciciele = new ArrayList<Wlasciciel>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPojemnosc() {
		return pojemnosc;
	}
	public void setPojemnosc(double pojemnosc) {
		this.pojemnosc = pojemnosc;
	}
	public int getRokProdukcji() {
		return rokProdukcji;
	}
	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}
	public Producent getProducent() {
		return producent;
	}
	public void setProducent(Producent producent) {
		this.producent = producent;
	}
	public List<Wlasciciel> getWlasciciele() {
		return wlasciciele;
	}
	public void setWlasciciele(List<Wlasciciel> wlasciciele) {
		this.wlasciciele = wlasciciele;
	}


	
}
