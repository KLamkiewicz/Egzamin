package com.example.jeedemo.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Producent;
import com.example.jeedemo.domain.Wlasciciel;
import com.example.jeedemo.service.ProducentManager;

@SessionScoped
@Named("producentBean")
public class ProducentFormBean implements Serializable{

	private Producent producent = new Producent();
	private ListDataModel<Producent> producenci = new ListDataModel<Producent>();
	private List<SelectItem> lista = new ArrayList<SelectItem>();
	
	@Inject
	ProducentManager pm;
	
	public Producent getProducent() {
		return producent;
	}
	
	public void setProducent(Producent producent) {
		this.producent = producent;
	}
	
	public void addProducent(){
		pm.addProducent(producent);
		//return null;
	}
	
	
	public List<Producent> getAllProducenci(){
		return pm.getAllProducenci();
	}
	
	
	public String deleteProducent(Producent producent){
		pm.deleteProducent(producent);
		return null;
	}
	
	public String deleteProducentTabela(){
		pm.deleteProducent(producent);
		return null;
	}
	
	public String doEdycji(Producent producent){
		this.producent = producent;
		return "edytujProducenta";
	}
	
	public String doEdycjiTabela(){
		return "edytujProducenta.xhtml?faces-redirect=true";
	}
	
	public String edytujProducent(){
		pm.edytujProducent(producent);
		this.producent = new Producent();
		return null;
	}
	
    public void destroyWorld(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");  
          
        FacesContext.getCurrentInstance().addMessage(null, message);  
    } 
	
}
