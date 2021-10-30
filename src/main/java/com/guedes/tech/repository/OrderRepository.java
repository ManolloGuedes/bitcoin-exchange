package com.guedes.tech.repository;

import com.guedes.tech.model.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

/**
 * Class using Repository pattern instead of Active Record
 */
@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

}
