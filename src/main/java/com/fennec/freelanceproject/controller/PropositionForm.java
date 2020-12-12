package com.fennec.freelanceproject.controller;

import lombok.Data;

import java.util.Date;

@Data
public class PropositionForm {

    private String commentaire;
    private double amount;
    private Date orderdate;
    private Long offer_id;
    private Long freelancer_id;
}
