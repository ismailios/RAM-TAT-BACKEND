package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import org.mapstruct.Mapper;

import ma.itroad.ram.tat.tatBusiness.service.domain.LoadSheet;
import ma.itroad.ram.tat.tatBusiness.service.dtos.changer.loadSheet.LoadSheetDto;


@Mapper(componentModel = "spring", uses = LoadSheetMapper.class)
public interface LoadSheetMapper extends EntityMapper<LoadSheetDto, LoadSheet> {

	LoadSheetDto toDto(LoadSheet entity);
	LoadSheet toEntity(LoadSheetDto dto);

}