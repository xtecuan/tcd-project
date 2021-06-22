package sv.gob.mined.projects.tcd.beans;

import sv.gob.mined.projects.tcd.entities.Usuarios;
import sv.gob.mined.projects.tcd.services.UsuariosService;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuariosBean implements Serializable {
    private List<Usuarios> allUsuarios;

    @Inject
    private UsuariosService service;

    @PostConstruct
    private void postConstruct() {
        refresh();
    }

    private void refresh() {
        this.allUsuarios = service.loadAll();
    }

    public List<Usuarios> getAllUsuarios() {
        return allUsuarios;
    }
}
