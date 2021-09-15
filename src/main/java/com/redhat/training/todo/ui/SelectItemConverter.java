package com.redhat.training.todo.ui;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.redhat.training.todo.model.Grupo;
import com.redhat.training.todo.model.Person;

@FacesConverter(value="SelectItemToEntityConverter")
public class SelectItemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
		Object o = null;
		if (!(value == null || value.isEmpty())) {
			o = this.getSelectedItemAsEntity(comp, value);
		}
		return o;
	}
	
	@Override
	public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
		String s = "";
		if (value != null) {
			if (value instanceof Grupo) {
				s = ((Grupo) value).getId().toString();
			}
			if (value instanceof Person) {
				s = ((Person) value).getId().toString();
			}
		}
		return s;
	}
	
	private Object getSelectedItemAsEntity(UIComponent comp, String value) {
		//private Grupo getSelectedItemAsEntity(UIComponent comp, String value) {
		Grupo gperson = null;
		Person pperson = null;
		System.out.println("value: !!!!!" + value);
		Set<Grupo> selectGPersons = null;
		Set<Person> selectPPersons = null;
		String tipo = null;
		for (UIComponent uic : comp.getChildren()) {
			if (uic instanceof UISelectItems) {
				
				Long gpersonId = Long.valueOf(value);
				Long ppersonId = Long.valueOf(value);			
				
				tipo = comp.getId();
				
				if (tipo.equals("personF")) {
					System.out.println("()()()() person ()()()()");
					selectPPersons = (Set<Person>) ((UISelectItems) uic).getValue(); //arreglar esta
					  if(ppersonId !=null && selectPPersons != null && !selectPPersons.isEmpty()) {
						  for (Person p : selectPPersons) { 
							
							  if (p.getId().equals(ppersonId)) {
						  		  System.out.println("Encontre!!" + p); 
						  		  pperson = p; 
						  		  break; 
						  		  } 
							  }
					  }
				} else
					{ System.out.println("()()()() grupo ()()()()");				
					selectGPersons = (Set<Grupo>) ((UISelectItems) uic).getValue(); //arreglar esta
					}
										
					
					  if(gpersonId !=null && selectGPersons != null && !selectGPersons.isEmpty()) {
						  for (Grupo grupo : selectGPersons) { 
							
							  if (grupo.getId().equals(gpersonId)) {
						  		  System.out.println("Encontre!!" + grupo); 
						  		  gperson = grupo; 
						  		  break; 
						  		  } 
							  }
					  }
					 /* 
					 * //Predicate<Group> predicate = i -> i.getId().equals(personId); //person =
					 * selectPersons.stream().filter(predicate).findFirst().orElse(null); //person =
					 * selectPersons.stream().filter(null).findFirst().orElse(null); }
					 */
					//selectCadaPersona = (Set<Person>) ((UISelectItems) uic).getValue();
				
			}
		}
		if (tipo.equals("personF")) { 
			return pperson;
		} else
			return gperson;
		//return cadaPersona;
	}
	
}
