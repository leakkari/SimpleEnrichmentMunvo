package com.munvo.enrichment.parser;

import org.json.JSONException;
import org.json.JSONObject;

import com.munvo.enrichment.model.Subscriber;

/**
 * Parsing class for JSON file
 * @author leaakkari
 *
 */
public class JsonParse implements FileReaderParser {
	
	@Override
	public  Subscriber parseSubscriber(String subLine)  {
	
			JSONObject js;
			
			try {
				js = new JSONObject(subLine);
				int id = (int)Integer.parseInt(js.getString("id"));
				String phone = js.getString("phone");
				String name = js.getString("name");
				
				Subscriber sub = new Subscriber(id, name, phone);
				System.out.println(sub.toString());
				
				return sub;
				
			} catch (JSONException e) {
				System.out.println("Invalid Input");
		
			}
				
		return null;
		
	}
	

}
