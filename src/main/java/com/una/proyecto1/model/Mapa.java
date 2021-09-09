package com.una.proyecto1.model;

import java.util.ArrayList;

import com.una.proyecto1.model.geometria.Area;
import com.una.proyecto1.model.geometria.Punto;

enum CODIGO_PROVINCIA {
    SAN_JOSE(1), ALAJUELA(2), CARTAGO(3), HEREDIA(4), GUANACASTE(5), PUNTARENAS(6), LIMON(7);

    private int codigo;

    CODIGO_PROVINCIA(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}

public class Mapa {

    public Mapa() {
        crearPuntos();
        crearProvincias();
    }

    private void crearPuntos() {
        puntos.add(new Punto(42, 48)); // 1
        puntos.add(new Punto(102, 50)); // 2
        puntos.add(new Punto(111, 160)); // 3
        puntos.add(new Punto(251, 160)); // 4
        puntos.add(new Punto(136, 71)); // 5
        puntos.add(new Punto(244, 76)); // 6
        puntos.add(new Punto(312, 191)); // 7
        puntos.add(new Punto(312, 93)); // 8
        puntos.add(new Punto(397, 96)); // 9
        puntos.add(new Punto(345, 165)); // 10
        puntos.add(new Punto(403, 190)); // 11
        puntos.add(new Punto(496, 187)); // 12
        puntos.add(new Punto(453, 195)); // 13
        puntos.add(new Punto(511, 294)); // 14
        puntos.add(new Punto(420, 235)); // 15
        puntos.add(new Punto(461, 265)); // 16
        puntos.add(new Punto(419, 256)); // 17
        puntos.add(new Punto(459, 289)); // 18
        puntos.add(new Punto(424, 294)); // 19
        puntos.add(new Punto(324, 240)); // 20
        puntos.add(new Punto(355, 227)); // 21
        puntos.add(new Punto(353, 198)); // 22
        puntos.add(new Punto(257, 203)); // 23
        puntos.add(new Punto(178, 164)); // 24
        puntos.add(new Punto(260, 238)); // 25
        puntos.add(new Punto(162, 198)); // 26
        puntos.add(new Punto(211, 195)); // 27
        puntos.add(new Punto(166, 237)); // 28
        puntos.add(new Punto(62, 164)); // 29
        puntos.add(new Punto(336, 295)); // 30
        puntos.add(new Punto(507, 408)); // 31
        puntos.add(new Punto(160, 168)); // 32
    }
    private void crearProvincias(){
        
    }


    ArrayList<Punto> puntos = new ArrayList<>();
    ArrayList<Area> provincias = new ArrayList<>();

}
