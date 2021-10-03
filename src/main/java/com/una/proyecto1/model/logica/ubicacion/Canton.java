package com.una.proyecto1.model.logica.ubicacion;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.una.proyecto1.model.util.xml.IntegerAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Canton {

    public Canton(Integer id, String nombre, List<Distrito> distritos) {
        this.nombre = nombre;
        this.distritos = distritos;
        this.id = id;
    }

    public Canton() {
        id = -1;
        nombre = "";
        distritos = new ArrayList<Distrito>();
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

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    @Override
    public boolean equals(Object other) {
        if (other != null) {
            try {
                Canton obj = Canton.class.cast(other);
                return id.equals(obj.id) && nombre.equals(obj.nombre);
            } catch (ClassCastException e) {
                return nombre.equals(other);
            }
        }
        return false;
    }

    @XmlID
    @XmlAttribute
    @XmlJavaTypeAdapter(IntegerAdapter.class)
    private Integer id;
    private String nombre;
    @XmlElement(name = "distrito")
    @XmlElementWrapper(name = "distritos")
    private List<Distrito> distritos;

}
