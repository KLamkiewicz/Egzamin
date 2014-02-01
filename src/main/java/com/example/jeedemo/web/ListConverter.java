package com.example.jeedemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.example.jeedemo.domain.Wlasciciel;
import com.example.jeedemo.service.GasnicaManager;
import com.example.jeedemo.service.WlascicielManager;

//@FacesConverter("listaConverter")
@FacesConverter(forClass = Wlasciciel.class, value="listaConverter")
public class ListConverter implements Converter {
	
	@Inject
	GasnicaFormBean gb;
	@Inject 
	WlascicielManager wm;
	@Inject
	GasnicaManager gm;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null){
			return null;
		}
		return gm.getEm().find(Wlasciciel.class, Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return "";
		}
		if(value instanceof Wlasciciel){
			return String.valueOf(((Wlasciciel) value).getId());
		}
		return "";
	}

}
