package org.myproject.hibernateTests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.repository.dao.hibernateConfig.HibernateConfig;
import org.myproject.repository.entity.User;
import org.myproject.repository.entity.enums.Role;
import org.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class})
public class UserTest {

    @Autowired
    UserService userService;

    //@Test
    public void addUserTest(){
        User user = User.builder()
                .fullName("Danil R")
                .email("d/a1werty@mail")
                .password("qwerty")
                .role(Role.ADMIN)
                .build();

        userService.add(user);
        assertNotNull("OK", userService.getAll().contains(user));
                                                // 1 add 2 getById 3 getAll 4 update 6 deleteById
    }

    //@Test
    public void getUserById(){
        Assert.assertNotNull(userService.getById(2L));
    }

   @Test
    public void getUserByEmail(){
        System.out.println(userService.getByEmail("user@user"));
    }



    @Test
    public void userGetAll() {
        List<User> users = userService.getAll();
        Assert.assertNotNull(users);
    }

    //@Test
    public void userUpdate(){
        User user = User.builder()
                .id(1L)
                .fullName("No nonono")
                .email("nono@mail")
                .password("qwerty")
                .role(Role.USER)
                .build();

        userService.update(user);
    }

    //@Test
    public void userDelete(){
        User user = userService.getAll().get(1);

        userService.delete(user);

    }

}
