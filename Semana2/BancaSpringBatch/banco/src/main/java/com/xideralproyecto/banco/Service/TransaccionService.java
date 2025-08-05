package com.xideralproyecto.banco.Service;

import com.xideralproyecto.banco.Entity.TransaccionEntity;

public interface TransaccionService {
    void registrarTransaccion(TransaccionEntity transaccionEntity);
    TransaccionEntity buscarTransaccionId(Long id);
}
