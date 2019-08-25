package org.myproject.repository.dao.hibernateDao;


import org.myproject.repository.entity.User;

public interface UserDao extends GenericDao<User,Long> {
    User getByEmail(String email);
    boolean isEmailExist(String email);
}
