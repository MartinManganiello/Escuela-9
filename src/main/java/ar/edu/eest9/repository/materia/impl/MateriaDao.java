package ar.edu.eest9.repository.materia.impl;

import ar.edu.eest9.domain.Materias;
import java.util.List;

public interface MateriaDao {

    void create(Materias materias);

    void edit(Materias materias);

    void remove(Materias materias);

    Materias find(Object id);

    List<Materias> findAll();
}
