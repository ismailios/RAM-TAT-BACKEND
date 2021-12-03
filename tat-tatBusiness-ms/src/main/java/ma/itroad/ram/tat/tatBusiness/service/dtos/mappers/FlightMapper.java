package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ma.itroad.ram.tat.tatBusiness.service.domain.Flight;
import ma.itroad.ram.tat.tatBusiness.service.dtos.FlightDto;

@Mapper(componentModel = "spring")
public interface FlightMapper extends EntityMapper<FlightDto, Flight> {

     String exp="java(entity.generateTatId())";
     String exp2="java(entity.generateTatType())";

    @Mapping(target="fnNumber",source="fnNumber")
    @Mapping(target="tatId",expression = exp)
    @Mapping(target="tatType",expression =exp2)
    FlightDto toDto(Flight entity);

}
