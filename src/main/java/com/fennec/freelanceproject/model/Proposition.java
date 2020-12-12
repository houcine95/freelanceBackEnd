package com.fennec.freelanceproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String commentaire;
    @Column(columnDefinition = "varchar(255) default 'pending'")
    private String status = "pending";
    private double amount;
    private Date orderdate;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    @JsonIgnore
    private Offer offer;

    @Column(name="offer_id", updatable=false, insertable=false)
    private Long offer_id;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    @JsonIgnore
    private AppUser freelancer;

    @Column(name="freelancer_id", updatable=false, insertable=false)
    private Long freelancer_id;

}
