package com.projetopedidos.estudo.services;

import com.projetopedidos.estudo.entities.User;
import com.projetopedidos.estudo.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll(){
    return repository.findAll();
  }

  public User findById (UUID id) {
    Optional<User> user = repository.findById(id);
    return user.get();
  }
}
