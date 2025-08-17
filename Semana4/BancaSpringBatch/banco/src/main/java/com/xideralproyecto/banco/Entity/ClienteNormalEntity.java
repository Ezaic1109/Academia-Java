package com.xideralproyecto.banco.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NORMAL")
public class ClienteNormalEntity extends ClienteEntity{
    
}
