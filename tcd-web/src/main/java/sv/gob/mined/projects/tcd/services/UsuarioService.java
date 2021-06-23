package sv.gob.mined.projects.tcd.services;

import sv.gob.mined.projects.tcd.entities.Usuario;
import sv.gob.mined.projects.tcd.repositories.UsuarioRepository;
import sv.gob.mined.projects.tcd.utils.DateUtil;
import sv.gob.mined.projects.tcd.utils.EmailUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class UsuarioService {
    public static final String ACTIVO = "A";
    public static final String INACTIVO = "I";
    public static final int EXPIRACION = 1;
    @Inject
    private UsuarioRepository repository;


    public Usuario createUser(String correo,
                               String login,
                               String password){
        Usuario usuario = new Usuario();
        usuario.setActivo(ACTIVO);
        usuario.setFechaExpiracion(DateUtil.addYears(new Date(),EXPIRACION));
        if(login!=null && login.length()>0 && login.length()<=100 & !login.equals(" ")){
            usuario.setLogin(login);
        }
        if(correo!=null && EmailUtil.isValid(correo)){
            usuario.setCorreo(correo);
        }
        if(password!=null && password.length()>0 && password.length()<=100){
            usuario.setPassword(password);
        }
        return repository.add(usuario);
    }

    public List<Usuario> loadAll(){
        return repository.loadAll();
    }
}
