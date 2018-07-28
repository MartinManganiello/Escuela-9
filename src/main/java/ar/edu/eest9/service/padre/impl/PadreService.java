package ar.edu.eest9.service.padre;

import ar.edu.eest9.domain.Padres;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PadreService {

    void create(Padres padres);

    void edit(Padres padres);

    void remove(Padres padres);

    Padres find(Object id);

    List<Padres> findAll();
}
