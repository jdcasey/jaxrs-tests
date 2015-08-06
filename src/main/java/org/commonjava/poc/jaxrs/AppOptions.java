package org.commonjava.poc.jaxrs;

import org.commonjava.propulsor.boot.BootOptions;
import org.commonjava.propulsor.deploy.undertow.UndertowBootOptions;
import org.commonjava.propulsor.util.PortFinder;

public class AppOptions
    extends BootOptions
    implements UndertowBootOptions
{

    private final int port;

    public AppOptions()
    {
        super( "/tmp/app.home" );
        this.port = PortFinder.findOpenPort( 4 );
    }

    @Override
    public String getContextPath()
    {
        return "/";
    }

    @Override
    public String getDeploymentName()
    {
        return "App";
    }

    @Override
    public int getPort()
    {
        return port;
    }

    @Override
    public String getBind()
    {
        return "0.0.0.0";
    }

    @Override
    public String getHomeSystemProperty()
    {
        return "app.home";
    }

    @Override
    public String getHomeEnvar()
    {
        return "APP_HOME";
    }

}
