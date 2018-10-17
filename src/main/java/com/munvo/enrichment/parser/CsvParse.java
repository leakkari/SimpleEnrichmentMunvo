package com.munvo.enrichment.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.json.JSONException;

import com.munvo.enrichment.model.Subscriber;

/**
 * Parsing class for CSV file
 * @author leaakkari
 *
 */
public class CsvParse implements FileReaderParser{

	@Override
	public Subscriber parseSubscriber(String subLine) throws JSONException {
		BufferedReader br = new BufferedReader(new StringReader(subLine));
	    try {
			String line = br.readLine();
			//split line at comma, since it is a csv file
			String[] parts = line.split(",");
			
			//part[0] = id, part[1] = name, part[2] = phone
			Subscriber sub = new Subscriber(Integer.parseInt(parts[0]), parts[1], parts[2]);
			return sub;
			
		} catch (IOException e) {
			System.out.println("Invalid Input");
		}

		
		return null;
	}

}
