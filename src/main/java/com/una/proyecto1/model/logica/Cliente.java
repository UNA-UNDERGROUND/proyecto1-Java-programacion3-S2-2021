package com.una.proyecto1.model.logica;

import com.una.proyecto1.model.logica.ubicacion.Canton;
import com.una.proyecto1.model.logica.ubicacion.Distrito;

public class Cliente {

    public Cliente(Integer id, String nombre, String provincia, Canton canton, Distrito distrito) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    private Integer id;
    private String nombre;
    private String provincia;
    private Canton canton;
    private Distrito distrito;

}
