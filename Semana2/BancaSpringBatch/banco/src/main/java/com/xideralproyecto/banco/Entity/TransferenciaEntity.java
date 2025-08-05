package com.xideralproyecto.banco.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class TransferenciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double monto;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "origen_id")
    private CuentaEntity cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private CuentaEntity cuentaDestino;

}
