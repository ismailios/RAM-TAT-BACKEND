package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ma.itroad.ram.tat.tatBusiness.service.domain.Tat;
import ma.itroad.ram.tat.tatBusiness.service.dtos.TatDto;




@Mapper(componentModel = "spring",uses = {TatMapper.class, PassengerInfoMapper.class, PassengerMapper.class, FlightSitatxMapper.class,LoadSheetMapper.class,OndaInfoMapper.class})
public interface TatMapper {


	Tat toEntity(TatDto dto);

    @Mapping(target="flights",source="flights")
    @Mapping(target="id",source="id")
    @Mapping(target="startDate",source="startDate")
    @Mapping(target="endDate",source="endDate")
    @Mapping(target = "duration",source="duration")
    @Mapping(target="progressDB",source="progress")
    TatDto toDto(Tat entity);

}
