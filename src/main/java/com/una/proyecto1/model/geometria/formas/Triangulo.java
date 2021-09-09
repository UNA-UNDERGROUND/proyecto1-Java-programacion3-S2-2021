package com.una.proyecto1.model.geometria.formas;

// colision basada en: https://stackoverflow.com/questions/2049582/how-to-determine-if-a-point-is-in-a-2d-triangle

import java.util.ArrayList;
import java.util.List;

import com.una.proyecto1.model.geometria.Forma;
import com.una.proyecto1.model.geometria.Punto;

public class Triangulo implements Forma {

	public Triangulo(Punto p1, Punto p2, Punto p3) {
		puntos = new ArrayList<>();
		puntos.add(p1);
		puntos.add(p2);
		puntos.add(p3);
	}

	@Override
	public boolean colisiona(Punto p) {
		float d1, d2, d3;
		boolean has_neg, has_pos;

		d1 = signo(p, puntos.get(0), puntos.get(1));
		d2 = signo(p, puntos.get(1), puntos.get(2));
		d3 = signo(p, puntos.get(2), puntos.get(0));

		has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
		has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

		return !(has_neg && has_pos);
	}

	@Override
	public List<Punto> getPuntos() {
		return puntos;
	}

	private float signo(Punto p1, Punto p2, Punto p3) {
		return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
	}

	ArrayList<Punto> puntos;

}
