package com.xideralproyecto.banco.Service;

import java.util.List;
import java.util.Optional;

import com.xideralproyecto.banco.Dto.ClienteDto;
import com.xideralproyecto.banco.Entity.ClienteEmpresaEntity;
import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Entity.ClienteVipEntity;

public interface ClienteService {

   ClienteDto registrarCliente(ClienteDto clienteDTO);

   ClienteDto registrarClienteEmpresa(ClienteDto clienteDTO);

   ClienteDto registrarClienteVip(ClienteDto clienteDTO);

   Optional<ClienteEntity> buscarPorId(Long id);

   List<? extends ClienteEntity> getAllClientes(); // Covarianza con `? extends`

   // Métodos específicos para cada tipo de cliente
   List<ClienteVipEntity> getAllClientesVip();

   List<ClienteEmpresaEntity> getAllClientesEmpresa();
}
