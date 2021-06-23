package sv.gob.mined.projects.tcd.repositories;

import sv.gob.mined.projects.tcd.entities.Departamento;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DepartamentoRepository extends GenericRepository<Departamento> {

    @PersistenceContext(unitName = "tcd-PU")
    private EntityManager em;

    public DepartamentoRepository() {
        super(Departamento.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
