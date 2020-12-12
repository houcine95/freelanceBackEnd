package com.fennec.freelanceproject.repository;

import com.fennec.freelanceproject.model.OrderE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderE, Long> {


}
