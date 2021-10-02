package com.una.proyecto1.model.logica.ubicacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.una.proyecto1.model.util.xml.IntegerAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Distrito {

    public Distrito(Integer id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }

    public Distrito() {
        id = -1;
        nombre = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlID
    @XmlAttribute
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    private Integer id;
    private String nombre;
}
