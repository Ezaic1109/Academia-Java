package com.xideralacademia.UserRegister.Controller;

// Importaciones necesarias para la funcionalidad del controlador
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xideralacademia.UserRegister.Dto.UserDTO;        // DTO que recibe el cliente
import com.xideralacademia.UserRegister.Model.UserEntity;  // Entidad que representa al usuario en la base de datos
import com.xideralacademia.UserRegister.Service.UserService; // Interfaz del servicio

import jakarta.validation.Valid;

/**
 * Controlador REST para manejar operaciones relacionadas con usuarios.
 * Expone un endpoint para registrar nuevos usuarios.
 */
@RestController // Marca esta clase como un controlador REST
@RequestMapping("/api/usuarios") // Define la ruta base para todos los endpoints de esta clase
public class UserController {

    // Inyección del servicio de usuario
    private final UserService userService;

    /**
     * Constructor que inyecta el servicio de usuario.
     * Spring puede inyectarlo automáticamente si se usa @ComponentScan y la clase está registrada.
     *
     * @param userService Servicio que contiene la lógica para registrar usuarios
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint para registrar un nuevo usuario.
     * Recibe un objeto JSON (UserDTO) desde el cliente, lo convierte en una entidad,
     * y lo guarda usando el servicio. Devuelve el nuevo usuario creado.
     *
     * @param dto Objeto UserDTO recibido desde el cliente con los datos del usuario
     * @return ResponseEntity con el usuario creado y el código HTTP 201 (CREATED)
     */
    @PostMapping("/registro") // Define el método como un POST a la ruta /api/usuarios/registro
    public ResponseEntity<UserEntity> registrarUsuario(@Valid @RequestBody UserDTO dto) {
        // Convertir el DTO a una entidad
        UserEntity usuario = new UserEntity(
                null, // ID se genera automáticamente (por ejemplo, en la base de datos)
                dto.getNombre(),
                dto.getApellidoP(),
                dto.getApellidoM(),
                dto.getEdad(),
                dto.getCorreo(),
                dto.getFechanac());

        // Llamar al servicio para registrar el usuario
        UserEntity nuevo = userService.registrarUsr(usuario);

        // Devolver el usuario creado con status HTTP 201 (CREATED)
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
}