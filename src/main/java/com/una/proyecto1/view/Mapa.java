/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.proyecto1.view;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLabel;
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

			String ruta = "C:\\Users\\jongu\\source\\paula\\proyecto1-Java-programacion3-S2-2021\\assets\\provincias\\areas.png";
			ImageIcon iconLogo = new ImageIcon(ruta);
			mapa.setIcon(iconLogo);

			// eventos
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent me) {
					onMouseClick(me);
				}
			});

		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	void onMouseClick(MouseEvent me) {
		conteo++;
		System.out.println("puntos.add(new Point(" + me.getX() + ", " + me.getY() + ")); //" + conteo);
	}

	JLabel mapa;
	int conteo = 0;
}
