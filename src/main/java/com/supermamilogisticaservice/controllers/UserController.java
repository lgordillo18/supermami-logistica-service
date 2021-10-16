package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TableGenerator;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/logistica-service")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/user")
  public User createUser(@Validated @RequestBody User user) {
    return userService.saveUser(user);
  }

  @GetMapping("/users")
  public ArrayList<User> getAllUsers(){
    return userService.getAllUsers();
  }

  @GetMapping(path = "/{id}")
  public Optional<User> getUser(@PathVariable("id") Integer id) {return this.userService.getUser(id);}

}
