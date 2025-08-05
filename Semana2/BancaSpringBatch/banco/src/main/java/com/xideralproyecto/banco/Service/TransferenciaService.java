package com.xideralproyecto.banco.Service;

import com.xideralproyecto.banco.Entity.TransferenciaEntity;

public interface TransferenciaService {
    void registrarTransferencia(TransferenciaEntity transferenciaEntity);
    TransferenciaEntity buscaRTransferencia(Long id);
}
