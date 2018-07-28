package ar.edu.eest9.repository.alumno;

import ar.edu.eest9.domain.Alumnos;
import ar.edu.eest9.repository.GenericR;
import ar.edu.eest9.repository.alumno.impl.AlumnoDao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AlumnoDaoImpl extends GenericR<Alumnos> implements AlumnoDao {
//El DAO se encarga unicamente de comunicarse con la BD
//Debo implementar la interface AlumnoDao para especificar criterios ej: findByLegajo, getCurso y devuelva el curso del alumno
//Las consultas generales estan en el GenericR (create, update,delete, findAll) son comunes a todas las entidades
//Metodos como getCurso

    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    public AlumnoDaoImpl() {
        super(Alumnos.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
