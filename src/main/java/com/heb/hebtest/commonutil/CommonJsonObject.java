package com.heb.hebtest.commonutil;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public  class CommonJsonObject<T> {
	
	protected String jsonStringForObj = "";
	
	public CommonJsonObject( String sourceJson, Class<T> targetObj) {
			this.jsonStringForObj = sourceJson;
	}

	public T objectFromJsaon(String json, Class<T> proto) {
		// TODO Auto-generated method stub
		ObjectMapper  mapper = new  ObjectMapper ();
		T ret = null;
		try {
			ret = mapper.readValue( json, proto);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	


}
