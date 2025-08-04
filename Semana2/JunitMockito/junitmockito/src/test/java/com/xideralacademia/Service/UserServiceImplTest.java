package com.xideralacademia.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.xideralacademia.UserRegister.Model.UserEntity;
import com.xideralacademia.UserRegister.Repository.UserRepository;
import com.xideralacademia.UserRegister.Service.ServiceImpl.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;  // Instancia correcta del servicio a probar

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarUsuario() {
          System.out.println("Ejecutando test de registrar usuario..."); 
        UserEntity user = new UserEntity(null, "Juan", "Perez", "Gomez", 30, "juan@example.com", "1993-05-20");

        when(userRepository.save(any(UserEntity.class))).thenReturn(user);

        UserEntity resultado = userService.registrarUsr(user);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombre());
   verify(userRepository, times(1)).save(any(UserEntity.class)); 
    }
}