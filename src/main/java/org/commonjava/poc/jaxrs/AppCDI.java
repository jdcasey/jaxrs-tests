package org.commonjava.poc.jaxrs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class AppCDI
{

    public class AppDateSerializer
        extends JsonSerializer<Date>
    {

        @Override
        public void serialize( final Date value, final JsonGenerator jgen, final SerializerProvider provider )
            throws IOException, JsonProcessingException
        {
            jgen.writeString( new SimpleDateFormat( "yyyy/MM/dd" ).format( value ) );
        }

    }

    private ObjectMapper mapper;

    @PostConstruct
    public void init()
    {
        mapper = new ObjectMapper();
        mapper.enable( SerializationFeature.INDENT_OUTPUT );
        mapper.registerModule( new SimpleModule(){
            private static final long serialVersionUID = 1L;

            {
                addSerializer( Date.class, new AppDateSerializer() );
            }
        });
    }

    @Produces
    @Default
    public ObjectMapper getMapper()
    {
        return mapper;
    }

}
