package com.xideralproyecto.banco.Processor;

import org.springframework.batch.item.ItemProcessor;

import com.xideralproyecto.banco.Entity.ClienteEntity;
import com.xideralproyecto.banco.Entity.ClienteMongo;

public class ClienteItemProcessor implements ItemProcessor<ClienteEntity, ClienteMongo> {

       @Override
    public ClienteMongo process(ClienteEntity cliente) {
        ClienteMongo clienteMongo = new ClienteMongo();
        clienteMongo.setId(String.valueOf(cliente.getId())); // si id es Long
        clienteMongo.setNombre(cliente.getNombre());
        clienteMongo.setApellido(cliente.getApellido());
        clienteMongo.setEmail(cliente.getEmail());
        clienteMongo.setTelefono(cliente.getTelefono());
        clienteMongo.setDireccion(cliente.getDireccion());
        return clienteMongo;
    }
}