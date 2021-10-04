package com.una.proyecto1.model.logica.prestamo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prestamo {

	private List<Mensualidad> mensualidades = new ArrayList<>();
	private Integer idCliente;
	private double monto;
	private int plazo;
	private double tasa;

	public Prestamo(Integer idCliente, double monto, int plazo, double tasa) {
		this.idCliente = idCliente;
		this.monto = monto;
		this.plazo = plazo;
		this.tasa = tasa;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
		Double cuotaInicial = (monto * tasa) / plazo;
		for (Mensualidad mensualidad : mensualidades) {
			if (mensualidad.getCuota() > cuotaInicial) {
				// hay que recalcular la cuota
				Double sumaCuotas = 0.0;
				for (Mensualidad mensualidad2 : mensualidades) {
					sumaCuotas += mensualidad2.getCuota();
				}
				Double remanente = (monto * tasa) - sumaCuotas;
				Integer plazoRestante = plazo - mensualidades.size();
				return remanente / (1 - Math.pow(1 + tasa, -plazoRestante));
			}
		}
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

	public void agregarMensualidad(double saldo, Date fecha) {
		Mensualidad mensualidad = new Mensualidad(idCliente, mensualidades.size() + 1, saldo, tasa, getCuota(), fecha);
		agregarMensualidad(mensualidad);
	}

	@Override
	public String toString() {
		String prestamo = String.format("Monto: %.0f  Tasa: %.0f  Plazo: %d  Cuota: %.0f", getMonto(), getTasa() * 100,
				getPlazo(), getCuota());
		return prestamo;
	}

}
