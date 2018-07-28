package ar.edu.eest9.service.autorizado;

import ar.edu.eest9.domain.Autorizados;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AutorizadoService {

    void create(Autorizados autorizados);

    void edit(Autorizados autorizados);

    void remove(Autorizados autorizados);

    Autorizados find(Object id);

    List<Autorizados> findAll();
}
