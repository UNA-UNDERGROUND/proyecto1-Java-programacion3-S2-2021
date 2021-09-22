package com.una.proyecto1.view.componentes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import com.una.proyecto1.model.logica.prestamo.Mensualidad;

class MensualidadTableModel extends AbstractTableModel {

	public MensualidadTableModel() {
		this(new ArrayList<Mensualidad>());
	}

	public MensualidadTableModel(List<Mensualidad> mensualidades) {
		this.mensualidades = mensualidades;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		suscriptores.add(l);
	}

	@Override
	public Class<?> getColumnClass(int columIndex) {
		return Integer.class;
	}

	@Override
	public int getColumnCount() {
		return COLUMNAS.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return COLUMNAS[columnIndex];
	}

	@Override
	public int getRowCount() {
		return mensualidades.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Mensualidad m = mensualidades.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return String.format("%-2d", m.getNumero());
			case 1:
				return String.format("%8.0f", m.getSaldo());
			case 2:
				return String.format("%7.0f", m.getMontoInteres());
			case 3:
				return String.format("%8.0f", m.getMontoAmortizacion());
			default:
				return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		suscriptores.remove(l);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// ningun campo se puede editar
	}

	private List<Mensualidad> mensualidades;
	private LinkedList<TableModelListener> suscriptores = new LinkedList<>();
	private final static String[] COLUMNAS = { "Mensualidad", "Saldo", "Interés", "Amortizacion" };
}