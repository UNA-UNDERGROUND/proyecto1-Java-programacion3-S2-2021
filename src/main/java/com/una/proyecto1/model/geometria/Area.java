package com.una.proyecto1.model.geometria;

import java.util.ArrayList;
import java.util.List;

import com.una.proyecto1.model.geometria.formas.Rectangulo;

public class Area extends Rectangulo{
	public Area() {
		super(null, null);
		formas = new ArrayList<>();
	}

	public void add(Forma f) {
		formas.add(f);
		for (Punto p : f.getPuntos()) {
			if (superior == null) {
				superior = new Punto(p);
				superior = new Punto(p);
			} else {
				if (superior.getX() > p.getX()) {
					superior.setX(p.getX());
				}
				if (superior.getY() > p.getY()) {
					superior.setY(p.getY());
				}
				if (inferior.getX() < p.getX()) {
					inferior.setX(p.getX());
				}
				if (inferior.getY() < p.getY()) {
					inferior.setY(p.getY());
				}
			}

		}
	}

	@Override
	public boolean colisiona(Punto p) {
		if(super.colisiona(p)){
			for (Forma f : formas) {
				if (f.colisiona(p)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<Punto> getPuntos() {
		ArrayList<Punto> res = new ArrayList<>();
		for (Forma f : formas) {
			res.addAll(f.getPuntos());
		}
		return res;
	}

	ArrayList<Forma> formas;

}
