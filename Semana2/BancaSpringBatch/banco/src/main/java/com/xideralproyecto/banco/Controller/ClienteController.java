package com.xideralproyecto.banco.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xideralproyecto.banco.Dto.ClienteDto;
import com.xideralproyecto.banco.Service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/banco/clientes")
public class ClienteController {
 private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCliente(@Valid @RequestBody ClienteDto clienteDTO) {
        clienteService.registrarCliente(clienteDTO);
        return new ResponseEntity<>("Cliente registrado con éxito", HttpStatus.CREATED);
    }
    
}