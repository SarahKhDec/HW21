package org.example.HW21.mappers;

import org.example.HW21.dto.subservice.GetSubServiceDto;
import org.example.HW21.dto.subservice.SubServiceDto;
import org.example.HW21.dto.subservice.UpdateSubServiceDto;
import org.example.HW21.entity.SubService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubServiceMapper {

    GetSubServiceDto subServiceToDto(SubService subService);

    SubService dtoToSubService(SubServiceDto subServiceDto);

    List<GetSubServiceDto> subServiceListToDtoList(List<SubService> subServices);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "expertSet", ignore = true)
    @Mapping(target = "services", ignore = true)
    SubService updateSubServiceDtoToDto(UpdateSubServiceDto updateSubServiceDto, @MappingTarget SubService subService);
}
