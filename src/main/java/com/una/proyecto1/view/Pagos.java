/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.proyecto1.view;

import com.una.proyecto1.controller.ControladorPrestamo;
import com.una.proyecto1.model.logica.prestamo.Mensualidad;
import com.una.proyecto1.view.componentes.MensualidadTableModel;

import static javax.swing.JOptionPane.showMessageDialog;

import java.util.List;

/**
 *
 * @author jongu
 */
public class Pagos extends javax.swing.JFrame {

    private Integer cedula;
    private Integer numeroPrestamo;

    /**
     * Creates new form Pagos
     * 
     * @param cedula
     * @param numeroPrestamo
     */
    public Pagos(Integer cedula, Integer numeroPrestamo) {
        this.cedula = cedula;
        this.numeroPrestamo = numeroPrestamo;
        initComponents();
        init();
    }

    void init() {
        setTitle("pagos del prestamo " + (numeroPrestamo + 1) + ", cliente:" + cedula);
        recargarMensualidades();
    }

    void recargarMensualidades() {
        List<Mensualidad> mensualidades = ControladorPrestamo.getInstancia().recuperarMensualidades(cedula,
                numeroPrestamo);
        tablaMensualidad.setModel(new MensualidadTableModel(mensualidades));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarMensualidad = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMensualidad = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtMensualidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnAgregarMensualidad.setText("Agregar");
        btnAgregarMensualidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMensualidadActionPerformed(evt);
            }
        });

        tablaMensualidad.setModel(new MensualidadTableModel());
        jScrollPane1.setViewportView(tablaMensualidad);

        jLabel2.setText("Mensualidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMensualidad, javax.swing.GroupLayout.PREFERRED_SIZE, 255,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAgregarMensualidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAgregarMensualidad, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMensualidad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarMensualidadActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarMensualidadActionPerformed
        try {
            Double saldo = Double.valueOf(txtMensualidad.getText());
            if (ControladorPrestamo.getInstancia().agregarMensualidad(cedula, numeroPrestamo, saldo)) {
                recargarMensualidades();
            }
        } catch (Exception e) {
            showMessageDialog(null, "Ingrese un valor numerico correcto");
        }
    }// GEN-LAST:event_btnAgregarMensualidadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAgregarMensualidad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMensualidad;
    private javax.swing.JTextField txtMensualidad;
    // End of variables declaration//GEN-END:variables
}
