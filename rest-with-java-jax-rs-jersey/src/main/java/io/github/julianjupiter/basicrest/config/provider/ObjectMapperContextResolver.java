package io.github.julianjupiter.basicrest.config.provider;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {  
    private ObjectMapper objectMapper;

    public ObjectMapperContextResolver() {
    	objectMapper = new ObjectMapper();
    	objectMapper.registerModule(new JavaTimeModule());
    	objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }  
}
