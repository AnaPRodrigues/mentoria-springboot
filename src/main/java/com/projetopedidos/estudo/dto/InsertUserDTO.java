package com.projetopedidos.estudo.dto;

import com.projetopedidos.estudo.command.Command;
import com.projetopedidos.estudo.command.user.CreateUserCommand;
import com.projetopedidos.estudo.entities.User;
import com.projetopedidos.estudo.services.generator.GeneratorUUID;

public class InsertUserDTO implements Command {
  private String name;
  private String email;
  private String phone;

  private String password;

  public InsertUserDTO(User obj){
    name = obj.getName();
    email = obj.getEmail();
    phone = obj.getPhone();
    password = obj.getPassword();
  }

  public InsertUserDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CreateUserCommand toInsertUserCommand() {
    GeneratorUUID id = new GeneratorUUID();
    String uuid = id.generatorId();
    return new CreateUserCommand(uuid, this.getName(), this.getEmail(),this.getPhone(), this.getPassword());
  }
}
