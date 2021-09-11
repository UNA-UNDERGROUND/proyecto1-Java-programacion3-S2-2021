/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.proyecto1.view;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JLabel;

import com.una.proyecto1.model.geometria.Punto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 *
 * @author jongu
 */
public class Mapa extends javax.swing.JFrame {

	public Mapa() {
		InitComponents();
		init();
		mapaProvincias = new com.una.proyecto1.model.Mapa();
	}

	void InitComponents() {
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		mapa = new JLabel();
		mapa.setVerticalAlignment(JLabel.TOP);
		Dimension dim = new Dimension(600, 440);
		mapa.setSize(dim);

		add(mapa);
		setResizable(false);
		setPreferredSize(dim);
		pack();
	}

	void init() {
		try {

			setTitle("Clientes");

			String ruta = "/mapa/0.png";
			// Image imagenMapa = new ImageIcon();

			ImageIcon iconLogo = new ImageIcon(RAIZ + ruta);
			mapa.setIcon(iconLogo);

			// eventos
			addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseMoved(MouseEvent me) {
					onMouseMoved(me);
				}

			});
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	void onMouseMoved(MouseEvent me) {
		Integer provincia = mapaProvincias.colisiona(new Punto(me.getX(), me.getY()));
		ImageIcon pronvincia = new ImageIcon(RAIZ + "/mapa/" + provincia + ".png");
		mapa.setIcon(pronvincia);
	}

	void onMouseClick(MouseEvent me) {
		mapab = !mapab;
		String ruta = "";
		if (mapab) {
			ruta = "C:\\Users\\jongu\\source\\paula\\proyecto1-Java-programacion3-S2-2021\\assets\\provincias\\areas.png";
		} else {
			ruta = "C:\\Users\\jongu\\source\\paula\\proyecto1-Java-programacion3-S2-2021\\assets\\provincias\\00-CostaRica.png";
		}
		ImageIcon iconLogo = new ImageIcon(ruta);
		mapa.setIcon(iconLogo);
	}

	JLabel mapa;
	com.una.proyecto1.model.Mapa mapaProvincias;
	int conteo = 0;
	boolean mapab = true;

	static final String RAIZ = "C:/Users/jongu/source/paula/proyecto1-Java-programacion3-S2-2021/src/main/resources";
}
