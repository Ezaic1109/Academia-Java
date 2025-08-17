package com.xideralproyecto.banco;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.xideralproyecto.banco.Entity.ClienteMongo;
import com.xideralproyecto.banco.Repository.ClienteMongoRepository;

@SpringBootApplication
public class BancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}
	//@Bean
   CommandLineRunner testMongo(ClienteMongoRepository repo) {
    return args -> {
        try {
            ClienteMongo cliente = new ClienteMongo();
            //cliente.setId("4");
            cliente.setNombre("Juan");
            cliente.setApellido("Pérez");
            cliente.setEmail("juan@test.com");
            cliente.setTelefono("123456789");
            cliente.setDireccion("CDMX");
            repo.save(cliente);
            System.out.println("✅ Guardado en Mongo");
        } catch (Exception e) {
            System.err.println("❌ Error al guardar en Mongo: " + e.getMessage());
            e.printStackTrace();
        }
    };
    }
}
