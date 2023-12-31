/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.table.DefaultTableModel;
import model.Comprobante;
import controller.ComprobanteDAOImpl;

/**
 *
 * @author Yair
 */
public class VentanaAcercaDe extends javax.swing.JFrame {

    /**
     * Creates new form ventanaComprobantes
     */
    public VentanaAcercaDe() {
        initComponents();
        this.setTitle("A cerca de");
        // Agrega el JTextArea formateado
        JTextArea jTextArea1 = new JTextArea();
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setFont(new Font("Arial", Font.BOLD, 12));

        String texto = "Derechos de Propiedad\n\n"
                + "El presente software de Residencia Profesional ha sido desarrollado por Yair Victoriano Marcelino "
                + "y Misraim Diaz Lopez y está protegido por los derechos de propiedad intelectual correspondientes. "
                + "A continuación, se detallan los términos y condiciones para el uso de este software por parte de la "
                + "institución Conalep 139, de acuerdo con las leyes del estado de Guerrero.\n\n"
                + "Propiedad intelectual:\n"
                + "Todos los derechos de propiedad intelectual, incluyendo los derechos de autor y patentes, "
                + "relacionados con el software, pertenecen a Yair Victoriano Marcelino y a Misraim Diaz Lopez.\n\n"
                + "Licencia de uso:\n"
                + "Se otorga una licencia no exclusiva y no transferible para utilizar el software a la institución "
                + "Conalep 139, con la condición de que no se lucre con dicho software.\n\n"
                + "Restricciones de uso:\n"
                + "La institución Conalep 139 no está autorizada a copiar, distribuir o sublicenciar el software sin "
                + "el consentimiento expreso de Yair Victoriano Marcelino Y Misraim Diaz Lopez. El software solo puede "
                + "ser utilizado por la institución para fines educativos y no comerciales.\n\n"
                + "Compartir con otras Instituciones:\n"
                + "Conalep 139 tiene permitido compartir el software con otras instituciones públicas, con el propósito "
                + "de facilitar su uso en proyectos similares. Sin embargo, cualquier uso adicional estará sujeto a las "
                + "mismas restricciones y condiciones establecidas en este apartado.\n\n"
                + "Propiedad de los datos:\n"
                + "Los datos generados o procesados por el software serán propiedad exclusiva de la institución Conalep "
                + "139, de acuerdo con las leyes de protección de datos vigentes en el estado de Guerrero.\n\n"
                + "Responsabilidad:\n"
                + "Yair Victoriano Marcelino Y Misraim Diaz Lopez no se hacen responsables de ningún daño o pérdida que "
                + "pueda surgir del uso del software por parte de la institución Conalep 139. La institución utilizará "
                + "el software bajo su propio riesgo, en cumplimiento con las leyes aplicables en el estado de Guerrero.\n\n"
                + "La presente licencia de uso del software podrá ser terminada por cualquiera de las partes en "
                + "cualquier momento. Al finalizar la licencia, la institución Conalep 139 deberá dejar de utilizar "
                + "el software y destruir todas las copias del mismo, de acuerdo con las disposiciones legales "
                + "pertinentes en el estado de Guerrero.";

        jTextArea1.setText(texto);

        int marginPixels = 40;
        float scale = Toolkit.getDefaultToolkit().getScreenResolution() / 72f;
        int marginPoints = (int) (marginPixels * scale);

        jTextArea1.setMargin(new Insets(marginPoints, marginPoints, marginPoints, marginPoints));

        JScrollPane jScrollPane1 = new JScrollPane(jTextArea1);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 250));

        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(jScrollPane1, BorderLayout.CENTER);

      

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jButton1)
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(464, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAcercaDe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
