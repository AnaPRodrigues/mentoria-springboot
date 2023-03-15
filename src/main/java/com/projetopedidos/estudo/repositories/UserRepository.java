package com.projetopedidos.estudo.repositories;

import com.projetopedidos.estudo.entities.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

}
