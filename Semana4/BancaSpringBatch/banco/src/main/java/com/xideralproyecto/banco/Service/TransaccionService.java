package com.xideralproyecto.banco.Service;

import java.util.Optional;

import com.xideralproyecto.banco.Entity.TransaccionEntity;

public interface TransaccionService {
    void registrarTransaccion(TransaccionEntity transaccionEntity);
   Optional<TransaccionEntity> buscarTransaccionId(Long id);
}
