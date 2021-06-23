package sv.gob.mined.projects.tcd.resources;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject
    @ConfigProperty(name = "config2", defaultValue = "This is the default")
    String config2;

    @Inject
    @ConfigProperty(name = "var1", defaultValue = "20")
    String var1;

    @GET
    public Map<String, Object> hello() {
        Map<String,Object> out = new HashMap<>();
        out.put("helloMsg","Hello, World! ");
        out.put("config2",config2);
        out.put("var1",var1);
        return out;
    }


}