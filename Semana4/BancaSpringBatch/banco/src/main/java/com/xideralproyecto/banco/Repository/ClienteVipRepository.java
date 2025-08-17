package com.xideralproyecto.banco.Repository;

import org.springframework.stereotype.Repository;

import com.xideralproyecto.banco.Entity.ClienteVipEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteVipRepository extends JpaRepository<ClienteVipEntity,Long> {
    
}
