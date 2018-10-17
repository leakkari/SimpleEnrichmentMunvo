package com.munvo.enrichment.input;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONException;

import com.munvo.enrichment.configuration.Configuration;
import com.munvo.enrichment.model.Subscriber;
import com.munvo.enrichment.parser.CsvParse;
import com.munvo.enrichment.parser.FileReaderParser;
import com.munvo.enrichment.parser.JsonParse;

/**
 * This class implements the input source
 * @author leaakkari
 *
 */
public class InputSource {
	
    private Map<Integer, Subscriber> subscriberMap;
    
    /**
     * This Method returns a File Reader Parser depending on the on the type of the configuration file
     * @param conf
     * @return JsonParse if configuration type is JSON, CsvParse if configuration type is CSV
     */
    public static  FileReaderParser getType(Configuration conf) {
    	
    	if(conf.getType().equals(null)) {
    		return null;
    	}
    	
    	if(conf.getType().equals("JSON")) {
    		return new JsonParse();
    	}
    	
    	else if(conf.getType().equals("CSV")) {
    		return new CsvParse();
    	}
    	else {
    		return null;
    	}
    	
    }

    public InputSource(FileReaderParser fileReaderParser, String filename) throws URISyntaxException, IOException {
        List<String> inRecords =
                Files.readAllLines(
                        Paths.get(Thread
                                .currentThread()
                                .getContextClassLoader()
                                .getResource(filename).toURI()), Charset.defaultCharset());
        // read map
        subscriberMap =
                inRecords.stream()
                        .map(t -> {
							try {
								return fileReaderParser.parseSubscriber(t);
							} catch (JSONException e) {
								System.out.println("invalid");
							}
							return null;
						})
                        .collect(Collectors.toMap(Subscriber::getId, s -> s));
    }

    public Subscriber query(int id) {
        return subscriberMap.get(id);
    }
    
    
}
