package ar.edu.eest9.repository.padre;

import ar.edu.eest9.domain.Padres;
import ar.edu.eest9.repository.GenericR;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PadreDaoImpl extends GenericR<Padres> implements PadreDao {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public PadreDaoImpl() {
        super(Padres.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
