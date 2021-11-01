package com.guedes.tech.resource;

import com.guedes.tech.model.User;
import com.guedes.tech.service.UserService;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/users")
public class UserResource {

    @Inject
    UserService service;

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(User user) {
        try {
            return Response.ok(service.create(user)).build();
        } catch (Exception e) {
            log.error("Error while inserting bitcoin order", e);
        }
        return Response.serverError().build();
    }
}
