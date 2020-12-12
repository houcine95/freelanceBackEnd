package com.fennec.freelanceproject.service;

import com.fennec.freelanceproject.model.Offer;
import com.fennec.freelanceproject.model.Proposition;

public interface OrderService {

    public Offer createOffer(Offer offer);

    public Proposition createProposition(Proposition proposition);
}
