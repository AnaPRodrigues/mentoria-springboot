package com.projetopedidos.estudo.resource;

import com.projetopedidos.estudo.command.user.CreateUserCommand;
import com.projetopedidos.estudo.command.user.FindUserByIdCommand;
import com.projetopedidos.estudo.commandHandler.user.FindUserByIdCommandHandler;
import com.projetopedidos.estudo.dto.InsertUserDTO;
import com.projetopedidos.estudo.commandHandler.user.CreateUserCommandHandler;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetopedidos.estudo.entities.User;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private CreateUserCommandHandler userCommandHandler;

    @Autowired
    private FindUserByIdCommandHandler findUserByIdCommandHandler;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User> list = userCommandHandler.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        FindUserByIdCommand command = new FindUserByIdCommand(id);
        User user = findUserByIdCommandHandler.handle(command);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody InsertUserDTO objDto) {
        CreateUserCommand user = objDto.toInsertUserCommand();
        User userResponse = userCommandHandler.handle(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userResponse.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
