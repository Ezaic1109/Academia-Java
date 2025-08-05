package com.xideralproyecto.banco.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xideralproyecto.banco.Entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {
Optional<ClienteEntity> findByemail(String email);
    
}
