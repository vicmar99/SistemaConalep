/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import interfaces.ComprobanteDAO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Comprobante;
import controller.ComprobanteDAOImpl;
import sistemaconalep.Dashboard;

/**
 *
 * @author Yair
 */
public class ModificarComprobante extends javax.swing.JPanel {

    String rutaArchivopdf = "";
    public static String idComprobante = "";
    public static String matriculaAlumno = "";

    /**
     * Creates new form RecibirComprobante
     */
    public ModificarComprobante() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRecibirComp = new javax.swing.JPanel();
        etiRecibirComp = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnSeleccionarArchivoComprobante = new javax.swing.JButton();
        btnAceptarRecibirComprobante = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConceptos = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnAceptarRecibirComprobante1 = new javax.swing.JButton();

        etiRecibirComp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        etiRecibirComp.setText("Modificar comprobante");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Ingrese los conceptos de pago y su monto");

        btnSeleccionarArchivoComprobante.setBackground(new java.awt.Color(0, 126, 103));
        btnSeleccionarArchivoComprobante.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSeleccionarArchivoComprobante.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarArchivoComprobante.setText("Seleccionar archivo...");
        btnSeleccionarArchivoComprobante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnSeleccionarArchivoComprobante.setBorderPainted(false);
        btnSeleccionarArchivoComprobante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionarArchivoComprobante.setFocusPainted(false);
        btnSeleccionarArchivoComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarArchivoComprobanteActionPerformed(evt);
            }
        });

        btnAceptarRecibirComprobante.setBackground(new java.awt.Color(0, 126, 103));
        btnAceptarRecibirComprobante.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAceptarRecibirComprobante.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarRecibirComprobante.setText("Aceptar");
        btnAceptarRecibirComprobante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnAceptarRecibirComprobante.setBorderPainted(false);
        btnAceptarRecibirComprobante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarRecibirComprobante.setFocusPainted(false);
        btnAceptarRecibirComprobante.setFocusable(false);
        btnAceptarRecibirComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRecibirComprobanteActionPerformed(evt);
            }
        });

        txtConceptos.setColumns(20);
        txtConceptos.setRows(5);
        jScrollPane1.setViewportView(txtConceptos);

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("**Concepto de pago $Monto**");

        btnAceptarRecibirComprobante1.setBackground(new java.awt.Color(0, 126, 103));
        btnAceptarRecibirComprobante1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAceptarRecibirComprobante1.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarRecibirComprobante1.setText("Cancelar");
        btnAceptarRecibirComprobante1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnAceptarRecibirComprobante1.setBorderPainted(false);
        btnAceptarRecibirComprobante1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarRecibirComprobante1.setFocusPainted(false);
        btnAceptarRecibirComprobante1.setFocusable(false);
        btnAceptarRecibirComprobante1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRecibirComprobante1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSeleccionarArchivoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btnAceptarRecibirComprobante)
                .addGap(18, 18, 18)
                .addComponent(btnAceptarRecibirComprobante1)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionarArchivoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarRecibirComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptarRecibirComprobante1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRecibirCompLayout = new javax.swing.GroupLayout(panelRecibirComp);
        panelRecibirComp.setLayout(panelRecibirCompLayout);
        panelRecibirCompLayout.setHorizontalGroup(
            panelRecibirCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecibirCompLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiRecibirComp)
                .addContainerGap(711, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecibirCompLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRecibirCompLayout.setVerticalGroup(
            panelRecibirCompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecibirCompLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiRecibirComp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 892, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelRecibirComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelRecibirComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarRecibirComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRecibirComprobanteActionPerformed
        String rutaArchivo = rutaArchivopdf;
        String conceptos = txtConceptos.getText();

        if (conceptos.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe agregar concepto y monto de pago",
                    "AVISO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Verifica si se seleccionó un archivo
        if (rutaArchivo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo PDF",
                    "AVISO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lee los datos binarios del archivo y los asigna al arreglo de bytes
        Path archivoPath = Paths.get(rutaArchivo);
        byte[] archivo = null;

        try {
            archivo = Files.readAllBytes(archivoPath);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

        Comprobante comprobante = new Comprobante();
        comprobante.setConceptos(conceptos);
        comprobante.setComprobante(archivo);
        comprobante.setIdComprobante(Integer.parseInt(idComprobante));

        ComprobanteDAO comprobanteDAO = new ComprobanteDAOImpl();
        try {
            comprobanteDAO.modificar(comprobante);
            JOptionPane.showMessageDialog(null, "Operación exitosa", "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);

            Comprobantes.matricula = matriculaAlumno;

            Comprobantes c = new Comprobantes();
            Dashboard.showView(c);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ModificarComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnAceptarRecibirComprobanteActionPerformed

    private void btnSeleccionarArchivoComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarArchivoComprobanteActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", "pdf");
        fileChooser.setFileFilter(filter);
        int option = fileChooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            rutaArchivopdf = fileChooser.getSelectedFile().getPath();
            //textField.setText(fileName);
            btnSeleccionarArchivoComprobante.setText(fileName);

        }
    }//GEN-LAST:event_btnSeleccionarArchivoComprobanteActionPerformed

    private void btnAceptarRecibirComprobante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRecibirComprobante1ActionPerformed
        Comprobantes.matricula = matriculaAlumno;

        Comprobantes c = new Comprobantes();
        Dashboard.showView(c);
    }//GEN-LAST:event_btnAceptarRecibirComprobante1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarRecibirComprobante;
    private javax.swing.JButton btnAceptarRecibirComprobante1;
    private javax.swing.JButton btnSeleccionarArchivoComprobante;
    private javax.swing.JLabel etiRecibirComp;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelRecibirComp;
    private javax.swing.JTextArea txtConceptos;
    // End of variables declaration//GEN-END:variables
}
