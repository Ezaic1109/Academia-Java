// Paquete donde se encuentra esta clase
package com.xideralproyecto.banco.Processor;

// Importamos la interfaz ItemProcessor de Spring Batch
import org.springframework.batch.item.ItemProcessor;

// Importamos las clases que se procesarán: una de base de datos relacional, otra de MongoDB
import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Entity.ClienteMongo;

// Implementación del procesador que convierte un ClienteEntity (relacional) en ClienteMongo (documento)
public class ClienteItemProcessor implements ItemProcessor<ClienteEntity, ClienteMongo> {

    // Método sobrescrito del ItemProcessor
    // Toma un ClienteEntity como entrada y devuelve un ClienteMongo como salida
    @Override
    public ClienteMongo process(ClienteEntity cliente) {
        // Se crea una nueva instancia del documento que se guardará en MongoDB
        ClienteMongo clienteMongo = new ClienteMongo();

        // Se asignan los valores del objeto relacional al objeto documento
        // El ID se convierte a String si originalmente es de tipo Long
        clienteMongo.setId(String.valueOf(cliente.getId()));
        clienteMongo.setNombre(cliente.getNombre());
        clienteMongo.setApellido(cliente.getApellido());
        clienteMongo.setEmail(cliente.getEmail());
        clienteMongo.setTelefono(cliente.getTelefono());
        clienteMongo.setDireccion(cliente.getDireccion());

        // Se devuelve el objeto transformado listo para escribirse en MongoDB
        return clienteMongo;
    }
}