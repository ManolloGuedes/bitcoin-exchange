package com.guedes.tech.service;

import com.guedes.tech.model.BitcoinOrder;
import com.guedes.tech.model.User;
import com.guedes.tech.repository.BitcoinOrderRepository;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

@ApplicationScoped
public class BitcoinOrderService {
    @Inject
    BitcoinOrderRepository repository;

    public long insert(BitcoinOrder bitcoinOrder, SecurityContext securityContext) {
        var user = User
                .findByUserName(securityContext.getUserPrincipal().getName()).orElseThrow(() -> new InvalidParameterException("Invalid user"));

        bitcoinOrder.setCreationDate(LocalDateTime.now());
        bitcoinOrder.setStatus("SENT");
        bitcoinOrder.setUser(user);

        repository.persist(bitcoinOrder);

        return bitcoinOrder.getId();
    }
}
