package com.projetopedidos.estudo.entities;

import com.mongodb.lang.Nullable;
import com.projetopedidos.estudo.command.user.CreateUserCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @Nullable
    private List<Order> listOrder = new ArrayList<>();

    public User() {}

    public User(CreateUserCommand command) {
        this.id = command.getId();
        this.name = command.getName();
        this.email = command.getEmail();
        this.phone = command.getPhone();
        this.password = command.getPassword();
        this.listOrder = this.getListOrder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Order> getListOrder() {
        return listOrder;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("email", email)
                .append("phone", phone)
                .append("password", password)
                .append("listOrder", listOrder)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User user)) {
            return false;
        }
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, password);
    }

}
