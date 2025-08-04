package com.xideralacademia.UserRegister.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xideralacademia.UserRegister.Dto.UserDTO;
import com.xideralacademia.UserRegister.Model.UserEntity;
import com.xideralacademia.UserRegister.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registro")
    public ResponseEntity<UserEntity> registrarUsuario(@Valid @RequestBody UserDTO dto) {
        UserEntity usuario = new UserEntity(
                null,
                dto.getNombre(),
                dto.getApellidoP(),
                dto.getApellidoM(),
                dto.getEdad(),
                dto.getCorreo(),
                dto.getFechanac());

        UserEntity nuevo = userService.registrarUsr(usuario);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
}
