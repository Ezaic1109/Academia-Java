package com.xideralproyecto.banco.Service.ServiceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.xideralproyecto.banco.Dto.ClienteDto;
import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Repository.ClienteRepository;
import com.xideralproyecto.banco.Service.ClienteService;
import com.xideralproyecto.banco.mapper.ClienteMapper;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

private final ClienteMapper clienteMapper;

public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
    this.clienteRepository = clienteRepository;
    this.clienteMapper = clienteMapper;
}

    @Override
    public Optional<ClienteEntity> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

   

    @Override
    public ClienteDto registrarCliente(ClienteDto clienteDTO) {
        Optional<ClienteEntity> existente = clienteRepository.findByemail(clienteDTO.getEmail());
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un cliente con ese correo.");
        }

        ClienteEntity clienteEntity = clienteMapper.toEntity(clienteDTO);
        ClienteEntity guardado = clienteRepository.save(clienteEntity);
        return clienteMapper.toDTO(guardado);
    }
}
