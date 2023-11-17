package org.example.HW21.controller;

import org.example.HW21.dto.offer.CreateOfferDto;
import org.example.HW21.dto.offer.GetOfferForCustomerDto;
import org.example.HW21.dto.offer.SelectOfferDto;
import org.example.HW21.dto.order.GetOrderByCustomerEmailDto;
import org.example.HW21.entity.Offers;
import org.example.HW21.mappers.OfferMapper;
import org.example.HW21.service.impl.OfferServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/offer")
public class OfferController {

    private final OfferServiceImpl offerService;
    private final OfferMapper offerMapper;

    @PostMapping("/create")
    @PreAuthorize("hasRole('Expert')")
    public ResponseEntity<String> create(@Valid @RequestBody CreateOfferDto createOfferDto) {
        Offers offers = offerMapper.offerDtoToOffer(createOfferDto);
        offerService.create(offers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/findAll/orderByProposedPrice")
    @PreAuthorize("hasRole('Customer')")
    public List<GetOfferForCustomerDto> orderByProposedPrice(@Valid @RequestBody GetOrderByCustomerEmailDto getOrderByCustomerEmailDto) {
        Offers offers = offerMapper.offerCustomerDtoToOffer(getOrderByCustomerEmailDto);
        return offerMapper.offerListToDtoList(offerService.orderByProposedPrice(offers));
    }

    @PostMapping("/findAll/orderByScore")
    @PreAuthorize("hasRole('Customer')")
    public List<GetOfferForCustomerDto> orderByScore(@Valid @RequestBody GetOrderByCustomerEmailDto getOrderByCustomerEmailDto) {
        Offers offers = offerMapper.offerCustomerDtoToOffer(getOrderByCustomerEmailDto);
        return offerMapper.offerListToDtoList(offerService.orderByScore(offers));
    }

    @PostMapping("/selectOffer")
    @PreAuthorize("hasRole('Customer')")
    public ResponseEntity<String> selectOffer(@Valid @RequestBody SelectOfferDto selectOfferDto) {
        Offers offers = offerMapper.selectOfferDtoToOffer(selectOfferDto);
        offerService.selectOffer(offers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
