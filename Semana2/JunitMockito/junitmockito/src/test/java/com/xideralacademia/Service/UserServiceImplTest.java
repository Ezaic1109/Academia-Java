package com.xideralacademia.Service;

// Importaciones necesarias para pruebas unitarias con JUnit y Mockito
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.xideralacademia.UserRegister.Model.UserEntity; // Tu modelo de usuario
import com.xideralacademia.UserRegister.Repository.UserRepository; // Repositorio que será simulado (mockeado)
import com.xideralacademia.UserRegister.Service.ServiceImpl.UserServiceImpl; // Implementación del servicio que se va a probar

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Clase de prueba para el servicio UserServiceImpl
 */
public class UserServiceImplTest {

    // 🔧 Crea un objeto simulado (mock) de UserRepository para evitar usar una base de datos real
    @Mock
    private UserRepository userRepository;

    // 🔧 Inyecta el mock anterior en la clase que se va a probar (UserServiceImpl)
    @InjectMocks
    private UserServiceImpl userService;

    /**
     * Este método se ejecuta antes de cada test para inicializar los mocks
     */
    @BeforeEach
    void setUp() {
        // Inicializa todos los objetos anotados con @Mock y @InjectMocks
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Prueba unitaria del método registrarUsr del servicio UserServiceImpl
     */
    @Test
    void testRegistrarUsuario() {
        // Mensaje en consola para saber que el test se está ejecutando
        System.out.println("Ejecutando test de registrar usuario...");

        // 🧍 Crear un objeto UserEntity de prueba (simula un usuario nuevo que se desea registrar)
        UserEntity user = new UserEntity(
            null, // ID null porque aún no se guarda en la base
            "Juan", // Nombre
            "Perez", // Apellido paterno
            "Gomez", // Apellido materno
            30, // Edad
            "juan@example.com", // Correo
            "1993-05-20" // Fecha de nacimiento
        );

        // 🧪 Simular comportamiento del método save del repositorio
        // Cuando se llame a save con cualquier UserEntity, que devuelva el mismo objeto `user`
        when(userRepository.save(any(UserEntity.class))).thenReturn(user);

        // 🚀 Llamar al método que se quiere probar
        UserEntity resultado = userService.registrarUsr(user);

        // ✅ Verificar que el resultado no sea null
        assertNotNull(resultado);

        // ✅ Verificar que el nombre devuelto sea "Juan"
        assertEquals("Juan", resultado.getNombre());

        // ✅ Verificar que se haya llamado al método save() del repositorio exactamente una vez
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }
}