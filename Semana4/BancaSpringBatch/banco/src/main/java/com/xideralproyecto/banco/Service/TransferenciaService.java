package com.xideralproyecto.banco.Service;

import java.util.Optional;

import com.xideralproyecto.banco.Entity.TransferenciaEntity;

public interface TransferenciaService {
    void registrarTransferencia(TransferenciaEntity transferenciaEntity);
    Optional<TransferenciaEntity> buscaRTransferencia(Long id);
}
