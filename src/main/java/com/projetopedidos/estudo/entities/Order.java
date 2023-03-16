package com.projetopedidos.estudo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    private Instant moment;

    private User client;
    //private OrderStatus orderStatus;


  public Order(UUID id, Instant moment, User client) {
    this.id = id;
    this.moment = moment;
    this.client = client;
  }

  public Order() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("moment", moment)
            .append("client", client)
            .toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(id, order.id) && Objects.equals(moment, order.moment) && Objects.equals(client, order.client);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, moment, client);
  }
}
