/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaconalep;


import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;
import vistas.Alumnos;
import vistas.PeriodoEscolar;
import vistas.Principal;
import vistas.RecibirComprobante;
import vistas.Reportes;
import vistas.Usuarios;
import vistas.VentanaAcercaDe;

/**
 *
 * @author Yair
 */
public class Dashboard extends javax.swing.JFrame {
    
    private static String nombreUsuario;


    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        setDate();
        setTitle("Sistema de Gestión de Comprobantes de Pago");
        Principal p = new Principal();
        
        showView(p);
        
    }
    
    public static void setNombreUsuario (String nombre){
        nombreUsuario = nombre;
    }
    
    public static String getNombreUsuario(){
        return nombreUsuario;
    }

    public static void showView(JPanel newView) {
        newView.setSize(892, 560);
        newView.setLocation(0, 0);

        content.removeAll();
        content.add(newView, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        labelDate.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es ' EEEE dd 'de' MMMM 'de' yyyy ", spanishLocale)));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnPeriodo = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        labelDate = new javax.swing.JLabel();
        labelDepartamento = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 600));

        menu.setBackground(new java.awt.Color(7, 92, 77));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SGCP");
        menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 188, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 104, 158, 10));

        btnPeriodo.setBackground(new java.awt.Color(0, 126, 103));
        btnPeriodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        btnPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/1976057_config_configuration_settings_icon.png"))); // NOI18N
        btnPeriodo.setText("Periodo");
        btnPeriodo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnPeriodo.setBorderPainted(false);
        btnPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPeriodo.setFocusPainted(false);
        btnPeriodo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPeriodo.setIconTextGap(15);
        btnPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodoActionPerformed(evt);
            }
        });
        menu.add(btnPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 188, 50));

        btnInicio.setBackground(new java.awt.Color(0, 126, 103));
        btnInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/3844470_home_house_icon.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnInicio.setBorderPainted(false);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setFocusPainted(false);
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setIconTextGap(15);
        btnInicio.setMargin(new java.awt.Insets(2, 20, 2, 14));
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        menu.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 132, 188, 50));

        jButton4.setBackground(new java.awt.Color(0, 126, 103));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/viewreportsicon.png"))); // NOI18N
        jButton4.setText("Reportes");
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        jButton4.setBorderPainted(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setIconTextGap(15);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        menu.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 188, 50));

        jButton5.setBackground(new java.awt.Color(0, 126, 103));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ticketicon.png"))); // NOI18N
        jButton5.setText("Recibir comprobante");
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        jButton5.setBorderPainted(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setIconTextGap(15);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        menu.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 188, 50));

        btnAlumnos.setBackground(new java.awt.Color(0, 126, 103));
        btnAlumnos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/9025060_student_light_icon.png"))); // NOI18N
        btnAlumnos.setText("Alumnos");
        btnAlumnos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnAlumnos.setBorderPainted(false);
        btnAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlumnos.setFocusPainted(false);
        btnAlumnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAlumnos.setIconTextGap(15);
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });
        menu.add(btnAlumnos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 188, 50));

        btnUsuarios.setBackground(new java.awt.Color(0, 126, 103));
        btnUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/4280504_account_group_outlined_family_people_icon.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setFocusPainted(false);
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsuarios.setIconTextGap(15);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        menu.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 188, 50));

        jLabel34.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/9111104_alert_circle_icon.png"))); // NOI18N
        jLabel34.setText("A cerca de...");
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jLabel34.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel34KeyPressed(evt);
            }
        });
        menu.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 140, -1));

        header.setBackground(new java.awt.Color(0, 126, 103));

        labelDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDate.setForeground(new java.awt.Color(255, 255, 255));
        labelDate.setText("Hoy es diasemana dia mes anio");

        labelDepartamento.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        labelDepartamento.setForeground(new java.awt.Color(255, 255, 255));
        labelDepartamento.setText("Departamento");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(labelDate)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDate)
                    .addComponent(labelDepartamento))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        content.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        Principal p = new Principal();
        showView(p);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Reportes r = new Reportes();
        showView(r);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        RecibirComprobante rc = new RecibirComprobante();
        showView(rc);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        Alumnos a = new Alumnos();
        showView(a);
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        Usuarios u = new Usuarios();
        showView(u);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodoActionPerformed
        PeriodoEscolar pe = new PeriodoEscolar();
        showView(pe);
    }//GEN-LAST:event_btnPeriodoActionPerformed

    private void jLabel34KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel34KeyPressed

    }//GEN-LAST:event_jLabel34KeyPressed

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        VentanaAcercaDe vad = new VentanaAcercaDe();
        vad.setVisible(true);
    }//GEN-LAST:event_jLabel34MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //FlatMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnInicio;
    public static javax.swing.JButton btnPeriodo;
    public static javax.swing.JButton btnUsuarios;
    public static javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDate;
    public static javax.swing.JLabel labelDepartamento;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
