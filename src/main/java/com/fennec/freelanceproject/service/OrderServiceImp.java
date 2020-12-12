package com.fennec.freelanceproject.service;

import com.fennec.freelanceproject.model.Offer;
import com.fennec.freelanceproject.model.Proposition;
import com.fennec.freelanceproject.repository.OfferRepository;
import com.fennec.freelanceproject.repository.OrderRepository;
import com.fennec.freelanceproject.repository.PropositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired private OrderRepository orderRepository;

    @Autowired private OfferRepository offerRepository;

    @Autowired private PropositionRepository propositionRepository;

    @Override
    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Proposition createProposition(Proposition proposition) {
        return propositionRepository.save(proposition);
    }


}
