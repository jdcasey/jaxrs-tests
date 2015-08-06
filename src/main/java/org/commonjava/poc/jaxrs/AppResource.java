package org.commonjava.poc.jaxrs;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.commonjava.propulsor.deploy.resteasy.RestResources;

@Path( "/app" )
public class AppResource
    implements RestResources
{

    @Path( "/ping" )
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public AppPing ping()
    {
        return new AppPing();
    }

    @Path( "/ping2" )
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public Map<String, Map<String, Date>> ping2()
    {
        return Collections.singletonMap( "pong", Collections.<String, Date> singletonMap( "date", new Date() ) );
    }

    @Path( "/echo" )
    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    public AppResponse echo( final AppRequest request )
    {
        return new AppResponse( request.getMessage() );
    }

    @Path( "/echo2" )
    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    public AppResponse echo2( final Map<String, String> request )
    {
        return new AppResponse( request.get( "message" ) );
    }

    @Path( "/no-echo" )
    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    @Produces( MediaType.APPLICATION_JSON )
    public AppResponse noEcho( final AppRequest request )
    {
        return null;
    }

}
