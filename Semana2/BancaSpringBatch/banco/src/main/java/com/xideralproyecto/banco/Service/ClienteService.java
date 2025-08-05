package com.xideralproyecto.banco.Service;

import java.util.Optional;

import com.xideralproyecto.banco.Dto.ClienteDto;
import com.xideralproyecto.banco.Entity.ClienteEntity;


public interface ClienteService {

   ClienteDto registrarCliente(ClienteDto clienteDTO);

   Optional<ClienteEntity> buscarPorId(Long id);
   
    
}
