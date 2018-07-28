package ar.edu.eest9.repository.padre;

import ar.edu.eest9.domain.Padres;
import java.util.List;

public interface PadreDao {

    void create(Padres padres);

    void edit(Padres padres);

    void remove(Padres padres);

    Padres find(Object id);

    List<Padres> findAll();
}
