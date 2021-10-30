package com.guedes.tech.model;

import java.time.LocalDate;
import javax.json.bind.annotation.JsonbProperty;
import lombok.Data;

@Data
public class Bitcoin {

    private Long id;
    @JsonbProperty("preco")
    private Double price;
    @JsonbProperty("tipo")
    private String type;
    @JsonbProperty("data")
    private LocalDate date;
}
