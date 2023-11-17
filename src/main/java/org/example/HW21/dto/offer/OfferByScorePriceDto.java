package org.example.HW21.dto.offer;

import lombok.*;
import lombok.experimental.FieldDefaults;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OfferByScorePriceDto {
    Long offerId;
    Integer score;
    String email;
    Long proposedPrice;

    public OfferByScorePriceDto(Long offerId, Integer score, String email, Long proposedPrice) {
        this.offerId = offerId;
        this.score = score;
        this.email = email;
        this.proposedPrice = proposedPrice;
    }
}

