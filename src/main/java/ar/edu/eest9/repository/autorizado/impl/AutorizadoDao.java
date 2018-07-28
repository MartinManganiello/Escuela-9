package ar.edu.eest9.repository.autorizado;

import ar.edu.eest9.domain.Autorizados;
import java.util.List;

public interface AutorizadoDao {

    void create(Autorizados autorizados);

    void edit(Autorizados autorizados);

    void remove(Autorizados autorizados);

    Autorizados find(Object id);

    List<Autorizados> findAll();
}
