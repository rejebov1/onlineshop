package org.myproject.service.implService;

import org.myproject.repository.dao.hibernateDao.DaoList;
import org.myproject.repository.dao.hibernateDao.UserDao;
import org.myproject.repository.entity.User;
import org.myproject.service.UserService;
import org.myproject.service.model.AppUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected DaoList daoList;

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return daoList.getUserDao().getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email){
        return daoList.getUserDao().getByEmail(email);
    }


    @Override
    @Transactional
    public User getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AppUserDetails) {
            Long userId = ((AppUserDetails)principal).getUserId();
            return getById(userId);
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public String getCurrentUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof AppUserDetails) {
            Long userId = ((AppUserDetails)principal).getUserId();
            return getById(userId).getFullName();
        } else {
            return principal.toString();
        }
    }


    @Override
    public boolean delete(User user) {
        return userDao.delete(user);
    }

    public boolean isEmailExist(String email) {
        return userDao.isEmailExist(email);
    }

    @Override
    @Transactional
    public void addNewUser(User user){
        daoList.getUserDao().add(user);
    }

    @Override
    @Transactional
    public User updateUserProfile(User user) {
        daoList.getUserDao().getById(user.getId());
        user.setPhoneNumber(user.getPhoneNumber());
        user.setFullName(user.getFullName());

        return user;
    }

    @Override
    @Transactional
    public User updateUserPassword(User user){
        daoList.getUserDao().getById(user.getId());
        user.setPassword(user.getPassword());
        return user;
    }

}

