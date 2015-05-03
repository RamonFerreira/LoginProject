package com.LoginProject.validator.system;

import java.util.Map;

public class FieldValidator {
    
	private static FieldValidator instance = null; 
	public static  FieldValidator  getInstance(){
		if(instance == null){
			instance = new FieldValidator();
		}
		return instance;
	}
	protected FieldValidator(){}
	public Boolean isFilledFields(Map fields){
		Boolean retrn = Boolean.TRUE;
		Map<String, String[]> requestParams =fields;
    	StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
			String key = entry.getKey();         // parameter name
			String[] value = entry.getValue();   // parameter values as array of String
			String valueString = "";
			
			if (value[0].isEmpty()) {
				retrn = Boolean.FALSE;
			}
				
			
		}
		return retrn;
	}

}
