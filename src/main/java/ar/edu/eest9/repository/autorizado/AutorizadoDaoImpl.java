package ar.edu.eest9.repository.autorizado;

import ar.edu.eest9.domain.Autorizados;
import ar.edu.eest9.repository.GenericR;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AutorizadoDaoImpl extends GenericR<Autorizados> implements AutorizadoDao {

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public AutorizadoDaoImpl() {
        super(Autorizados.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
