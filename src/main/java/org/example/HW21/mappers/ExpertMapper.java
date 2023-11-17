package org.example.HW21.mappers;

import org.example.HW21.dto.expert.*;
import org.example.HW21.entity.Expert;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpertMapper {

    GetExpertDto expertToDto(Expert expert);
    @Mapping(target = "imageUrl", ignore = true)
    Expert expertDtoToExpert(RegisterExpertDto registerExpertDto);
    List<GetExpertDto> expertListToDtoList(List<Expert> expertList);

    Expert changePasswordDtoToExpert(ChangeExpertPasswordDto changeExpertPasswordDto);
    Expert expertSubServiceToExpert(ExpertToSubServiceDto expertToSubServiceDto);
    GetScoreDto expertToScoreDto(Expert expert);
    GetExpertCreditDto expertToCreditDto(Expert expert);
}
