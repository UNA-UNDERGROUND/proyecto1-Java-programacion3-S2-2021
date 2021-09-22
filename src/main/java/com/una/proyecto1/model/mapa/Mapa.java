package com.una.proyecto1.model.mapa;

import java.util.ArrayList;

import com.una.proyecto1.model.mapa.geometria.Area;
import com.una.proyecto1.model.mapa.geometria.Punto;
import com.una.proyecto1.model.mapa.geometria.formas.Rectangulo;
import com.una.proyecto1.model.mapa.geometria.formas.Triangulo;

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
		puntos.add(new Punto()); // punto nulo, para no contar en 0
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
		puntos.add(new Punto(454, 238)); // 33
	}

	private void crearProvincias() {
		Area sanJose = new Area();
		Area alajuela = new Area();
		Area cartago = new Area();
		Area heredia = new Area();
		Area guanacaste = new Area();
		Area puntarenas = new Area();
		Area limon = new Area();

		sanJose.add(new Rectangulo(puntos.get(23), puntos.get(21)));
		sanJose.add(new Triangulo(puntos.get(7), puntos.get(10), puntos.get(22)));
		sanJose.add(new Triangulo(puntos.get(20), puntos.get(15), puntos.get(19)));

		alajuela.add(new Rectangulo(puntos.get(6), puntos.get(7)));
		alajuela.add(new Triangulo(puntos.get(5), puntos.get(6), puntos.get(4)));

		cartago.add(new Rectangulo(puntos.get(22), puntos.get(33)));
		cartago.add(new Triangulo(puntos.get(10), puntos.get(11), puntos.get(22)));

		heredia.add(new Triangulo(puntos.get(7), puntos.get(8), puntos.get(9)));

		guanacaste.add(new Triangulo(puntos.get(2), puntos.get(3), puntos.get(4)));
		guanacaste.add(new Triangulo(puntos.get(29), puntos.get(28), puntos.get(32)));
		guanacaste.add(new Rectangulo(puntos.get(1), puntos.get(3)));

		puntarenas.add(new Triangulo(puntos.get(26), puntos.get(27), puntos.get(28)));
		puntarenas.add(new Triangulo(puntos.get(24), puntos.get(4), puntos.get(25)));
		puntarenas.add(new Triangulo(puntos.get(25), puntos.get(20), puntos.get(30)));
		puntarenas.add(new Triangulo(puntos.get(20), puntos.get(30), puntos.get(19)));
		puntarenas.add(new Triangulo(puntos.get(30), puntos.get(14), puntos.get(31)));
		puntarenas.add(new Rectangulo(puntos.get(17), puntos.get(18)));

		limon.add(new Triangulo(puntos.get(9), puntos.get(10), puntos.get(11)));
		limon.add(new Triangulo(puntos.get(9), puntos.get(11), puntos.get(12)));
		limon.add(new Rectangulo(puntos.get(13), puntos.get(14)));
		limon.add(new Rectangulo(puntos.get(15), puntos.get(16)));

		provincias.add(sanJose);
		provincias.add(alajuela);
		provincias.add(cartago);
		provincias.add(heredia);
		provincias.add(guanacaste);
		provincias.add(puntarenas);
		provincias.add(limon);
	}

	public int colisiona(Punto p) {
		for (int i = 0; i < 7; i++) {
			if (provincias.get(i).colisiona(p)) {
				return i + 1;
			}
		}
		return 0;
	}

	ArrayList<Punto> puntos = new ArrayList<>();
	ArrayList<Area> provincias = new ArrayList<>();

}
