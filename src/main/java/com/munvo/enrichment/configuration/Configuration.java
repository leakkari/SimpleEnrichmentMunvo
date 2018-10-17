package com.munvo.enrichment.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * This class reads the configuration file
 * @author leaakkari
 *
 */
public class Configuration {
	

    private String studentName;
    private String type;
    private String fileName;
    
    
    public static void main(String[] args) {
    	Configuration conf = new Configuration();
	
    }
    
    
    public Configuration() {
        Config config = ConfigFactory.load();
        this.studentName = config.getString("name");
        this.type = config.getString("type");
        this.fileName = config.getString("fileName");
        
        // throw exception when file type and filename don't match
        if(this.type.equals("JSON")) {
        	if(!this.fileName.equals("subscriber.json")) {
        		throw new IllegalArgumentException("Invalid file name");
        	}
        	
        }
        else if(this.type.equals("CSV")) {
        	if(!this.fileName.equals("subscriber.csv")) {
        		throw new IllegalArgumentException("Invalid file name");
        	}
        }
        else {
        	throw new IllegalArgumentException("Invalid File Type");
        }
        
    }
    

    public String getStudentName() {
        return studentName;
    }

    public String getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }
    
    public void printSetting(String path, Config config) {
   
		System.out.println("The setting '" + path + "' is: " + config.getString(path));
    }
}