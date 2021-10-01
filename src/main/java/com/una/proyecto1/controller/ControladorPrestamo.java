package com.una.proyecto1.controller;

import java.util.ArrayList;
import java.util.List;

import com.una.proyecto1.model.logica.Cliente;
import com.una.proyecto1.model.mapa.CodigoProvincia;
import com.una.proyecto1.model.mapa.Mapa;
import com.una.proyecto1.model.util.Listener;

public class ControladorPrestamo {

    private ControladorPrestamo() {
        mapa = new Mapa();

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
        if (recuperarCliente(id) != null) {
            clientes.add(new Cliente(id, nombre, canton, provincia, distrito));
            return true;
        }
        return false;

    }

    public Cliente recuperarCliente(Integer id) {
        for (Cliente actual : clientes) {
            if (actual.getId() == id) {
                return actual;
            }
        }
        return null;
    }

    private Mapa mapa;
    private int provinciaSelec = 0;
    List<Cliente> clientes = new ArrayList<>();

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
