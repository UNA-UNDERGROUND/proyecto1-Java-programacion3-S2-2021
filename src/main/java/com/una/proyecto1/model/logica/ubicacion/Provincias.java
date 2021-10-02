package com.una.proyecto1.model.logica.ubicacion;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Provincias {

    public Provincias() {
        provincias = new ArrayList<>();
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public List<Canton> getCantones(Integer idProvincia) {
        try {
            return getProvincias().get(idProvincia - 1).getCantones();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Distrito> getDistritos(Integer idProvincia, Integer idCanton) {
        try {
            return getCantones(idProvincia).get(idCanton - 1).getDistritos();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @XmlElement(name = "provincia")
    public List<Provincia> provincias;
}
