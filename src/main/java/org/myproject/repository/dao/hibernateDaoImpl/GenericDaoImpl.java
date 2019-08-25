package org.myproject.repository.dao.hibernateDaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.repository.dao.hibernateDao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID> {

    private final Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        //explicit type T is the first param in getActualTypeArguments() result
        entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    //IF NOT USE THEN HibernateException: Could not obtain transaction-synchronized Session for current thread
    public T add(T entity) {
        getCurrentSession().save(entity);
        /*Session session = sessionFactory.openSession();   // works without @Transactional annotation!!!
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();*/
        return entity;
    }

    @Override
    @Transactional
    public T getById(ID id) {
        return getCurrentSession().get(entityClass, id);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return getCurrentSession().createQuery("FROM " + entityClass.getName()).list();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public T update(T entity) {
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    @Transactional
    public boolean delete(T entity) {
        if (entity != null) {
            getCurrentSession().delete(entity);
        } else {
            return false;
        }
        return true;
    }

    /*@Override
    @Transactional
    public boolean deleteById(ID id) {
        return delete(getById(id));
    }*/


    Session getCurrentSession()  {
        return sessionFactory.getCurrentSession();
    }
}
