package com.xideralproyecto.banco.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity 
@DiscriminatorValue("EMPRESA")
public class ClienteEmpresaEntity extends ClienteEntity{
    
    Double limCredito;

    public Double getLimCredito() {
        return limCredito;
    }

    public void setLimCredito(Double limCredito) {
        this.limCredito = limCredito;
    }

   
}
