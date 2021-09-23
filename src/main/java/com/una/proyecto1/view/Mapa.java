/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.proyecto1.view;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JLabel;

import com.una.proyecto1.controller.ControladorPrestamo;
import com.una.proyecto1.model.mapa.geometria.Punto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public final class Mapa extends javax.swing.JPanel {

	public Mapa() {
		InitComponents();
		init();
	}

	void InitComponents() {
		mapa = new JLabel();
		mapa.setVerticalAlignment(JLabel.TOP);
		Dimension dim = new Dimension(600, 440);
		mapa.setSize(dim);

		add(mapa);
		setPreferredSize(dim);
	}

	void init() {
		try {

			String ruta = "mapa/0.png";
			ImageIcon iconLogo = new ImageIcon(ClassLoader.getSystemResource(ruta));
			mapa.setIcon(iconLogo);

			// eventos
			addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseMoved(MouseEvent me) {
					onMouseMoved(me);
				}
			});
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent me) {
					onMouseClick(me);
				}
			}

			);
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	void actualizarMapa(int numProvincia) {
		String ruta = "mapa/" + numProvincia + ".png";
		ImageIcon provincia = new ImageIcon(ClassLoader.getSystemResource(ruta));
		mapa.setIcon(provincia);
	}

	void onMouseMoved(MouseEvent me) {
		if (ControladorPrestamo.getInstancia().getCodigoProvincia() == 0) {
			Integer numProvincia = ControladorPrestamo.getInstancia().getMapa()
					.colisiona(new Punto(me.getX(), me.getY()));
			actualizarMapa(numProvincia);
		}
	}

	void onMouseClick(MouseEvent me) {
		int numProvincia = ControladorPrestamo.getInstancia().getMapa().colisiona(new Punto(me.getX(), me.getY()));
		if (numProvincia != 0) {
			ControladorPrestamo.getInstancia().setCodigoProvincia(numProvincia);
			actualizarMapa(numProvincia);
		}

	}

	JLabel mapa;
}
