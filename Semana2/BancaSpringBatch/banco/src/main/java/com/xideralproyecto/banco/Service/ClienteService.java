package com.xideralproyecto.banco.Service;

import java.util.Optional;

import com.xideralproyecto.banco.Entity.ClienteEntity;

public interface ClienteService {

   void registrarCliente(ClienteEntity cliente);

   Optional<ClienteEntity> buscarPorId(Long id);
   
    
}
