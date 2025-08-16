package com.xideralproyecto.banco.Entity;

public class ClienteVipEntity extends ClienteEntity {
    private String nombreEmpresa;
    private String rfc;

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

}
