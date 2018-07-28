package ar.edu.eest9.repository.materia;

import ar.edu.eest9.domain.Materias;
import ar.edu.eest9.repository.GenericR;
import ar.edu.eest9.repository.materia.impl.MateriaDao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MateriaDaoImpl extends GenericR<Materias> implements MateriaDao{

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public MateriaDaoImpl() {
        super(Materias.class);
    }

   @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
