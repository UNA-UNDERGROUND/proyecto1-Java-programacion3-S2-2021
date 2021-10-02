/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.proyecto1.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JOptionPane;

import com.una.proyecto1.controller.ControladorPrestamo;
import com.una.proyecto1.model.logica.Cliente;
import com.una.proyecto1.model.logica.ubicacion.Canton;
import com.una.proyecto1.model.logica.ubicacion.Distrito;
import com.una.proyecto1.model.util.Listener;
import com.una.proyecto1.view.componentes.ItemComboBox;

import static javax.swing.JOptionPane.showMessageDialog;

public class RegistroClientes extends javax.swing.JFrame implements Listener {

    /**
     * Creates new form RegistroClientes
     */
    public RegistroClientes() {
        initComponents();
        init();

    }

    private void init() {
        panelMapaInterno = new Mapa();
        panelMapa.setLayout(new BorderLayout());
        panelMapa.add(panelMapaInterno, BorderLayout.NORTH);
        ControladorPrestamo.getInstancia().setProvinciaListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        comboCanton = new javax.swing.JComboBox<>();
        comboDistrito = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPrestamos = new javax.swing.JButton();
        panelMapa = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        menuBarApp = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        itemReporteCliente = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Cedula");

        jLabel2.setText("Nombre");

        btnBuscar.setText("buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCliente(evt);
            }
        });

        jLabel4.setText("Provincia");

        txtProvincia.setEditable(false);

        comboCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCantonActionPerformed(evt);
            }
        });

        jLabel3.setText("Canton");

        jLabel5.setText("Distrito");

        btnPrestamos.setText("Prestamos");
        btnPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPrestamos(evt);
            }
        });

        javax.swing.GroupLayout panelMapaLayout = new javax.swing.GroupLayout(panelMapa);
        panelMapa.setLayout(panelMapaLayout);
        panelMapaLayout.setHorizontalGroup(
            panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panelMapaLayout.setVerticalGroup(
            panelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );

        btnGuardar.setText("Guardar");
        btnGuardar.setActionCommand("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar(evt);
            }
        });

        jMenu3.setText("Archivo");

        jMenu1.setText("Reportes");

        itemReporteCliente.setText("clientes");
        jMenu1.add(itemReporteCliente);

        jMenu3.add(jMenu1);

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });
        jMenu3.add(menuItemSalir);

        menuBarApp.add(jMenu3);

        setJMenuBar(menuBarApp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCanton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnGuardar))
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(17, 17, 17)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(btnBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCantonActionPerformed
        if(comboCanton.getSelectedItem() != null){
            actualizarDistritos();
        }
    }//GEN-LAST:event_comboCantonActionPerformed


    @SuppressWarnings("unchecked")
    private void actualizarDistritos(){
        comboDistrito.removeAllItems();
        Integer idProvincia = ControladorPrestamo.getInstancia().getCodigoProvincia();
        Integer idCanton = ((ItemComboBox<Canton>)comboCanton.getSelectedItem()).getValor().getId();
        List<Distrito> distritos = ControladorPrestamo.getInstancia().getDistritos(idProvincia, idCanton);
        for (Distrito distrito : distritos) {
            comboDistrito.addItem(new ItemComboBox<Distrito>(distrito));
        }
    }

    private void actualizarCantones(){
        comboCanton.removeAllItems();
        List<Canton> cantones = ControladorPrestamo.getInstancia().getCantones(ControladorPrestamo.getInstancia().getCodigoProvincia());
        for (Canton canton : cantones) {
            comboCanton.addItem(new ItemComboBox<Canton>(canton));
        }
        actualizarDistritos();
    }

    private void guardar(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_guardar
        boolean exitoso = true;
        String mensaje = "";
        try {
            Integer cedula = Integer.parseInt(txtCedula.getText());
            String nombre = txtNombre.getText();
            String provincia = txtProvincia.getText();
            String canton;
            String distrito;

            if (comboCanton.getSelectedIndex() == -1) {
                throw new RuntimeException("El Canton no es valido");
            }
            if (comboDistrito.getSelectedIndex() == -1) {
                throw new RuntimeException("El Distrito no es valido");
            }
            canton = comboCanton.getSelectedItem().toString();
            distrito = comboDistrito.getSelectedItem().toString();

            exitoso = ControladorPrestamo.getInstancia().agregarCliente(cedula, nombre, provincia, canton, distrito);
            if(!exitoso){
                mensaje= "Ya existe el cliente"; 
            }
        } catch (NumberFormatException ex) {
            exitoso = false;
            mensaje = "El ID debe ser un numero valido";
        } catch (Exception ex) {
            exitoso = false;
            mensaje = ex.getLocalizedMessage();
        }
        if (!exitoso) {
            JOptionPane.showMessageDialog(this, mensaje, "Error al agregar Cliente", JOptionPane.ERROR_MESSAGE);
        }

    }// GEN-LAST:event_guardar

    private void salir(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_salir
        dispose();
    }// GEN-LAST:event_salir

    private void buscarCliente(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buscarCliente
                try {
                        Integer id = Integer.parseInt(txtCedula.getText());
                        Cliente c = ControladorPrestamo.getInstancia().recuperarCliente(id);
                        if (c != null) {
                                txtCedula.setText(Integer.valueOf(c.getId()).toString());
                                txtNombre.setText(c.getNombre());
                                txtProvincia.setText(c.getProvincia());
                                comboCanton.setSelectedItem(c.getCanton());
                                comboDistrito.setSelectedItem(c.getDistrito());
                        } else {
                                throw new RuntimeException("No se encontro el cliente");
                        }
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "la cedula debe ser un numero entero", "Error de formato",
                                        JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this,ex.getLocalizedMessage(), "Error de formato", 
                                        JOptionPane.ERROR_MESSAGE);
                }
        }
    // GEN-LAST:event_buscarCliente

    private void mostrarPrestamos(java.awt.event.ActionEvent evt) { // GEN-FIRST:event_buscarCliente
        try {
            new PrestamoClientes(Integer.parseInt(txtCedula.getText())).setVisible(true);
        } catch (Exception e) {
            showMessageDialog(null, "Ingrese una cedula valida");
        }

    }// GEN-LAST:event_mostrarPrestamos

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPrestamos;
    private javax.swing.JComboBox<ItemComboBox<Canton>> comboCanton;
    private javax.swing.JComboBox<ItemComboBox<Distrito>> comboDistrito;
    private javax.swing.JMenuItem itemReporteCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar menuBarApp;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JPanel panelMapa;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProvincia;
    // End of variables declaration//GEN-END:variables

    private Mapa panelMapaInterno;

    @Override
    public void notificar() {
        txtProvincia.setText(ControladorPrestamo.getInstancia().getProvinciaActual());
        actualizarCantones();
    }
}
