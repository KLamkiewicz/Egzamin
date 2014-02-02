package com.example.jeedemo.web;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("kodValidator")
public class KodValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
		int wagi[] = {8,9,2,3,4,5,6,7};
		String kod = (String) value;
		
		FacesMessage message = new FacesMessage();
		message.setSummary("Kod musi składać się z 9 cyfr");
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		
		if(kod.length()==9){
			message.setSummary("Bledny kod");
			int kodNumbers[] = new int[8];
			int controlSum=0;
			for(int i=0; i<=7; i++){
				kodNumbers[i] = Character.getNumericValue(kod.charAt(i));
				controlSum+=wagi[i]*kodNumbers[i];
			}
			if(controlSum%11==10)
				controlSum=0;
			
			if(controlSum%11!=Character.getNumericValue(kod.charAt(8))){
				throw new ValidatorException(message);
			}
				
		}
		else{
			throw new ValidatorException(message);
		}
	}

}
