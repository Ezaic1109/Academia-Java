package com.xideralacademia.UserRegister.Service;

// Importa la clase de entidad que representa al usuario
import com.xideralacademia.UserRegister.Model.UserEntity;

/**
 * Interfaz que define los métodos del servicio de usuario.
 * Sirve como contrato que debe cumplir cualquier clase que implemente la lógica de negocio
 * relacionada con el registro y manejo de usuarios.
 */
public interface UserService {

    /**
     * Registra un nuevo usuario en el sistema.
     * 
     * @param user Objeto UserEntity que representa al usuario a registrar.
     * @return El usuario guardado (puede incluir el ID generado, etc.).
     */
    UserEntity registrarUsr(UserEntity user);
    UserEntity updateUsr(UserEntity user);
    
}