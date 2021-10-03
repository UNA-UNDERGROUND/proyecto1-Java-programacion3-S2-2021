package com.una.proyecto1.model.mapa;

public enum CodigoProvincia {
    NINGUNO(0, "Ninguno"), SAN_JOSE(1, "San Jose"), ALAJUELA(2, "Alajuela"), CARTAGO(3, "Cartago"),
    HEREDIA(4, "Heredia"), GUANACASTE(5, "Guanacaste"), PUNTARENAS(6, "Puntarenas"), LIMON(7, "Limon");

    private int codigo;
    public String nombre;

    CodigoProvincia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public static CodigoProvincia getCodigoProvincia(String nombre) {
        for (CodigoProvincia val : CodigoProvincia.values()) {
            if (val.nombre.equals(nombre)) {
                return val;
            }
        }
        return null;
    }

}
