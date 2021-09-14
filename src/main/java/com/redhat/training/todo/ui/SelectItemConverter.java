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
	
	private Grupo getSelectedItemAsEntity(UIComponent comp, String value) {
		Grupo person = null;
		Person cadaPersona = null;
		System.out.println("value: !!!!!" + value);
		Set<Grupo> selectPersons = null;
		Set<Person> selectCadaPersona = null;
		for (UIComponent uic : comp.getChildren()) {
			if (uic instanceof UISelectItems) {
				
				Long personId = Long.valueOf(value);
				Long cadaPersonaId = Long.valueOf(value);
				  System.out.println("()()()() person ()()()()" + comp.getId()); //grupo or person
				 // System.out.println("(.)(.)(.)(.) cadaPerson ()()()()" + cadaPersonaId);
				System.out.println("personId: !!!!!" + personId);
				System.out.println("***Tipo de UISelectItems: ****" + UISelectItems.COMPONENT_FAMILY);
				
				
				//selectCadaPersona = (Set<Person>) ((UISelectItems) uic).getValue(); //arreglar esta
				
				//if(cadaPersonaId !=null && selectCadaPersona != null && !selectCadaPersona.isEmpty()) {					
					//  for (Person persona : selectCadaPersona) {
					 //   if (persona.getId().equals(cadaPersonaId)) {
					   // 	System.out.println("Encontre!!" + persona);
					   // 	cadaPersona = persona;
					   //   break;
					   // }
					//  }
					
					//Predicate<Group> predicate = i -> i.getId().equals(personId);
					//person = selectPersons.stream().filter(predicate).findFirst().orElse(null);
					//person = selectPersons.stream().filter(null).findFirst().orElse(null);
				//}
				
					selectPersons = (Set<Grupo>) ((UISelectItems) uic).getValue(); //arreglar esta
					System.out.println("***SelectPersons: ****" + selectPersons);
					
					
					  if(personId !=null && selectPersons != null && !selectPersons.isEmpty()) {
						  for (Grupo grupo : selectPersons) { 
							
							  if (grupo.getId().equals(personId)) {
						  		  System.out.println("Encontre!!" + grupo); 
						  		  person = grupo; 
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
		 
		return person;
		//return cadaPersona;
	}
	
}
