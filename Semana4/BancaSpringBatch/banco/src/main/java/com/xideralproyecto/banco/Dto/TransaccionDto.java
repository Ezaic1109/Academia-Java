package com.xideralproyecto.banco.Dto;

import java.time.LocalDateTime;

import com.xideralproyecto.banco.Entity.CuentaEntity;

import jakarta.validation.constraints.*;

public class TransaccionDto {

    @NotBlank(message = "El tipo de transaccion no debe estar vacio")
    private String tipo; // Deposito, Retiro, Transferencia, etc.

    @NotNull(message = "El monto es obligatorio")
    @PositiveOrZero(message = "El monto no puede ser negativo")
    private Double monto;

    @NotNull(message = "La fecha no debe ser nula")
    private LocalDateTime fecha;

    @NotNull(message = "La cuenta no debe ser nula")
    private CuentaEntity cuenta;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public CuentaEntity getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaEntity cuenta) {
        this.cuenta = cuenta;
    }

}
