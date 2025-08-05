package com.xideralproyecto.banco.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Repository.ClienteRepository;
import com.xideralproyecto.banco.Service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

ClienteRepository clienteRepository;

ClienteServiceImpl(ClienteRepository clienteRepository){
    this.clienteRepository=clienteRepository;

}

    @Override
    public void registrarCliente(ClienteEntity cliente) {
        clienteRepository.save(cliente);
      }

    @Override
    public ClienteEntity buscarPorId(Long id) {
      return clienteRepository.findById(id).orElse(null);
    }
    
}
