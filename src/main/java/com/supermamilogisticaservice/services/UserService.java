package com.supermamilogisticaservice.services;

import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.repositories.IRolRepository;
import com.supermamilogisticaservice.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserService implements IUserService, UserDetailsService {

  private final IUserRepository userRepo;

  private final IRolRepository rolRepo;

  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepo.findByUsername(username);
    if(user == null){
      log.error("User not found in the database");
    }else {
      log.info("User found in the database:{}", username );
    }
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    user.getRol().forEach(rol -> {
      authorities.add(new SimpleGrantedAuthority(rol.getName()));
    });
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
  }

  @Override
  public User saveUser(User user) {
    log.info("Saving new user {} to the database", user.getUsername());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepo.save(user);
  }

  @Override
  public Rol saveRol(Rol rol) {
    log.info("Saving new rol {} to the database", rol.getName());
    return rolRepo.save(rol);
  }

  @Override
  public void addRoleToUser(String username, String rolName) {
    log.info("Adding rol {} to user {}", rolName, username);
    User user = userRepo.findByUsername(username);
    Rol rol = rolRepo.findByName(rolName);
    user.getRol().add(rol);
  }

  @Override
  public User getUser(String username) {
    log.info("Fetching user {} to user {}", username);
    return userRepo.findByUsername(username);
  }

  @Override
  public List<User> getUsers() {
    log.info("Fetching all Users");
    return userRepo.findAll();
  }

  public ArrayList<User> getAllUsers(){
    return (ArrayList<User>) userRepo.findAll();
  }

  public ArrayList<Rol> getAllRoles(){
    return (ArrayList<Rol>) rolRepo.findAll();
  }
  
  public Optional<User> getUser (Integer id){
    return userRepo.findById(id);
  }

}

