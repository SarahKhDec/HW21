package org.example.HW21.mappers;

import org.example.HW21.dto.offer.CreateOfferDto;
import org.example.HW21.dto.offer.GetOfferForCustomerDto;
import org.example.HW21.dto.offer.SelectOfferDto;
import org.example.HW21.dto.order.GetOrderByCustomerEmailDto;
import org.example.HW21.entity.Offers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfferMapper {
    Offers offerDtoToOffer(CreateOfferDto createOfferDto);
    List<GetOfferForCustomerDto> offerListToDtoList(List<Offers> offersList);
    Offers offerCustomerDtoToOffer(GetOrderByCustomerEmailDto getOrderByCustomerEmailDto);
    Offers selectOfferDtoToOffer(SelectOfferDto selectOfferDto);
}
