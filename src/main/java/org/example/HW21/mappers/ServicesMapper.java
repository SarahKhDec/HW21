package org.example.HW21.mappers;

import org.example.HW21.dto.service.GetServicesDto;
import org.example.HW21.dto.service.ServicesDto;
import org.example.HW21.entity.Services;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicesMapper {

    Services dtoToServices(ServicesDto servicesDto);
    GetServicesDto servicesToDto(Services services);

    List<GetServicesDto> servicesListToDtoList(List<Services> services);
}
