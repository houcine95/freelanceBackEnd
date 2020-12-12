package com.fennec.freelanceproject.controller;

import lombok.Data;

import java.util.Date;

@Data
public class OfferForm {

    private String description;
    private double amount;
    private Date orderdate;
    private Long client_id;
}
