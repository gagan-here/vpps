package org.progressivelabs.vpps.mapper;

import java.util.List;

public interface GenericMapper<D, E> {

    D toDTO(E entity);

    E toEntity(D dto);

    List<D> toDTOs(List<E> entityList);

    List<E> toEntities(List<D> dtoList);
}
