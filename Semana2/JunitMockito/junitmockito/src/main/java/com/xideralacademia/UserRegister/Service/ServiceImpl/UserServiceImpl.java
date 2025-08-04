package com.xideralacademia.UserRegister.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.xideralacademia.UserRegister.Model.UserEntity;
import com.xideralacademia.UserRegister.Repository.UserRepository;
import com.xideralacademia.UserRegister.Service.UserService;

/**
 * Implementación del servicio para la gestión de usuarios.
 * Provee operaciones relacionadas con la entidad UserEntity.
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Repositorio para operaciones CRUD sobre la entidad UserEntity.
     */
    private final UserRepository user;

    /**
     * Constructor que inyecta el repositorio UserRepository.
     * 
     * @param user Repositorio para gestionar usuarios
     */
    public UserServiceImpl(UserRepository user) {
        this.user = user;
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     * 
     * @param usr entidad de usuario a registrar
     * @return la entidad de usuario persistida
     */
    @Override
    public UserEntity registrarUsr(UserEntity usr) {
        if (!usr.getCorreo().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Correo no válido");
        }
        return user.save(usr);
    }

    @Override
    public UserEntity updateUsr(UserEntity usr) {
        return user.save(usr);
    }
}