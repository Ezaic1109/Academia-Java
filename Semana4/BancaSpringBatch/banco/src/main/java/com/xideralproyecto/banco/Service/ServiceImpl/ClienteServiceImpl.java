package com.xideralproyecto.banco.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.xideralproyecto.banco.Dto.ClienteDto;
import com.xideralproyecto.banco.Entity.ClienteEmpresaEntity;
import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Entity.ClienteVipEntity;
import com.xideralproyecto.banco.Repository.ClienteEmpresaRepository;
import com.xideralproyecto.banco.Repository.ClienteRepository;
import com.xideralproyecto.banco.Repository.ClienteVipRepository;
import com.xideralproyecto.banco.Service.ClienteService;
import com.xideralproyecto.banco.mapper.ClienteMapper;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    private final ClienteVipRepository clienteVipRepository;

    private final ClienteEmpresaRepository clienteEmpresaRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper,
            ClienteVipRepository clienteVipRepository, ClienteEmpresaRepository clienteEmpresaRepository) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.clienteEmpresaRepository = clienteEmpresaRepository;
        this.clienteVipRepository = clienteVipRepository;
    }

    @Override
    public Optional<ClienteEntity> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<ClienteEntity> getAllClientes() {
        return clienteRepository.findAll();
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

    @Override
    public List<ClienteVipEntity> getAllClientesVip() {
         return clienteVipRepository.findAll();
    }

    @Override
    public List<ClienteEmpresaEntity> getAllClientesEmpresa() {
       return clienteEmpresaRepository.findAll();
    }

@Override
public ClienteDto registrarClienteVip(ClienteDto clienteDTO) {
    // Validar que no exista un cliente con el mismo email
    Optional<ClienteEntity> existente = clienteRepository.findByemail(clienteDTO.getEmail());
    if (existente.isPresent()) {
        throw new IllegalArgumentException("Ya existe un cliente con ese correo.");
    }

    // Crear la entidad VIP y mapear los campos
    ClienteVipEntity vip = new ClienteVipEntity();
    vip.setNombre(clienteDTO.getNombre());
    vip.setApellido(clienteDTO.getApellido());
    vip.setEmail(clienteDTO.getEmail());
    vip.setTelefono(clienteDTO.getTelefono());
    vip.setDireccion(clienteDTO.getDireccion());

    // Campos extra de VIP
    vip.setNombreEmpresa(clienteDTO.getNombreEmpresa());
    vip.setRfc(clienteDTO.getRfc());

    // Guardar en la base de datos
    ClienteVipEntity guardado = clienteVipRepository.save(vip);

    // Convertir a DTO y devolver
    return clienteMapper.toDTO(guardado); // El mapper debe soportar VIP
}

@Override
public ClienteDto registrarClienteEmpresa(ClienteDto clienteDTO) {
    // Validar que no exista un cliente con el mismo email
    Optional<ClienteEntity> existente = clienteRepository.findByemail(clienteDTO.getEmail());
    if (existente.isPresent()) {
        throw new IllegalArgumentException("Ya existe un cliente con ese correo.");
    }

    // Crear la entidad Empresa y mapear los campos
    ClienteEmpresaEntity empresa = new ClienteEmpresaEntity();
    empresa.setNombre(clienteDTO.getNombre());
    empresa.setApellido(clienteDTO.getApellido());
    empresa.setEmail(clienteDTO.getEmail());
    empresa.setTelefono(clienteDTO.getTelefono());
    empresa.setDireccion(clienteDTO.getDireccion());

    // Campo extra de Empresa
    empresa.setLimCredito(clienteDTO.getLimCredito());

    // Guardar en la base de datos
    ClienteEmpresaEntity guardado = clienteEmpresaRepository.save(empresa);

    // Convertir a DTO y devolver
    return clienteMapper.toDTO(guardado); // El mapper debe soportar Empresa
}
}
