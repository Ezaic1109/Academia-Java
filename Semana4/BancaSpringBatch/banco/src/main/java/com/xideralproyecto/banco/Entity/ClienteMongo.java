package com.xideralproyecto.banco.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "clientes")
public class ClienteMongo {

    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;



    // Campo extra para saber el tipo de cliente
    private String tipoCliente;

    // Campos opcionales
    private String nombreEmpresa; // VIP
    private String rfc;           // VIP
    private Double limCredito;    // Empresa


    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Double getLimCredito() {
        return limCredito;
    }

    public void setLimCredito(Double limCredito) {
        this.limCredito = limCredito;
    }
    
}