package com.una.proyecto1.model.mapa.geometria;

public class Punto {
    private int x;
    private int y;

    public Punto() {
        this(-1, -1);
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Punto(Punto p) {
        this(p.x, p.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
