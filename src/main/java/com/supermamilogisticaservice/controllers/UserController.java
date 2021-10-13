package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/logistica-service")
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/user")
  public User createStudent(@Validated @RequestBody User user) {
    return userService.saveUser(user);
  }
}
