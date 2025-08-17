package com.xideralproyecto.banco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xideralproyecto.banco.Entity.CuentaEntity;
@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity,Long> {

    
}
