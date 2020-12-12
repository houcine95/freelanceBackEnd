
package com.fennec.freelanceproject.controller;

import com.fennec.freelanceproject.model.AppUser;
import com.fennec.freelanceproject.model.Offer;
import com.fennec.freelanceproject.model.OrderE;
import com.fennec.freelanceproject.model.Proposition;
import com.fennec.freelanceproject.repository.AppUserRepository;
import com.fennec.freelanceproject.repository.OfferRepository;
import com.fennec.freelanceproject.repository.OrderRepository;
import com.fennec.freelanceproject.repository.PropositionRepository;
import com.fennec.freelanceproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired private AppUserRepository appUserRepository;

    @Autowired private OrderRepository orderRepository;

    @Autowired private OfferRepository offerRepository;

    @Autowired private OrderService orderService;

    @Autowired private PropositionRepository propositionRepository;

    @GetMapping("/orderes")
    public List<OrderE> getOrderes(){
        return orderRepository.findAll();
    }

    @PostMapping("/createorder")
    public OrderE createOrder(@RequestBody OrderForm orderForm) throws Exception {

        OrderE order = new OrderE();

        Long offer_id = orderForm.getOffer_id();
        Long propos_id = orderForm.getProposition_id();

        Optional<Offer> offer = offerRepository.findById(offer_id);
        Optional<Proposition> proposition = propositionRepository.findById(propos_id);

        if(offer == null) throw new Exception("This offer not exists, try again");
        if(proposition == null) throw new Exception("This propsition not exists, try again");



        offer.ifPresent(o -> {
            order.setOffer(o);
            order.setDescription(o.getDescription());
            order.setOrderdate(o.getOrderdate());
            order.setClient(o.getClient());
            o.getPropositions().forEach(p -> {
                if(p.getId() == propos_id){
                    p.setStatus("accepted");
                }else {
                    p.setStatus("rejected");
                }
            });
        });

        proposition.ifPresent(p -> {
            order.setFreelancer(p.getFreelancer());
            order.setAmount(p.getAmount());
        });



        return orderRepository.save(order);
    }

    @PatchMapping(path = "/updateOrder/{id}")
    public Optional<OrderE> updateOrderStatus(@PathVariable Long id, @RequestBody OrderForm orderForm) throws Exception {
        Optional<OrderE> newOrder = orderRepository.findById(id);
        newOrder.ifPresent(o -> {
            o.setStatus(orderForm.getStatus());
            orderRepository.save(o);
        });
        return newOrder;
    }

    @GetMapping("/allOffers")
    public List<Offer> getOffers(){
        return offerRepository.findAll();
    }

    @PostMapping("/newOffer")
    public Offer newOffer(@RequestBody OfferForm offerForm) throws Exception {
        String description = offerForm.getDescription();
        double amount = offerForm.getAmount();
        Date orderdate = offerForm.getOrderdate();
        Long client_id = offerForm.getClient_id();
        Optional<AppUser> client = appUserRepository.findById(client_id);

        if(client == null) throw new Exception("This client not exists, try again");

        Offer offer = new Offer();
        client.ifPresent(c -> {
            offer.setClient(c);
        });
        offer.setAmount(amount);
        offer.setDescription(description);
        offer.setOrderdate(orderdate);

        return orderService.createOffer(offer);
    }

    @GetMapping("/allPropos")
    public List<Proposition> getPropositions(){
        return propositionRepository.findAll();
    }

    @PostMapping("/newprops")
    public Proposition newPrpos(@RequestBody PropositionForm propositionForm) throws Exception {
        String commentaire = propositionForm.getCommentaire();
        double amount = propositionForm.getAmount();
        Date orderdate = propositionForm.getOrderdate();
        Long freelancer_id = propositionForm.getFreelancer_id();
        Long offer_id = propositionForm.getOffer_id();
        Optional<AppUser> freelancer = appUserRepository.findById(freelancer_id);
        Optional<Offer> offer = offerRepository.findById(offer_id);

        if(freelancer == null) throw new Exception("This freelancer not exists, try again");
        if(offer == null) throw new Exception("This offer not exists anymore, try again");

        Proposition proposition = new Proposition();

        freelancer.ifPresent(f -> {
            proposition.setFreelancer(f);
        });
        offer.ifPresent(o -> {
            proposition.setOffer(o);
        });

        proposition.setAmount(amount);
        proposition.setCommentaire(commentaire);
        proposition.setOrderdate(orderdate);

        return orderService.createProposition(proposition);
    }
}
