package com.una.proyecto1.model.mapa.geometria;

import java.util.List;

public interface Forma {

    boolean colisiona(Punto p);
    List<Punto> getPuntos();
    
}
