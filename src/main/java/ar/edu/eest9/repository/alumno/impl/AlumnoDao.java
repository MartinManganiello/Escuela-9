package ar.edu.eest9.repository.alumno.impl;

import ar.edu.eest9.domain.Alumnos;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface AlumnoDao {

    void create(Alumnos alumnos);

    void edit(Alumnos alumnos);

    void remove(Alumnos alumnos);

    Alumnos find(Object id); //¿Podria cambiar el Object por Alumnos?

    List<Alumnos> findAll();
}
