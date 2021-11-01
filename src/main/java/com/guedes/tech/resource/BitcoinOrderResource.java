package com.guedes.tech.resource;

import com.guedes.tech.model.BitcoinOrder;
import com.guedes.tech.model.User;
import com.guedes.tech.repository.BitcoinOrderRepository;
import com.guedes.tech.service.BitcoinOrderService;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/orders")
public class BitcoinOrderResource {

    @Inject
    BitcoinOrderRepository bitcoinOrderRepository;

    @Inject
    BitcoinOrderService service;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(BitcoinOrder bitcoinOrder, @Context SecurityContext securityContext) {
        try {
            return Response.ok(service.insert(bitcoinOrder, securityContext)).build();
        } catch (Exception e) {
            log.error("Error while inserting bitcoin order", e);
        }

        return Response.serverError().build();
    }
}
