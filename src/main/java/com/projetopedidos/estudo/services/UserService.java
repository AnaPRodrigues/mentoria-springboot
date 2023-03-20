package com.projetopedidos.estudo.services;

import com.projetopedidos.estudo.dto.UserDTO;
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

  public User findById (String id) {
    Optional<User> user = repository.findById(id);
    return user.get();
  }

  public User insert(User obj) {
    return repository.insert(obj);
  }

  public User fromDTO(UserDTO objDTO) {
    return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), objDTO.getPhone(), objDTO.getPassword());
  }
}
