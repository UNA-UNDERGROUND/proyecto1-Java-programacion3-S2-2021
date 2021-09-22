/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.proyecto1;

import com.una.proyecto1.view.RegistroClientes;
import javax.swing.UIManager;

/**
 *
 * @author jongu
 */
public class App {

    static void mostrarUI(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroClientes().setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        mostrarUI();
    }
}
