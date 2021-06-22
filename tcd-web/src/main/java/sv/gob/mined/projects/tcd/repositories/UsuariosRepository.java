package sv.gob.mined.projects.tcd.repositories;

import sv.gob.mined.projects.tcd.entities.Usuarios;
import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class UsuariosRepository {
    @PersistenceContext(unitName = "tcd-PU")
    private EntityManager em;

    public List<Usuarios> loadAll() {
        return em.createNamedQuery("Usuarios.findAll").getResultList();
    }

    public Usuarios add(Usuarios usuario){
        this.em.persist(usuario);
        this.em.flush();
        this.em.refresh(usuario);
        return usuario;
    }

    public Usuarios add(Date fechaExpiracion,
                        String activo,
                        String correo,
                        String password,
                        String login
    ) {
        final Usuarios newUsuario = new Usuarios();
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

    public Usuarios delete(Integer idUsuario) {
        try {
            Usuarios ref = this.em.getReference(Usuarios.class, idUsuario);
            this.em.remove(ref);
            return ref;
        } catch (EntityNotFoundException enf) {
            throw new EJBException(enf);
        }
    }

    public Usuarios update(Long idUsuario,
                           Date fechaExpiracion,
                           String activo,
                           String correo,
                           String password,
                           String login) {
        try {
            final Usuarios ref = this.em.getReference(Usuarios.class, idUsuario);
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
            return this.em.merge(ref);
        } catch (EntityNotFoundException enf) {
            throw new EJBException(enf);
        }
    }
}
