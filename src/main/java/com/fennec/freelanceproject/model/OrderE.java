package com.fennec.freelanceproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class OrderE {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
    private double amount;
    @Column(columnDefinition = "varchar(255) default 'pending'")
    private String status = "pending";
    private Date orderdate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private AppUser client;

    @Column(name="client_id", updatable=false, insertable=false)
    private Long client_id;


    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    @JsonIgnore
    private AppUser freelancer;

    @Column(name="freelancer_id", updatable=false, insertable=false)
    private Long freelancer_id;

    @OneToOne
    @JoinColumn(name = "offer_id")
    @JsonIgnore
    private Offer offer;

    @Column(name="offer_id", updatable=false, insertable=false)
    private Long offer_id;

}
