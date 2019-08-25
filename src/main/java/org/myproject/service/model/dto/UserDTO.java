/*
package org.myproject.service.model.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.myproject.repository.entity.Cart;
import org.myproject.repository.entity.Order;
import org.myproject.repository.entity.enums.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class UserDTO {

    private Long id;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String fullName;

    @Email(message = "{reg.user.email.invalid}")
    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String email;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String phoneNumber;

    @NotNull
    @Size(min = 6, max = 25, message = "{reg.user.passwordNotInRange}")
    private String password;

    @NotNull
    private String confirmPassword;
    private Boolean isActive;

    private Role role;
    private List<Order> orders = new ArrayList<>();
    private Cart cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

*/
