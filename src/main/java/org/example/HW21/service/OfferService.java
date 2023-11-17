package org.example.HW21.service;

import org.example.HW21.entity.Offers;

import java.util.List;

public interface OfferService {

    void create(Offers offers);
    List<Offers> orderByProposedPrice(Offers offers);
    List<Offers> orderByScore(Offers offers);
    void selectOffer(Offers offers);
}
