package com.projetopedidos.estudo.commandHandler.user;

import com.projetopedidos.estudo.command.user.FindUserByIdCommand;
import com.projetopedidos.estudo.commandHandler.CommandHandler;
import com.projetopedidos.estudo.entities.User;
import com.projetopedidos.estudo.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindUserByIdCommandHandler implements CommandHandler<FindUserByIdCommand, User> {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  @Override
  public User handle(FindUserByIdCommand command) {
    String idString = command.getId();
    Optional<User> user = repository.findById(idString);
    return user.get();
  }
}
