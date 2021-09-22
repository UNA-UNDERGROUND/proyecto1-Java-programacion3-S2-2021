package com.una.proyecto1.model.logica.prestamo;

import java.util.ArrayList;
import java.util.List;

public class Prestamo {

	List<Mensualidad> mensualidades = new ArrayList<>();

	double monto;
	int plazo;
	double tasa;

	public Prestamo(double monto, int plazo, double tasa) {
		this.monto = monto;
		this.plazo = plazo;
		this.tasa = tasa;
	}

	public double getMonto() {
		return monto;
	}

	public int getPlazo() {
		return plazo;
	}

	public double getTasa() {
		return tasa;
	}

	public double getCuota() {
		return (monto * tasa) / (1 - Math.pow(1 + tasa, -plazo));
	}

	public List<Mensualidad> getMensualidades() {
		return mensualidades;
	}

	public void setMensualidades(List<Mensualidad> mensualidades) {
		if (mensualidades == null) {
			throw new NullPointerException("Prestamo::setMensualidades() -> mensualidades = null");
		}
		this.mensualidades = mensualidades;
	}

	void agregarMensualidad(Mensualidad mensualidad) {
		if (mensualidad == null) {
			throw new NullPointerException("Prestamo::agregarMensualidad() -> mensualidad = null");
		}
		mensualidades.add(mensualidad);
	}

	public void agregarMensualidad(double saldo) {
		agregarMensualidad(new Mensualidad(mensualidades.size() + 1, saldo, tasa, getCuota()));
	}

	@Override
	public String toString() {
		String prestamo = String.format(
			"Monto: %.0f  Tasa: %.0f  Plazo: %d  Cuota: %.0f",
			getMonto(),
			getTasa() * 100,
			getPlazo(), 
			getCuota());
		return prestamo;
	}

}