package com.una.proyecto1.model.logica.prestamo;

public class Mensualidad {

	private final int numero;
	private final double saldo;
	private final double tasa;
	private final double cuota;

	public Mensualidad(int numero, double saldo, double tasa, double cuota) {
		this.numero = numero;
		this.saldo = saldo;
		this.tasa = tasa;
		this.cuota = cuota;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @return the tasa
	 */
	public double getTasa() {
		return tasa;
	}

	/**
	 * @return the cuota
	 */
	public double getCuota() {
		return cuota;
	}

	public double getMontoInteres() {
		return getSaldo() * getTasa();
	}

	public double getMontoAmortizacion() {
		return getCuota() - getMontoInteres();
	}

	@Override
	public String toString() {
		return String.format("| %-2d | %8.2f | %7.2f | %8.2f |\n", numero, saldo, getMontoInteres(),
				getMontoAmortizacion());
	}
}
