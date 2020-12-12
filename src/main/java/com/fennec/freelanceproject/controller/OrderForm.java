package com.fennec.freelanceproject.controller;

import com.fennec.freelanceproject.model.AppUser;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class OrderForm {

    private Long offer_id;
    private Long proposition_id;
    private String status;
    /*
    private String description;
    private double amount;
    private String status;
    private Date orderdate;
    private Long client_id;
    private Long freelancer_id;
     */
}
