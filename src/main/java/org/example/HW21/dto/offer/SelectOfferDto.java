package org.example.HW21.dto.offer;

import org.example.HW21.entity.Orders;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SelectOfferDto {

    @NotNull(message = "the order must not be empty.")
    Orders order;

    @NotNull(message = "the offer id must not be empty.")
    Long id;
}
