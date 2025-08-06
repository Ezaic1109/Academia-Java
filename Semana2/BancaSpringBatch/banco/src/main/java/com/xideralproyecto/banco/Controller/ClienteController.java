package com.xideralproyecto.banco.Controller; // Define el paquete donde se encuentra esta clase

import org.springframework.http.HttpStatus; // Importa la clase que contiene los códigos de estado HTTP (como 200, 201, 400, etc.)
import org.springframework.http.ResponseEntity; // Importa la clase que representa toda la respuesta HTTP (incluyendo cuerpo, estado y cabeceras)
import org.springframework.web.bind.annotation.PostMapping; // Importa la anotación para mapear solicitudes HTTP POST a un método
import org.springframework.web.bind.annotation.RequestBody; // Importa la anotación para indicar que el parámetro del método se obtiene del cuerpo de la solicitud
import org.springframework.web.bind.annotation.RequestMapping; // Importa la anotación que define la ruta base del controlador
import org.springframework.web.bind.annotation.RestController; // Importa la anotación que marca esta clase como un controlador REST

import com.xideralproyecto.banco.Dto.ClienteDto; // Importa la clase DTO que contiene los datos del cliente a registrar
import com.xideralproyecto.banco.Service.ClienteService; // Importa la interfaz del servicio que contiene la lógica de negocio para manejar clientes

import jakarta.validation.Valid; // Importa la anotación que activa la validación automática del objeto recibido en el cuerpo de la solicitud

@RestController // Indica que esta clase es un controlador REST y que los métodos devolverán directamente el cuerpo de la respuesta
@RequestMapping("/banco/clientes") // Define la ruta base para todos los endpoints de este controlador (por ejemplo: /banco/clientes/registrar)
public class ClienteController {

    private final ClienteService clienteService; // Define una variable para acceder a la lógica del servicio de clientes

    // Constructor que permite la inyección del servicio ClienteService cuando se crea este controlador
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Define el endpoint POST para registrar un nuevo cliente en la ruta: /banco/clientes/registrar
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarCliente(@Valid @RequestBody ClienteDto clienteDTO) {
        clienteService.registrarCliente(clienteDTO); // Llama al servicio para registrar al cliente usando los datos recibidos
        return new ResponseEntity<>("Cliente registrado con éxito", HttpStatus.CREATED); // Retorna una respuesta con mensaje y código 201 (CREATED)
    }
}