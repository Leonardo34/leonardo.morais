package br.com.crescer2017.tema4.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;

public abstract class GenericDao<E, I> implements CrudDao<E, I> {
    protected EntityManager entityManager = 
            Persistence.createEntityManagerFactory("localPU").createEntityManager();
    
    private Class<E> persistedEntity;
    
    public GenericDao(Class<E> persistedEntity) {
        this.persistedEntity = persistedEntity;
    }

    @Override
    public E save(E e) {
        entityManager.getTransaction().begin();
        entityManager.merge(e);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(E e) {
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    @Override
    public E loadById(I id) {
        return entityManager.find(persistedEntity, id);
    }

    @Override
    public List<E> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(persistedEntity);
        return criteria.list();
    } 
}
