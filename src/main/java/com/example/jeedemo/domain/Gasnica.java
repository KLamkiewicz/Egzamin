package com.example.jeedemo.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

@Entity
@NamedQuery(name ="gasnica.getAllGasnice" , query = "Select g FROM Gasnica g ")
public class Gasnica {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Min(300)
	private double pojemnosc;
//	private int rokProdukcji;
	@Temporal(TemporalType.DATE)
	@Past
	private Date dataProdukcji;
	private String kodSeryjny = "";
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
//	public int getRokProdukcji() {
//		return rokProdukcji;
//	}
//	public void setRokProdukcji(int rokProdukcji) {
//		this.rokProdukcji = rokProdukcji;
//	}
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
	public String getKodSeryjny() {
		return kodSeryjny;
	}
	public void setKodSeryjny(String kodSeryjny) {
		this.kodSeryjny = kodSeryjny;
	}
	public Date getDataProdukcji() {
		return dataProdukcji;
	}
	public void setDataProdukcji(Date dataProdukcji) {
		this.dataProdukcji = dataProdukcji;
	}

	
}
