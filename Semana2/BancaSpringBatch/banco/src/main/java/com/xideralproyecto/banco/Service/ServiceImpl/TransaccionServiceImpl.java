package com.xideralproyecto.banco.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.xideralproyecto.banco.Entity.TransaccionEntity;
import com.xideralproyecto.banco.Repository.TransaccionRepository;
import com.xideralproyecto.banco.Service.TransaccionService;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    TransaccionRepository transaccionRepository;

    TransaccionServiceImpl(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    @Override
    public void registrarTransaccion(TransaccionEntity transaccionEntity) {
            transaccionRepository.save(transaccionEntity);
    }

    @Override
    public TransaccionEntity buscarTransaccionId(Long id) {

        return transaccionRepository.findById(id).orElse(null);
    }

}
