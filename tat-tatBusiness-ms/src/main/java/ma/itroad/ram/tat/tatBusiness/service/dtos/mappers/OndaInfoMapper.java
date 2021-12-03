package ma.itroad.ram.tat.tatBusiness.service.dtos.mappers;

import org.mapstruct.Mapper;

import ma.itroad.ram.tat.tatBusiness.ms.service.dto.changer.onda.OndaInfoDto;
import ma.itroad.ram.tat.tatBusiness.service.domain.OndaInfo;

@Mapper(componentModel = "spring", uses = OndaInfoMapper.class)
public interface OndaInfoMapper extends EntityMapper<OndaInfoDto, OndaInfo> {

	OndaInfoDto toDto(OndaInfo entity);
	OndaInfo toEntity(OndaInfoDto dto);

}
