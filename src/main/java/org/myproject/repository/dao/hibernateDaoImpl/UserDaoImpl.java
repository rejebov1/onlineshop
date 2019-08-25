package org.myproject.repository.dao.hibernateDaoImpl;

import org.hibernate.query.Query;
import org.myproject.repository.dao.hibernateDao.UserDao;
import org.myproject.repository.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User,Long> implements UserDao {

    public UserDaoImpl(){
        super();
    }

    /*@Override
    @Transactional
    public User getByEmail(String email) {
       *//* Query<User> query = sessionFactory.getCurrentSession().createQuery("from User u where u.email=:email", User.class);*//*
        Query query = getCurrentSession().createQuery("FROM User WHERE email = :email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }*/

    @Override
    @Transactional
    public User getByEmail(String value) {
        Query query = getCurrentSession().createQuery("FROM User WHERE email = :email");
        query.setParameter("email", value);
        return (User) query.uniqueResult();
    }

    @Override
    @Transactional
    public boolean isEmailExist(String email) {
         //Query<User> query = sessionFactory.getCurrentSession().createQuery("from User u where u.email=:email", User.class);
        Query query = getCurrentSession().createQuery("FROM User WHERE email = :email");
        query.setParameter("email", email);
        return query.list().size()!=0;
    }

}
