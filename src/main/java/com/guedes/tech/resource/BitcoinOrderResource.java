package com.guedes.tech.resource;

import com.guedes.tech.model.BitcoinOrder;
import com.guedes.tech.model.User;
import com.guedes.tech.repository.BitcoinOrderRepository;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/orders")
public class BitcoinOrderResource {

    @Inject
    BitcoinOrderRepository bitcoinOrderRepository;

    @Context
    SecurityContext securityContext;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(BitcoinOrder bitcoinOrder) {
        var user = User.findByUserName(securityContext.getUserPrincipal().getName()).orElseThrow(() -> new InvalidParameterException("Invalid user"));

        bitcoinOrder.setCreationDate(LocalDateTime.now());
        bitcoinOrder.setStatus("SENT");
        bitcoinOrder.setUser(user);
        try {
            bitcoinOrderRepository.persist(bitcoinOrder);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
