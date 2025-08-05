package com.xideralproyecto.banco.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.xideralproyecto.banco.Entity.CuentaEntity;
import com.xideralproyecto.banco.Repository.CuentaRepository;
import com.xideralproyecto.banco.Service.CuentaService;

@Service
public class CuentaServiceImpl implements CuentaService {

    CuentaRepository cuentaRepository;

    CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public void registrarCuenta(CuentaEntity cuenta) {
           cuentaRepository.save(cuenta);
    }

    @Override
    public CuentaEntity buscarPorId(Long id) {
    
        return cuentaRepository.findById(id).orElse(null);
    }

}
