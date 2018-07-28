package ar.edu.eest9.repository.curso;

import ar.edu.eest9.repository.curso.impl.CursoDao;
import ar.edu.eest9.domain.Cursos;
import ar.edu.eest9.repository.GenericR;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CursoDaoImpl extends GenericR<Cursos> implements CursoDao {

    /*Esta clase se encarga de comunicarse con la BD, para ello utiliza la interface propia de la entidad. 
Las consultas generales estan en el GenericR (create, update,delete, findAll) son comunes a todas las entidades   
     */
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public CursoDaoImpl() {
        super(Cursos.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
