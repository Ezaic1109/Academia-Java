// Declaración del paquete donde se encuentra esta clase
package com.xideralproyecto.banco.Repository;

// Importación de la interfaz MongoRepository de Spring Data para trabajar con MongoDB
import org.springframework.data.mongodb.repository.MongoRepository;

// Importación de la entidad ClienteMongo que será gestionada por este repositorio
import com.xideralproyecto.banco.Entity.ClienteMongo;

/**
 * Esta interfaz actúa como repositorio para acceder a los datos de clientes almacenados en MongoDB.
 * Extiende MongoRepository, lo cual le proporciona métodos CRUD como save(), findAll(), deleteById(), etc.
 */
public interface ClienteMongoRepository extends MongoRepository<ClienteMongo, String> {
    // No es necesario declarar métodos adicionales si solo se usarán los métodos básicos de MongoRepository
    // El segundo parámetro indica que el tipo del ID de ClienteMongo es String
}