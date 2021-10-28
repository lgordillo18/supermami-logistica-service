package com.supermamilogisticaservice.controllers;

import com.supermamilogisticaservice.dtos.AreaDto;
import com.supermamilogisticaservice.dtos.RolDto;
import com.supermamilogisticaservice.dtos.UserCompleteDto;
import com.supermamilogisticaservice.dtos.UserDto;
import com.supermamilogisticaservice.models.Area;
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
  public ResponseEntity createUser(@Validated @RequestBody User user) {
      try {
        User newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
      }
  }

  @GetMapping("/users")
  public ResponseEntity getAllUsers() {
    ArrayList<UserDto> users = new ArrayList<UserDto>();
    try {
      Iterable<User> arrayUsers = userService.getAllUsers();
      for (User user: arrayUsers) {
        UserDto newUserDto = new UserDto(user.getId(), user.getFirst_name(), user.getLast_name(), user.getRol().getName(), user.getUsername(), user.isDeleted());
        users.add(newUserDto);
      }
      return new ResponseEntity<>(users, HttpStatus.OK);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  @GetMapping("/user/roles")
  public ResponseEntity getAllRoles() {
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
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  @GetMapping(path = "/user/{id}")
  public ResponseEntity getUser(@PathVariable("id") int id) {
    try {
      Optional<User> userData = userService.getUser(id);
      if (userData.isPresent()) {
        UserCompleteDto newUserDto = new UserCompleteDto(userData.get().getId(), userData.get().getFirst_name(), userData.get().getLast_name(), userData.get().getUsername(), userData.get().getDni(), userData.get().getPhone_number(), userData.get().getEmail(), userData.get().getAddress(), userData.get().getOffice(), userData.get().getRol(), userData.get().getArea());
        return new ResponseEntity<>(newUserDto, HttpStatus.OK);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }

  @PutMapping("/user/{id}")
  public User updateUser(@PathVariable String id, @Validated @RequestBody User user) {
    return userService.saveUser(user);
  }

  @PutMapping("/user/delete/{id}")
  public ResponseEntity deleteUser(@PathVariable("id") int id, @RequestBody User user) {
    try {
      Optional<User> userData = userService.getUser(id);
      if (userData.isPresent()) {
        User _user = userData.get();
        _user.setDeleted(user.isDeleted());
        userService.saveUser(_user);
        return new ResponseEntity<>(userData, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch ( Exception e ) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
    }
  }
}