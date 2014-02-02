package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Gasnica;
import com.example.jeedemo.domain.Producent;
import com.example.jeedemo.domain.Wlasciciel;

@Stateless
public class GasnicaManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void addGasnica(Gasnica gasnica) {
		gasnica.setId(null);
		em.persist(gasnica);
	}
	
	public void addProducentToGasnica(Long gasnicaId, Long producentId){
		Gasnica gasnica = em.find(Gasnica.class, gasnicaId);
		Producent producent = em.find(Producent.class, producentId);
		gasnica.setProducent(producent);
	}
	
	public void addWlascicielToGasnicaList(Long gasnicaId, List<Wlasciciel> tempList){
		Gasnica gasnica = em.find(Gasnica.class, gasnicaId);
		for(Wlasciciel w : tempList)
			gasnica.getWlasciciele().add(w);
		//gasnica.setWlasciciele(tempList);
	}
	

//	
	public void addWlascicielToGasnica(Long gasnicaId, List<Long> listaId){
		Gasnica gasnica = em.find(Gasnica.class, gasnicaId);
		for(Long id : listaId){
			Wlasciciel wlasciciel = em.find(Wlasciciel.class, id);
			gasnica.getWlasciciele().add(wlasciciel);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Gasnica> getAllGasnice(){
		return em.createNamedQuery("gasnica.getAllGasnice").getResultList();
	}

	public EntityManager getEm() {
		return em;
	}

	public void deleteGasnica(Gasnica gasnica){
		gasnica = em.find(Gasnica.class, gasnica.getId());
		em.remove(gasnica);
	}
	
	public void edytujGasnica(Gasnica gasnica){
		
		em.merge(gasnica);
	}
	
}
