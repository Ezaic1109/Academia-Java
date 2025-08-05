package com.xideralproyecto.banco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xideralproyecto.banco.Entity.TransferenciaEntity;
@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaEntity,Long> {
    
}
