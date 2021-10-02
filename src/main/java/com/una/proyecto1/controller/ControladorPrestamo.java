package com.una.proyecto1.controller;

import java.util.ArrayList;
import java.util.List;

import com.una.proyecto1.model.logica.Cliente;
import com.una.proyecto1.model.logica.ubicacion.Canton;
import com.una.proyecto1.model.logica.ubicacion.Distrito;
import com.una.proyecto1.model.logica.ubicacion.Provincia;
import com.una.proyecto1.model.logica.ubicacion.Provincias;
import com.una.proyecto1.model.mapa.CodigoProvincia;
import com.una.proyecto1.model.mapa.Mapa;
import com.una.proyecto1.model.util.Listener;
import com.una.proyecto1.model.util.xml.XMLparser;

public class ControladorPrestamo {

    private ControladorPrestamo() {
        mapa = new Mapa();
        provincias = XMLparser.unmarshall(new Provincias(), "data/provincias.xml", true);
    }

    // -- Informacion Provincias --

    public List<Provincia> getProvincias() {
        return provincias.getProvincias();
    }

    public List<Canton> getCantones(Integer idProvincia) {
        return provincias.getCantones(idProvincia);
    }

    public List<Distrito> getDistritos(Integer idProvincia, Integer idCanton) {
        return provincias.getDistritos(idProvincia, idCanton);
    }

    // -- Mapa --

    public String getProvinciaActual() {
        return CodigoProvincia.values()[provinciaSelec].getNombre();
    }

    public int getCodigoProvincia() {
        return provinciaSelec;
    }

    public void setCodigoProvincia(int provinciaSelec) {
        this.provinciaSelec = provinciaSelec;
        if (provinciaListener != null) {
            provinciaListener.notificar();
        }
    }

    public Mapa getMapa() {
        return mapa;
    }

    // -- Cliente --

    public boolean agregarCliente(Integer id, String nombre, String canton, String provincia, String distrito) {
        if (recuperarCliente(id) == null) {
            clientes.add(new Cliente(id, nombre, canton, provincia, distrito));
            return true;
        }
        return false;

    }

    public Cliente recuperarCliente(Integer id) {
        for (Cliente actual : clientes) {
            if (actual.getId().equals(id)) {
                return actual;
            }
        }
        return null;
    }

    private Mapa mapa;
    private int provinciaSelec = 0;
    List<Cliente> clientes = new ArrayList<>();
    Provincias provincias;

    // -- implementacion patrones --

    public void setProvinciaListener(Listener l) {
        this.provinciaListener = l;
    }

    private Listener provinciaListener = null;

    private static ControladorPrestamo instancia = null;

    public static ControladorPrestamo getInstancia() {
        if (instancia == null) {
            instancia = new ControladorPrestamo();
        }
        return instancia;
    }
}
