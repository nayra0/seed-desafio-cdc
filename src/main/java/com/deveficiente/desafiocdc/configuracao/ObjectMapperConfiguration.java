package com.deveficiente.desafiocdc.configuracao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ObjectMapperConfiguration {
	
	private static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static final DateTimeFormatter FORMATTER_DATE_TIME = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	@Primary
	@Bean
	public ObjectMapper createObjectMapperBuilder() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        
        objectMapper.registerModule(javaTimeModule);
		
	    return objectMapper;
	}
	
	class LocalDateSerializer extends JsonSerializer<LocalDate> {

		@Override
		public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
			gen.writeString(value.format(FORMATTER_DATE));
			
		}
	}
	
	class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

	    @Override
	    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
	        return LocalDate.parse(p.getValueAsString(), FORMATTER_DATE);
	    }
	}
	
	class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

		@Override
		public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
			gen.writeString(value.format(FORMATTER_DATE_TIME));
			
		}
	}
	
	class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

	    @Override
	    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
	        return LocalDateTime.parse(p.getValueAsString(), FORMATTER_DATE_TIME);
	    }
	}
}
