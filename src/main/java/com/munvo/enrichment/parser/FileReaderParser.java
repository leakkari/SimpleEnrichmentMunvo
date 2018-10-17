package com.munvo.enrichment.parser;

import org.json.JSONException;

import com.munvo.enrichment.model.Subscriber;

/**
 * Interface parser for JSON and CSV files
 * @author leaakkari
 *
 */

public interface FileReaderParser {
	
    public Subscriber parseSubscriber(String subLine) throws JSONException;

}


          



	
	
	



