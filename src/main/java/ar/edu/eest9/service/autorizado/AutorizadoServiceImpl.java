package ar.edu.eest9.service.autorizado;

import ar.edu.eest9.domain.Autorizados;
import ar.edu.eest9.repository.autorizado.AutorizadoDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AutorizadoServiceImpl implements AutorizadoService {

    @Inject
    private AutorizadoDao autorizadoDao;

    @Override
    public void create(Autorizados autorizados) {
        autorizadoDao.create(autorizados);
    }

    @Override
    public void edit(Autorizados autorizados) {
        autorizadoDao.edit(autorizados);
    }

    @Override
    public void remove(Autorizados autorizados) {
        autorizadoDao.remove(autorizados);
    }

    @Override
    public Autorizados find(Object id) {
        return autorizadoDao.find(id);
    }

    @Override
    public List<Autorizados> findAll() {
        return autorizadoDao.findAll();
    }
}
