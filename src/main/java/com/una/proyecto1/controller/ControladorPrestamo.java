package com.una.proyecto1.controller;

import com.una.proyecto1.model.mapa.CodigoProvincia;
import com.una.proyecto1.model.mapa.Mapa;
import com.una.proyecto1.model.util.Listener;

public class ControladorPrestamo {

    private ControladorPrestamo() {
        mapa = new Mapa();
    }

    public String getProvinciaActual() {
        return CodigoProvincia.values()[provinciaSelec].getNombre();
    }

    public int getCodigoProvincia() {
        return provinciaSelec;
    }

    public void setCodigoProvincia(int provinciaSelec) {
        this.provinciaSelec = provinciaSelec;
        if (provinciaListener!=null) 
        {
           provinciaListener.notificar(); 
        }

    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setProvinciaListener(Listener l) {
        this.provinciaListener = l;
    }

    private Mapa mapa;
    private int provinciaSelec = 0;

    private Listener provinciaListener = null;

    public static ControladorPrestamo getInstancia() {
        if (instancia == null) {
            instancia = new ControladorPrestamo();
        }
        return instancia;
    }

    private static ControladorPrestamo instancia = null;
}
