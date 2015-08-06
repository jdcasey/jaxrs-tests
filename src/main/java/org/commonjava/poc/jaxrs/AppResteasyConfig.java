package org.commonjava.poc.jaxrs;

import java.util.Arrays;
import java.util.List;

import org.commonjava.propulsor.deploy.resteasy.ResteasyAppConfig;

public class AppResteasyConfig
    implements ResteasyAppConfig
{

    @Override
    public List<String> getJaxRsMappings()
    {
        return Arrays.asList( "/", "/*" );
    }

}
