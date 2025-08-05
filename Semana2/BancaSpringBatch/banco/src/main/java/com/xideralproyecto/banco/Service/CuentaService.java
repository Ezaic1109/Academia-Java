package com.xideralproyecto.banco.Service;

import java.util.Optional;

import com.xideralproyecto.banco.Entity.CuentaEntity;

public interface CuentaService {
    
    void registrarCuenta(CuentaEntity cuenta);
    Optional<CuentaEntity> buscarPorId(Long id);

}
