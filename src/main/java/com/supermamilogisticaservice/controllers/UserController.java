package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/logistica-service")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/user")
  public User createStudent(@Validated @RequestBody User user) {
    return userService.saveUser(user);
  }

  @GetMapping("/users")
  public ArrayList<User> getAllUsers(){
    return userService.getAllUsers();
  }

  @GetMapping(path = "/{roleId}")
  public ArrayList<Rol> getRoles(@PathVariable("roleId") Integer id){ return this.userService.getRoles(id);
  }

}
