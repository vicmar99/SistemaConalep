/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import interfaces.ComprobanteDAO;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import model.Comprobante;
import sistemaconalep.ComprobanteDAOImpl;

/**
 *
 * @author Yair
 */
public class Comprobantes extends javax.swing.JPanel {

    public static String matricula = "";

    /**
     * Creates new form Comprobantes
     */
    public Comprobantes() {
        initComponents();
        etiAlumno.setText("Matrícula del alumno: " + matricula);
        llenarTabla();
    }

    //Llenar la tabla 
    private void llenarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            List<Comprobante> comprobantes = new ComprobanteDAOImpl().listar(matricula);

            String[] columnas = {"ID", "Periodo", "Recibió", "Departamento", "Fecha", "Concepto y cantidad"};
            modelo.setColumnIdentifiers(columnas);

            for (Comprobante comprobante : comprobantes) {
                String[] renglon = {String.valueOf(comprobante.getIdComprobante()), comprobante.getIdPeriodo(),
                    comprobante.getUsuarioRecibe(), comprobante.getDepartamentoRecibe(), comprobante.getFechaRecibido(), comprobante.getConceptos(),};
                modelo.addRow(renglon);
            }
            tablaComprobantes.setModel(modelo);

            // Ajustar la ultima columna al tamaño del contenido
            
                packColumn(tablaComprobantes, 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Método para ajustar las columnas de la tabla
    private void packColumn(JTable table, int column) {
        int maxWidth = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(cellRenderer, row, column);
            maxWidth = Math.max(comp.getPreferredSize().width, maxWidth);
        }
        table.getColumnModel().getColumn(column).setPreferredWidth(maxWidth);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComprobantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        etiAlumno = new javax.swing.JLabel();
        btnVerComprobante = new javax.swing.JButton();

        tablaComprobantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaComprobantes);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Historial de comporbantes entregados");

        etiAlumno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        etiAlumno.setText("Matrícula");

        btnVerComprobante.setBackground(new java.awt.Color(0, 126, 103));
        btnVerComprobante.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnVerComprobante.setForeground(new java.awt.Color(255, 255, 255));
        btnVerComprobante.setText("Descargar");
        btnVerComprobante.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnVerComprobante.setBorderPainted(false);
        btnVerComprobante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerComprobante.setFocusPainted(false);
        btnVerComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerComprobanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnVerComprobante)
                            .addComponent(etiAlumno))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etiAlumno)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnVerComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerComprobanteActionPerformed
        int fila = tablaComprobantes.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar por lo menos una fila para realizar la operación",
                    "AVISO", JOptionPane.ERROR_MESSAGE);
            return;

        }

        int idComprobante = Integer.parseInt(tablaComprobantes.getValueAt(fila, 0).toString());

        ComprobanteDAO comprobanteDAO = new ComprobanteDAOImpl();
        comprobanteDAO.visualizarPdf(idComprobante);
    }//GEN-LAST:event_btnVerComprobanteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerComprobante;
    public static javax.swing.JLabel etiAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaComprobantes;
    // End of variables declaration//GEN-END:variables
}