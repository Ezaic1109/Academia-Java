package com.xideralproyecto.banco.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.xideralproyecto.banco.Entity.TransferenciaEntity;
import com.xideralproyecto.banco.Repository.TransferenciaRepository;
import com.xideralproyecto.banco.Service.TransferenciaService;

@Service
public class TransferenciaImpl implements TransferenciaService {


    TransferenciaRepository transferenciaRepository;

    TransferenciaImpl(TransferenciaRepository transferenciaRepository){
    this.transferenciaRepository=transferenciaRepository;
    }

    @Override
    public void registrarTransferencia(TransferenciaEntity transferenciaEntity) {
       transferenciaRepository.save(transferenciaEntity);
    }

    @Override
    public TransferenciaEntity buscaRTransferencia(Long id) {
       return transferenciaRepository.findById(id).orElse(null);
    }
    
}
