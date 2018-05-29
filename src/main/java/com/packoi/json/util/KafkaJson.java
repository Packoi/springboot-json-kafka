/**
 * 
 */
package com.packoi.json.util;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packoi.json.domain.Click;

public class KafkaJson {
	private static final KafkaJson instance = new KafkaJson();

    private JsonGenerator jsonGenerator = null;

    private ObjectMapper objectMapper = null;
    
	public KafkaJson() {
		  objectMapper = new ObjectMapper();
	}
	public static KafkaJson getInstance() {
		return instance;
	}
	
	public String toJson(Object obj){
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}


}
