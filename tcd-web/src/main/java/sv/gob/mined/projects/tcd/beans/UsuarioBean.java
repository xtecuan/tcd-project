package sv.gob.mined.projects.tcd.beans;

import sv.gob.mined.projects.tcd.entities.Usuario;
import sv.gob.mined.projects.tcd.services.UsuarioService;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {
    private List<Usuario> allUsuario;

    @Inject
    private UsuarioService service;

    @PostConstruct
    private void postConstruct() {
        refresh();
    }

    private void refresh() {
        this.allUsuario = service.loadAll();
    }

    public List<Usuario> getAllUsuario() {
        return allUsuario;
    }
}
