package com.guedes.tech.resource;

import com.guedes.tech.model.User;
import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserResource {

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(User user) {
        User.createUser(user);
    }
}
