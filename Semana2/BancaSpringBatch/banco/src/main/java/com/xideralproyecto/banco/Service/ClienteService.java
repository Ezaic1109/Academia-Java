package com.xideralproyecto.banco.Service;

import com.xideralproyecto.banco.Entity.ClienteEntity;

public interface ClienteService {

   void registrarCliente(ClienteEntity cliente);

   ClienteEntity buscarPorId(Long id);
    
}
