package org.example.HW21.dto.expert;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetExpertTransactionDto {

    Long id;
    String firstname;
    String lastname;
    String role;
}
