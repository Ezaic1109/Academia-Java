package com.xideralproyecto.banco.Dto;

import jakarta.validation.constraints.*;

public class CuentaDto {

    @NotBlank(message = "El número de cuenta no puede estar vacío")
    @Pattern(regexp = "\\d+", message = "El número de cuenta debe contener solo dígitos")
    private String numeroCuenta;

    @NotBlank(message = "El tipo de cuenta no puede estar vacío")
    private String tipo; // Ahorro, Corriente, etc.

    @PositiveOrZero(message = "El saldo no puede ser negativo")
    private Double saldo;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

     
}
