package ar.edu.eest9.service.curso.impl;

import ar.edu.eest9.domain.Cursos;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CursoService {

    void create(Cursos cursos);

    void edit(Cursos cursos);

    void remove(Cursos cursos);

    Cursos find(Object id);

    List<Cursos> findAll();
}
