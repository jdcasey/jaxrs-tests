package org.commonjava.poc.jaxrs;

import org.commonjava.propulsor.boot.BootException;
import org.commonjava.propulsor.boot.Booter;

public class App
{

    public static void main( final String[] args )
    {
        final AppOptions options = new AppOptions();
        try
        {
            new Booter().runAndWait( options );
        }
        catch ( final BootException e )
        {
            e.printStackTrace();
        }
    }

}
