package sv.gob.mined.projects.tcd.repositories;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.tcd.entities.Usuario;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class UsuarioRepository {
    private static Logger log = Logger.getLogger(UsuarioRepository.class);
    @PersistenceContext(unitName = "tcd-PU")
    private EntityManager em;

    public List<Usuario> loadAll() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    public Usuario add(Usuario usuario){
        this.em.persist(usuario);
        this.em.flush();
        this.em.refresh(usuario);
        return usuario;
    }

    public Usuario add(Date fechaExpiracion,
                        String activo,
                        String correo,
                        String password,
                        String login
    ) {
        final Usuario newUsuario = new Usuario();
        newUsuario.setFechaExpiracion(fechaExpiracion);
        newUsuario.setActivo(activo);
        newUsuario.setCorreo(correo);
        newUsuario.setPassword(password);
        newUsuario.setLogin(login);
        this.em.persist(newUsuario);
        this.em.flush();
        this.em.refresh(newUsuario);
        return newUsuario;
    }

    public Usuario delete(Integer idUsuario) {
        Usuario ref = null;
        try {
           ref = this.em.getReference(Usuario.class, idUsuario);
            this.em.remove(ref);
        } catch (EntityNotFoundException enf) {
           log.error("Error deleting Usuario entity...",enf);
        }finally {
            return  ref;
        }
    }

    public Usuario update(Long idUsuario,
                           Date fechaExpiracion,
                           String activo,
                           String correo,
                           String password,
                           String login) {
        Usuario ref = null;
        try {
            ref = this.em.getReference(Usuario.class, idUsuario);
            if(ref!=null){
                if(fechaExpiracion!=null){
                    ref.setFechaExpiracion(fechaExpiracion);
                }
                if(activo!=null && activo.length()>0 && !activo.equals(" ")){
                    ref.setActivo(activo);
                }
                if(correo!=null){
                    ref.setCorreo(correo);
                }
                if(password!=null && password.length()>0 && !password.equals(" ")){
                    ref.setPassword(password);
                }
                if(login!=null && login.length()>0 && !login.equals(" ")){
                    ref.setPassword(login);
                }
            }
            ref = this.em.merge(ref);
        } catch (EntityNotFoundException enf) {
            log.error("Error updating Usuario entity...",enf);
        }finally {
            return ref;
        }
    }
}
