package com.guedes.tech.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity(name = "bitcoin_order")
public class BitcoinOrder extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float price;
    private String type;
    private LocalDateTime creationDate;
    private String status;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;
}
