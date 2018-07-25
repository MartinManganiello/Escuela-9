package ar.edu.eest9.repository;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class GenericR<T> {
    //Esta clase aplica el patrón DAO con generics y emplea los metodos comunes a todas las entidades (create, update,delete)
    private Class<T> entityClass;

    public GenericR(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) { //¿Podria cambiar el object por T ?
        return getEntityManager().find(entityClass, id);
    }
    
    public T findById(int id){
    return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

}