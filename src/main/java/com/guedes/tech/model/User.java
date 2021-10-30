package com.guedes.tech.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.security.auth.kerberos.EncryptionKey;
import javax.transaction.Transactional;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class using architectural pattern Active Record
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@UserDefinition
public class User extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String document;
    @Username
    private String username;
    @Password
    private String password;
    @Roles
    private String role;

    public static void createUser(User user) {
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        user.setRole("user");

        user.persist();
    }
}
