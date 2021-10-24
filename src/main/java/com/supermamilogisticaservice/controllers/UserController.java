package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.RolDto;
import com.supermamilogisticaservice.dtos.UserDto;
import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
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
  public ResponseEntity<ArrayList<UserDto>> getAllUsers() {
    ArrayList<UserDto> users = new ArrayList<UserDto>();
    try {
      Iterable<User> arrayUsers = userService.getAllUsers();
      for (User user: arrayUsers) {
        UserDto newUserDto = new UserDto(user.getId(), user.getFirst_name(), user.getLast_name(), user.getRol().getName());
        users.add(newUserDto);
      }
      return new ResponseEntity<>(users, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/user/roles")
  public ResponseEntity<ArrayList<RolDto>> getAllRoles() {
    ArrayList<RolDto> roles = new ArrayList<RolDto>();
    try {
      Iterable<Rol> arrayRoles = userService.getAllRoles();
      for (Rol rol: arrayRoles) {
        RolDto newRolDto = new RolDto(rol.getId(), rol.getName());
        roles.add(newRolDto);
      }
      return new ResponseEntity<>(roles, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/user/{id}")
  public Optional<User> getUser(@PathVariable("id") Integer id) {return this.userService.getUser(id);}

  @PutMapping("/user/{id}")
  public User updateUser(@PathVariable String id, @Validated @RequestBody User user) {
    return userService.saveUser(user);
  }
}