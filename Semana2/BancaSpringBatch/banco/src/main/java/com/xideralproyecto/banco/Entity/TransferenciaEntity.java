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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public CuentaEntity getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(CuentaEntity cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public CuentaEntity getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaEntity cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

}
