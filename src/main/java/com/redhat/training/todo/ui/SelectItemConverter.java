package com.redhat.training.todo.ui;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.redhat.training.todo.model.Group;

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
			s = ((Group) value).getId().toString();
		}
		return s;
	}
	
	private Group getSelectedItemAsEntity(UIComponent comp, String value) {
		Group person = null;
		System.out.println("value: !!!!!" + value);
		Set<Group> selectPersons = null;
		for (UIComponent uic : comp.getChildren()) {
			if (uic instanceof UISelectItems) {
				Long personId = Long.valueOf(value);
				System.out.println("personId: !!!!!" + personId);
				selectPersons = (Set<Group>) ((UISelectItems) uic).getValue();
				System.out.println("***SelectPersons: ****" + selectPersons);
				
				if(personId !=null && selectPersons != null && !selectPersons.isEmpty()) {
					
					
					
					  for (Group group : selectPersons) {
					    if (group.getId().equals(personId)) {
					    	System.out.println("Encontre!!" + group);
					    	person = group;
					      break;
					    }
					  }
					
					//Predicate<Group> predicate = i -> i.getId().equals(personId);
					//person = selectPersons.stream().filter(predicate).findFirst().orElse(null);
					//person = selectPersons.stream().filter(null).findFirst().orElse(null);
				}
				
			}
		}
		
		return person;
	}
	
}
