package com.fennec.freelanceproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Offer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
    private double amount;
    private Date orderdate;

    @OneToMany(mappedBy = "offer")
    private Collection<Proposition> propositions = new ArrayList<>();

    @OneToOne(mappedBy = "offer")
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderE orderE;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private AppUser client;

    @Column(name="client_id", updatable=false, insertable=false)
    private Long client_id;

}
