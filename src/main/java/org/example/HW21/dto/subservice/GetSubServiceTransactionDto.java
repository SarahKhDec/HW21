package org.example.HW21.dto.subservice;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetSubServiceTransactionDto {

    Long id;
    String name;
}
