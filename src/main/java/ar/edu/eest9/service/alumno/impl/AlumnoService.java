package ar.edu.eest9.service.alumno;

import ar.edu.eest9.domain.Alumnos;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AlumnoService {

    void create(Alumnos alumnos);

    void edit(Alumnos alumnos);

    void remove(Alumnos alumnos);

    Alumnos find(Object id); //¿Podria cambiar el Object por Alumnos?

    List<Alumnos> findAll();

}
