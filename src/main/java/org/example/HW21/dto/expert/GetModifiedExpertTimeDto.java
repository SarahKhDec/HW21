package org.example.HW21.dto.expert;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetModifiedExpertTimeDto {

    LocalDateTime modifiedTime;
    String modifiedText;
}
