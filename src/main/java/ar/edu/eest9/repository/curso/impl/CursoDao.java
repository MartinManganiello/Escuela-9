package ar.edu.eest9.repository.curso.impl;

import ar.edu.eest9.domain.Cursos;
import java.util.List;

public interface CursoDao {

    void create(Cursos cursos);

    void edit(Cursos cursos);

    void remove(Cursos cursos);

    Cursos find(Object id);

    List<Cursos> findAll();
}
