package sv.gob.mined.projects.tcd.resources;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("/usuarios")
public class UsuariosResource {
    @Inject
    @ConfigProperty(name = "config2", defaultValue = "This is the default")
    String config2;

    @Inject
    @ConfigProperty(name = "var1", defaultValue = "20")
    String var1;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World! "+config2+" "+var1;
    }


}