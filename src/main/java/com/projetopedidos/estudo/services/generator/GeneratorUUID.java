package com.projetopedidos.estudo.services.generator;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class GeneratorUUID {

    public String generatorId() {
      return UUID.randomUUID().toString();
    }


}
