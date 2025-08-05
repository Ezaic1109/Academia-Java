package com.xideralproyecto.banco.mapper;

import org.springframework.stereotype.Component;

import com.xideralproyecto.banco.Dto.ClienteDto;
import com.xideralproyecto.banco.Entity.ClienteEntity;
@Component
public class ClienteMapper {
       public ClienteEntity toEntity(ClienteDto dto) {
    ClienteEntity entity = new ClienteEntity();
    entity.setNombre(dto.getNombre());
    entity.setApellido(dto.getApellido());
    entity.setEmail(dto.getEmail());
    entity.setTelefono(dto.getTelefono());
    entity.setDireccion(dto.getDireccion());
    return entity;
}

public ClienteDto toDTO(ClienteEntity entity) {
    ClienteDto dto = new ClienteDto();
    dto.setNombre(entity.getNombre());
    dto.setApellido(entity.getApellido());
    dto.setEmail(entity.getEmail());
    dto.setTelefono(entity.getTelefono());
    dto.setDireccion(entity.getDireccion());
    return dto;
}
    
}
