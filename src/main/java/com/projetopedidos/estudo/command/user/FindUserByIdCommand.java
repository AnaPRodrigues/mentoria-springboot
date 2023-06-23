package com.projetopedidos.estudo.command.user;

import com.projetopedidos.estudo.command.Command;

public class FindUserByIdCommand implements Command {

  private String id;

  public FindUserByIdCommand(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
