package com.xideralproyecto.banco.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xideralproyecto.banco.Entity.ClienteMongo;


public interface ClienteMongoRepository extends MongoRepository<ClienteMongo, String>{
    
}
