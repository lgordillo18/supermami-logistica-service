package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);
    Rol saveRol(Rol rol);
    void addRoleToUser(String username, String rolName);
    User getUser(String username);
    List<User> getUsers();
}
