package com.projetopedidos.estudo.commandHandler.user;

import com.projetopedidos.estudo.command.user.CreateUserCommand;
import com.projetopedidos.estudo.commandHandler.CommandHandler;
import com.projetopedidos.estudo.entities.User;
import com.projetopedidos.estudo.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand, User> {

  @Autowired
  private UserRepository repository;

  public List<User> findAll(){
    return repository.findAll();
  }

  public User findById (String id) {
    Optional<User> user = repository.findById(id);
    return user.get();
  }

  @Override
  public User handle(CreateUserCommand command) {

    User user = new User(command);

    return repository.insert(user);
  }
}
