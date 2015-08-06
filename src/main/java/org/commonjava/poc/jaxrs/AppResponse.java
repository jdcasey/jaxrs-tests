package org.commonjava.poc.jaxrs;

public class AppResponse
{

    private String message;

    public AppResponse()
    {
    }

    public AppResponse( final String message )
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage( final String message )
    {
        this.message = message;
    }

}
