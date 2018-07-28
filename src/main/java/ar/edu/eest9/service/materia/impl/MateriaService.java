package ar.edu.eest9.service.materia.impl;

import ar.edu.eest9.domain.Materias;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MateriaService {

    void create(Materias materias);

    void edit(Materias materias);

    void remove(Materias materias);

    Materias find(Object id);

    List<Materias> findAll();
}
