package com.demo.common.convert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLongDeserialize extends JsonDeserializer<Long>  {
	
	private static final Logger log = LoggerFactory.getLogger(StringToLongDeserialize.class);

	@Override
	public Long deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		String s = p.getValueAsString();
		

 
		if(s!= null) {
			
			try {
				log.error(s);
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				ZonedDateTime zdt = LocalDateTime.parse(s, dtf).atZone(ZoneId.systemDefault());
				
				Long l = zdt.toInstant().toEpochMilli();
				log.debug("l:" + l);
				return l;
			} catch (Exception e){ 
				e.printStackTrace();
				
			}
		}
		return null;
	}

}
