package com.guedes.tech.resource;

import com.guedes.tech.model.Order;
import com.guedes.tech.repository.OrderRepository;
import java.time.LocalDateTime;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/orders")
public class OrderResource {

    @Inject
    OrderRepository orderRepository;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Order order) {
        order.setDate(LocalDateTime.now());
        order.setStatus("SENT");
        orderRepository.persist(order);
    }
}
