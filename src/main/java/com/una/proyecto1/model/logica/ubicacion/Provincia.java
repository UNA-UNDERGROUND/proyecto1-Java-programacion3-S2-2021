package com.una.proyecto1.model.logica.ubicacion;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.una.proyecto1.model.util.xml.IntegerAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Provincia {

    public Provincia(Integer id, String nombre, List<Canton> cantones) {
        this.nombre = nombre;
        this.id = id;
        this.cantones = cantones;

    }

    public Provincia(){
        this(-1, "", new ArrayList<>());
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

    public List<Canton> getCantones() {
        return cantones;
    }

    public void setCantones(List<Canton> cantones) {
        this.cantones = cantones;
    }

    @XmlID
    @XmlAttribute
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    private Integer id;
    private String nombre;
    private List<Canton> cantones;
}
