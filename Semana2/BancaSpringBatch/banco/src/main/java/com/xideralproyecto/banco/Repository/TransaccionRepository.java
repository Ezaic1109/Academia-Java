package com.xideralproyecto.banco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xideralproyecto.banco.Entity.TransaccionEntity;

@Repository
public interface TransaccionRepository extends JpaRepository<TransaccionEntity,Long>{
    
}
