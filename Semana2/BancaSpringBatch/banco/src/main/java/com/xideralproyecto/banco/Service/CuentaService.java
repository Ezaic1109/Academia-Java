package com.xideralproyecto.banco.Service;

import com.xideralproyecto.banco.Entity.CuentaEntity;

public interface CuentaService {
    
    void registrarCuenta(CuentaEntity cuenta);
    CuentaEntity buscarPorId(Long id);

}
