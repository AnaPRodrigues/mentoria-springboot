package com.projetopedidos.estudo.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetopedidos.estudo.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<User> findAll(){

        User user = new User(2L, "maria", "asf", "tee","dsf");

        return ResponseEntity.ok().body(user);

    }
}
