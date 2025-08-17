// Paquete donde se encuentra esta clase
package com.xideralproyecto.banco.Processor;

// Importamos la interfaz ItemProcessor de Spring Batch
import org.springframework.batch.item.ItemProcessor;

import com.xideralproyecto.banco.Entity.ClienteEmpresaEntity;
// Importamos las clases que se procesarán: una de base de datos relacional, otra de MongoDB
import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Entity.ClienteMongo;
import com.xideralproyecto.banco.Entity.ClienteVipEntity;

// Implementación del procesador que convierte un ClienteEntity (relacional) en ClienteMongo (documento)
public class ClienteItemProcessor implements ItemProcessor<ClienteEntity, ClienteMongo> {

    @Override
public ClienteMongo process(ClienteEntity cliente) throws Exception {
    try {
        // Ignorar registros inválidos
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) return null;
        if (cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) return null;

        ClienteMongo clienteMongo = new ClienteMongo();
        clienteMongo.setId(String.valueOf(cliente.getId()));
        clienteMongo.setNombre(cliente.getNombre());
        clienteMongo.setApellido(cliente.getApellido());
        clienteMongo.setEmail(cliente.getEmail());
        clienteMongo.setTelefono(cliente.getTelefono());
        clienteMongo.setDireccion(cliente.getDireccion());

        // Detectar tipo de cliente de manera segura
        String tipo = "NORMAL";
        String nombreEmpresa = null;
        String rfc = null;
        Double limCredito = null;

        if (cliente instanceof ClienteVipEntity vip) {
            tipo = "VIP";
            nombreEmpresa = vip.getNombreEmpresa();
            rfc = vip.getRfc();
        } else if (cliente instanceof ClienteEmpresaEntity empresa) {
            tipo = "EMPRESA";
            limCredito = empresa.getLimCredito();
        }

        clienteMongo.setTipoCliente(tipo);
        clienteMongo.setNombreEmpresa(nombreEmpresa);
        clienteMongo.setRfc(rfc);
        clienteMongo.setLimCredito(limCredito);

        return clienteMongo;

    } catch (Exception e) {
        // Loguear el error y retornar null para que Spring Batch ignore el registro
        System.err.println("Error procesando cliente id=" + cliente.getId() + ": " + e.getMessage());
        e.printStackTrace();
        return null;
    }
}
}