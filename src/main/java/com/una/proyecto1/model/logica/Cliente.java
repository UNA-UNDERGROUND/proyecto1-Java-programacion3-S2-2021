package com.una.proyecto1.model.logica;

public class Cliente {

    public Cliente(Integer id, String nombre, String canton, String provincia, String distrito ) {
        this.id = id;
        this.nombre = nombre;
        this.canton = canton;
        this.provincia = provincia;
        this.distrito= distrito; 
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
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

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
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
    private String canton;
    private String provincia;
    private String distrito; 

}
