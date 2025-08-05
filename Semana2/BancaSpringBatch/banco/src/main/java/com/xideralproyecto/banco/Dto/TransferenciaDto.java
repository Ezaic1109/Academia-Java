package com.xideralproyecto.banco.Dto;

import java.time.LocalDateTime;

import com.xideralproyecto.banco.Entity.CuentaEntity;

import jakarta.validation.constraints.*;

public class TransferenciaDto {
    @NotNull(message = "El monto es obligatorio")
    @PositiveOrZero(message = "El monto no puede ser negativo")
    private Double monto;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fecha;

    @NotNull(message = "La cuenta origen es obligatoria")
    private CuentaEntity cuentaOrigen;

    @NotNull(message = "La cuenta destino es obligatoria")
    private CuentaEntity cuentaDestino;

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
