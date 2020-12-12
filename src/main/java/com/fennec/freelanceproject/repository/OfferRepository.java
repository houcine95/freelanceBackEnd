package com.fennec.freelanceproject.repository;

import com.fennec.freelanceproject.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
