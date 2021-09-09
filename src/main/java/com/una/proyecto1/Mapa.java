/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.proyecto1;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.awt.Color;

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

		Border border = BorderFactory.createLineBorder(Color.ORANGE);
		mapa.setBorder(border);

		add(mapa);
		setPreferredSize(dim);
		pack();
	}

	void init() {
		try {

			setTitle("Clientes");

			String ruta = "C:\\Users\\jongu\\source\\paula\\proyecto1-Java-programacion3-S2-2021\\assets\\provincias\\areas.png";
			ImageIcon iconLogo = new ImageIcon(ruta);
			mapa.setIcon(iconLogo);
			System.out.println(mapa.getSize());

		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	JLabel mapa;
}
