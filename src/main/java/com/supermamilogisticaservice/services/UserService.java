package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.Employee;
import com.supermamilogisticaservice.models.OrderTicket;
import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.repositories.IRolRepository;
import com.supermamilogisticaservice.repositories.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private IUserRepository iUserRepository;
  @Autowired
  private IRolRepository iRolRepository;

  public User saveUser(User user) {
    return iUserRepository.save(user);
  }

  public ArrayList<User> getAllUsers(){
    return (ArrayList<User>) iUserRepository.findAll();
  }

  public ArrayList<Rol> getAllRoles(){
    return (ArrayList<Rol>) iRolRepository.findAll();
  }

  public Optional<Rol> getRol (Integer id){
    return iRolRepository.findById(id);
  }
  
  public Optional<User> getUser (Integer id){
    return iUserRepository.findById(id);
  }

  public void deleteUser (int id) {
    iUserRepository.deleteById(id);
  }

  public ArrayList<User> getUsersByRol(Optional<Rol> rol) {
    return (ArrayList<User>) iUserRepository.findByRol(rol);
  }
}

