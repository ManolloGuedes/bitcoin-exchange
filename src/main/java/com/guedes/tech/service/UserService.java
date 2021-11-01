package com.guedes.tech.service;

import com.guedes.tech.model.User;
import io.quarkus.elytron.security.common.BcryptUtil;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {

    public long create(User user) {
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        user.setRole("user");

        user.persist();

        return user.getId();
    }
}
