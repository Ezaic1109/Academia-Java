package com.xideralproyecto.banco.mapper;

// Se utiliza @Component para que Spring detecte esta clase como un bean manejado automáticamente.
import org.springframework.stereotype.Component;

// Importamos las clases necesarias para hacer la conversión entre DTO y Entity.
import com.xideralproyecto.banco.Dto.ClienteDto;
import com.xideralproyecto.banco.Entity.ClienteEntity;

// Anotamos la clase con @Component para habilitar la inyección de dependencias en otras partes del proyecto.
@Component
public class ClienteMapper {

    // Este método convierte un objeto ClienteDto en un objeto ClienteEntity.
    public ClienteEntity toEntity(ClienteDto dto) {
        ClienteEntity entity = new ClienteEntity(); // Creamos una nueva instancia de ClienteEntity.

        // Asignamos cada uno de los campos del DTO al Entity correspondiente.
        entity.setNombre(dto.getNombre());
        entity.setApellido(dto.getApellido());
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        entity.setDireccion(dto.getDireccion());

        // Retornamos el objeto ya convertido.
        return entity;
    }

    // Este método convierte un objeto ClienteEntity en un objeto ClienteDto.
    public ClienteDto toDTO(ClienteEntity entity) {
        ClienteDto dto = new ClienteDto(); // Creamos una nueva instancia de ClienteDto.

        // Asignamos cada uno de los campos del Entity al DTO correspondiente.
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setEmail(entity.getEmail());
        dto.setTelefono(entity.getTelefono());
        dto.setDireccion(entity.getDireccion());

        // Retornamos el objeto ya convertido.
        return dto;
    }
}