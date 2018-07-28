package ar.edu.eest9.service.materia;

import ar.edu.eest9.domain.Materias;
import ar.edu.eest9.repository.materia.impl.MateriaDao;
import ar.edu.eest9.service.materia.impl.MateriaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MateriaServiceImpl implements MateriaService {

    @Inject
    private MateriaDao materiaDao;
    
    @Override
    public void create(Materias materias) {
        materiaDao.create(materias);
    }

    @Override
    public void edit(Materias materias) {
        materiaDao.edit(materias);
    }

    @Override
    public void remove(Materias materias) {
        materiaDao.remove(materias);
    }

    @Override
    public Materias find(Object id) {
        return materiaDao.find(id);
    }

    @Override
    public List<Materias> findAll() {
        return materiaDao.findAll();
    }

}
