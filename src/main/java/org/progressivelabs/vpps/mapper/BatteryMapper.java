package org.progressivelabs.vpps.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.progressivelabs.vpps.dto.BatteryDTO;
import org.progressivelabs.vpps.entity.Battery;

import java.util.List;

@Mapper
public interface BatteryMapper extends GenericMapper<BatteryDTO, Battery> {
    BatteryMapper INSTANCE = Mappers.getMapper(BatteryMapper.class);
    BatteryDTO toDTO(Battery entity);

    Battery toEntity(BatteryDTO dto);

    List<BatteryDTO> toDTOs(List<Battery> entityList);

    List<Battery> toEntities(List<BatteryDTO> dtoList);
}
