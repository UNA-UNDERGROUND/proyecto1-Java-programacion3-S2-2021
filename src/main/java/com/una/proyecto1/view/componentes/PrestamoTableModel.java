package com.una.proyecto1.view.componentes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import com.una.proyecto1.model.logica.prestamo.Prestamo;

public class PrestamoTableModel extends AbstractTableModel {

	public PrestamoTableModel() {
		this(new ArrayList<Prestamo>());
	}

	public PrestamoTableModel(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
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
		return prestamos.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Prestamo p = prestamos.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return String.format("%d", rowIndex + 1);
			case 1:
				return String.format("%.2f", p.getMonto());
			case 2:
				return String.format("%%%.0f", p.getTasa() * 100);
			case 3:
				return String.format("%d", p.getPlazo());
			case 4:
				Double cuota = p.getCuota();
				return String.format("%.2f", cuota);
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

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	private List<Prestamo> prestamos;
	private LinkedList<TableModelListener> suscriptores = new LinkedList<>();
	private final static String[] COLUMNAS = { "Numero", "Monto", "Tasa", "Plazo", "Cuota" };
}