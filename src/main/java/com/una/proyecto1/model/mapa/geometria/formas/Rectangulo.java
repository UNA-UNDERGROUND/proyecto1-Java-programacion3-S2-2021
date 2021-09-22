package com.una.proyecto1.model.mapa.geometria.formas;

import java.util.ArrayList;
import java.util.List;

import com.una.proyecto1.model.mapa.geometria.Forma;
import com.una.proyecto1.model.mapa.geometria.Punto;

public class Rectangulo implements Forma {
	public Rectangulo(Punto superior, Punto inferior){
		this.superior = superior;
		this.inferior = inferior;
	}

	@Override
	public boolean colisiona(Punto p) {
		return (p.getX() >= superior.getX() &&
			p.getY() >= superior.getY() &&
			p.getX() <= inferior.getX() && 
			p.getY() <= inferior.getY());
	}

	@Override
	public List<Punto> getPuntos() {
		ArrayList<Punto> puntos = new ArrayList<>();
		puntos.add(superior);
		puntos.add(inferior);
		return puntos;
	}

	protected Punto superior;
	protected Punto inferior;
}
