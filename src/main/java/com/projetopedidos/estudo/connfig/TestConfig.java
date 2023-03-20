package com.projetopedidos.estudo.connfig;

import com.projetopedidos.estudo.entities.User;
import com.projetopedidos.estudo.repositories.UserRepository;
import com.projetopedidos.estudo.services.generator.GeneratorUUID;
import java.util.Arrays;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private GeneratorUUID generatorUUID;


  @Override
  public void run(String... args) throws Exception {

    String id1 = generatorUUID.generatorId();
    String id2 = generatorUUID.generatorId();

    User u1 = new User(id1, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    User u2 = new User(id2, "Alex Green", "alex@gmail.com", "977777777", "123456");

    userRepository.saveAll(Arrays.asList(u1, u2));
  }
}
