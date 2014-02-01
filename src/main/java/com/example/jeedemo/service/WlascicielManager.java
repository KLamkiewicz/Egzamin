package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Wlasciciel;

@Stateless
public class WlascicielManager {

	@PersistenceContext
	EntityManager em;
	
	public void addWlasciciel(Wlasciciel wlasciciel){
		wlasciciel.setId(null);
		em.persist(wlasciciel);
	}
	
	public List<Wlasciciel> getAllWlasciciele(){
		return em.createNamedQuery("wlasciciel.getAll").getResultList();
	}
	
	public Wlasciciel getWlascicielId(Long wlascicielId){
		return em.find(Wlasciciel.class, wlascicielId);
	}
	
	public void deleteWlasciciel(Wlasciciel wlasciciel){
		wlasciciel = em.find(Wlasciciel.class, wlasciciel.getId());
		wlasciciel.setDeleted(true);
		//em.remove(wlasciciel);	
	}
	
	public void edytujWlasciciel(Wlasciciel wlasciciel){
		em.merge(wlasciciel);
	}
}
