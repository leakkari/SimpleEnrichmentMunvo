package com.munvo.enrichment;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.munvo.enrichment.configuration.Configuration;
import com.munvo.enrichment.input.InputSource;
import com.munvo.enrichment.model.Call;
import com.munvo.enrichment.model.EnrichedCall;
import com.munvo.enrichment.parser.FileReaderParser;

public class Main {
	
    private static List<Call> calls = new ArrayList<Call>(Arrays.asList(
            new Call(1, "2018-07-12", 1),
            new Call(2, "2018-07-12", 3),
            new Call(3, "2018-07-13", 2),
            new Call(4, "2018-07-13", 3)
    ));
    
    public static void main(String[] args) {
        // Get an instance of Configuration using Singleton pattern
        Configuration configuration = new Configuration();

        // Instantiate an input stream converter
        FileReaderParser fileReaderParser = InputSource.getType(configuration);

        // Inject the file reader parser
		try {
			InputSource inputSource = new InputSource(fileReaderParser, configuration.getFileName());
			
	        calls.stream()
            .map(c -> new EnrichedCall(c, inputSource.query(c.getSubscriberId())))
            .forEach(EnrichedCall::toString);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}

    }

}
