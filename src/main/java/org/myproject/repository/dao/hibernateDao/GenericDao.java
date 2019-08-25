package org.myproject.repository.dao.hibernateDao;

import java.util.List;

public interface GenericDao<T, ID>  {

    T add(T entity);

    T getById(ID id);

    List<T> getAll();

    T update(T entity);

    boolean delete(T entity);
/*
    boolean deleteById(ID id);*/

}
