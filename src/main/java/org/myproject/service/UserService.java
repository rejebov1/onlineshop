package org.myproject.service;

import org.myproject.repository.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    void add(User user);

   /* User getByEmail(String email);*/

    @Transactional(readOnly = true)
    User getById(Long id);

    List<User> getAll();

    User update(User user);

//    boolean delete(Long id);

    User getByEmail(String email);

    User getCurrentUser();

    String getCurrentUsername();

    boolean delete(User user);


    boolean isEmailExist(String email);

    void addNewUser(User user);

    User updateUserProfile(User user);

    User updateUserPassword(User user);
}


