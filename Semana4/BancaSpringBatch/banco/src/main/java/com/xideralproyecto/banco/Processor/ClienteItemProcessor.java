// Paquete donde se encuentra esta clase
package com.xideralproyecto.banco.Processor;

// Importamos la interfaz ItemProcessor de Spring Batch
import org.springframework.batch.item.ItemProcessor;

// Importamos las clases que se procesarán: una de base de datos relacional, otra de MongoDB
import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Entity.ClienteMongo;

// Implementación del procesador que convierte un ClienteEntity (relacional) en ClienteMongo (documento)
public class ClienteItemProcessor implements ItemProcessor<ClienteEntity, ClienteMongo> {

      @Override
    public ClienteMongo process(ClienteEntity cliente) throws Exception {

        // Validaciones simples
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email del cliente no puede estar vacío.");
        }
        // Agrega más validaciones según tu modelo (teléfono, dirección, etc.)

        ClienteMongo clienteMongo = new ClienteMongo();
        clienteMongo.setId(String.valueOf(cliente.getId()));
        clienteMongo.setNombre(cliente.getNombre());
        clienteMongo.setApellido(cliente.getApellido());
        clienteMongo.setEmail(cliente.getEmail());
        clienteMongo.setTelefono(cliente.getTelefono());
        clienteMongo.setDireccion(cliente.getDireccion());

        return clienteMongo;
    }
}