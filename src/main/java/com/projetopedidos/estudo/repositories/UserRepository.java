package com.projetopedidos.estudo.repositories;

import com.projetopedidos.estudo.entities.User;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

}
