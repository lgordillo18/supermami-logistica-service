package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.repositories.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Service
public class UserService {
  @Autowired
  private IUserRepository iUserRepository;

  public User saveUser(User user) {
    return iUserRepository.save(user);
  }

  public ArrayList<User> getAllUsers(){
    return (ArrayList<User>) iUserRepository.findAll();
  }

  public ArrayList<Rol> getRoles(Integer id){
    return iUserRepository.findByRoles(id);
  }
}
