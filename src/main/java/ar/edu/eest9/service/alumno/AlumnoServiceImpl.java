package ar.edu.eest9.service.alumno;

import ar.edu.eest9.domain.Alumnos;
import ar.edu.eest9.repository.alumno.AlumnoDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AlumnoServiceImpl implements AlumnoService {
//El EJB se comunica con el DAO para modificar la BD.

    @Inject
    private AlumnoDao alumnoDao; //Interface DAO del alumno

    @Override
    public void create(Alumnos alumnos) {
        alumnoDao.create(alumnos);
    }

    @Override
    public void edit(Alumnos alumnos) {
        alumnoDao.edit(alumnos);
    }

    @Override
    public void remove(Alumnos alumnos) {
        alumnoDao.remove(alumnos);
    }

    @Override
    public Alumnos find(Object id) {
        return alumnoDao.find(id);
    }

    @Override
    public List<Alumnos> findAll() {
        return alumnoDao.findAll();
    }

}
