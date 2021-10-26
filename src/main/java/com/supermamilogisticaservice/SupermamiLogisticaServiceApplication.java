package com.supermamilogisticaservice;

import com.supermamilogisticaservice.models.Rol;
import com.supermamilogisticaservice.models.User;
import com.supermamilogisticaservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SupermamiLogisticaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermamiLogisticaServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRol(new Rol(null, "ROLE_USER"));
			userService.saveRol(new Rol(null, "ROLE_MANAGER"));
			userService.saveRol(new Rol(null, "ROLE_ADMIN"));
			userService.saveRol(new Rol(null, "ROLE_DELIVERY"));

			userService.saveUser(new User("jose", "12345", new ArrayList<>()));
			userService.saveUser(new User("angie", "12345", new ArrayList<>()));
			userService.saveUser(new User("ponzi", "12345", new ArrayList<>()));
			userService.saveUser(new User("ale", "12345", new ArrayList<>()));
			userService.saveUser(new User("david", "12345", new ArrayList<>()));
			userService.saveUser(new User("lucas", "12345", new ArrayList<>()));
			userService.saveUser(new User("cami", "12345", new ArrayList<>()));

			userService.addRoleToUser("jose", "ROLE_USER");
			userService.addRoleToUser("angie", "ROLE_ADMIN");
			userService.addRoleToUser("ponzi", "ROLE_DELIVERY");
			userService.addRoleToUser("ale", "ROLE_USER");
			userService.addRoleToUser("david", "ROLE_MANAGER");
			userService.addRoleToUser("lucas", "ROLE_USER");
			userService.addRoleToUser("cami", "ROLE_USER");

		};
	}
}
