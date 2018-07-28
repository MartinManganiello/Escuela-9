package ar.edu.eest9.service.curso;

import ar.edu.eest9.service.curso.impl.CursoService;
import ar.edu.eest9.domain.Cursos;
import ar.edu.eest9.repository.curso.impl.CursoDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CursoServiceImpl implements CursoService {
/* EJB que implementa la interface local CursoService, se encarga de relacionarse con el DAO para interactuar con la BD */
    @Inject
    private CursoDao cursoDao;

    @Override
    public void create(Cursos cursos) {
        cursoDao.create(cursos);
    }

    @Override
    public void edit(Cursos cursos) {
        cursoDao.edit(cursos);
    }

    @Override
    public void remove(Cursos cursos) {
        cursoDao.remove(cursos);
    }

    @Override
    public Cursos find(Object id) {
        return cursoDao.find(id);
    }

    @Override
    public List<Cursos> findAll() {
        return cursoDao.findAll();
    }
}
