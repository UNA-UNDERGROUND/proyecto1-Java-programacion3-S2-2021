package com.una.proyecto1.model.logica.prestamo;

import java.util.Date;

public class Mensualidad {
  
	private Integer idCliente; 
	private final int numero;
	private final double saldo;
	private final double tasa;
	private final double cuota;
	private final Date fecha;

	public Mensualidad(Integer idCliente, int numero, double saldo, double tasa, double cuota, Date fecha) {
		this.idCliente = idCliente;
		this.numero = numero;
		this.saldo = saldo;
		this.tasa = tasa;
		this.cuota = cuota;
		this.fecha = fecha;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public Date getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		return String.format("| %-2d | %8.2f | %7.2f | %8.2f |\n", numero, saldo, getMontoInteres(),
				getMontoAmortizacion());
	}
}
