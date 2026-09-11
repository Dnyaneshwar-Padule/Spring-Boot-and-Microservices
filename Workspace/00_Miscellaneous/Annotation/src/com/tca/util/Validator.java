package com.tca.util;

import java.lang.reflect.Field;

import com.tca.annotation.Validate;

public class Validator {

	public static boolean validate(Object ob) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = ob.getClass().getDeclaredFields();
		
		for(Field field : fields) {
			Validate validate = field.getAnnotation(Validate.class);
			if(validate == null)
				continue; 
			
			field.setAccessible(true);
			
			String value = (String)field.get(ob);
			int len = value == null ? 0 : value.length();
			
			if(validate.required() && ( value == null || value.isBlank()) )
				return false;
			
			if(len < validate.minLen() )
				return false;
			
			if(len > validate.maxLen() )
				return false;
		}
		
		return true;
	}
	
}
