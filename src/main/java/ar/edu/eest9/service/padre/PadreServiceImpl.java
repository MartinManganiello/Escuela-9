package ar.edu.eest9.service.padre;

import ar.edu.eest9.domain.Padres;
import ar.edu.eest9.repository.padre.PadreDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PadreServiceImpl implements PadreService {

    @Inject
    private PadreDao padreDao;

    @Override
    public void create(Padres padres) {
        padreDao.create(padres);
    }

    @Override
    public void edit(Padres padres) {
        padreDao.edit(padres);
    }

    @Override
    public void remove(Padres padres) {
        padreDao.remove(padres);
    }

    @Override
    public Padres find(Object id) {
        return padreDao.find(id);
    }

    @Override
    public List<Padres> findAll() {
        return padreDao.findAll();
    }

}
