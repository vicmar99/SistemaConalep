/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import interfaces.AlumnoPeriodoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AlumnoPeriodo;
import model.Grupo;
import model.Periodo;
import model.Semestre;
import sistemaconalep.AlumnoPeriodoDAOImpl;
import sistemaconalep.Dashboard;
import sistemaconalep.GrupoDAOImpl;
import sistemaconalep.PeriodoDAOImpl;
import sistemaconalep.SemestreDAOImpl;
import static vistas.PeriodoEscolar.boxSelectPeriodoEscolar;

/**
 *
 * @author Yair
 */
public class Reportes extends javax.swing.JPanel {

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        llenarcomboBox();
        llenarTablaReportes();

    }

    //  Metodo para llenar todos los JComboBox
    private void llenarcomboBox() {
        try {
            //Llenar el box periodo
            DefaultComboBoxModel modeloPeriodo = new DefaultComboBoxModel();
            List<Periodo> periodos = new PeriodoDAOImpl().listar();

            for (Periodo periodo : periodos) {
                modeloPeriodo.addElement(periodo.getIdPeriodo());
            }
            boxReportesPeriodo.setModel(modeloPeriodo);

            //Llenar el box semestre
            DefaultComboBoxModel modeloSemestre = new DefaultComboBoxModel();
            List<Semestre> semestres = new SemestreDAOImpl().listar();

            for (Semestre semestre : semestres) {
                modeloSemestre.addElement(semestre.getIdSemestre());
            }
            boxReportesSemestre.setModel(modeloSemestre);

            //Llenar el box grupo
            DefaultComboBoxModel modeloGrupo = new DefaultComboBoxModel();
            List<Grupo> grupos = new GrupoDAOImpl().listar();

            for (Grupo grupo : grupos) {
                modeloGrupo.addElement(grupo.getIdGrupo());
            }
            boxReportesGrupo.setModel(modeloGrupo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //rellenar la tabla reportes
    private static void llenarTablaReportes() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            List<AlumnoPeriodo> alumnos = new AlumnoPeriodoDAOImpl().listar(String.valueOf(boxReportesPeriodo.getSelectedItem()));

            String[] columnas = {"Periodo escolar", "Matricula", "Nombre", "Apellido paterno", "Apellido materno", "Semestre", "Grupo",
                "Area de Recursos Administrativos", "Servicios Escolares", "Centro Evaluador y de Capacitación"};
            modelo.setColumnIdentifiers(columnas);

            for (AlumnoPeriodo alumno : alumnos) {
                String[] renglon = {alumno.getIdPeriodo(), alumno.getMatricula(), alumno.getNombre(), alumno.getaPaterno(), alumno.getaMaterno(),
                    String.valueOf(alumno.getSemestre()), alumno.getGrupo(), alumno.getEstatusEntrega1(), alumno.getEstatusEntrega2(), alumno.getEstatusEntrega3(),};
                modelo.addRow(renglon);
            }
            tablaReportes.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Rellenar tablas reportes filtrando semestre y periodo escolar
    private static void llenarTablaReportes2() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            List<AlumnoPeriodo> alumnos = new AlumnoPeriodoDAOImpl().listar2(String.valueOf(boxReportesPeriodo.getSelectedItem()),
                    String.valueOf(boxReportesSemestre.getSelectedItem()));

            String[] columnas = {"Periodo escolar", "Matricula", "Nombre", "Apellido paterno", "Apellido materno", "Semestre", "Grupo",
                "Area de Recursos Administrativos", "Servicios Escolares", "Centro Evaluador y de Capacitación"};
            modelo.setColumnIdentifiers(columnas);

            for (AlumnoPeriodo alumno : alumnos) {
                String[] renglon = {alumno.getIdPeriodo(), alumno.getMatricula(), alumno.getNombre(), alumno.getaPaterno(), alumno.getaMaterno(),
                    String.valueOf(alumno.getSemestre()), alumno.getGrupo(), alumno.getEstatusEntrega1(), alumno.getEstatusEntrega2(), alumno.getEstatusEntrega3(),};
                modelo.addRow(renglon);
            }
            tablaReportes.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Rellenar tablas reportes filtrando semestre y periodo escolar y grupo
    private static void llenarTablaReportes3() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            List<AlumnoPeriodo> alumnos = new AlumnoPeriodoDAOImpl().listar3(String.valueOf(boxReportesPeriodo.getSelectedItem()),
                    String.valueOf(boxReportesSemestre.getSelectedItem()), String.valueOf(boxReportesGrupo.getSelectedItem()));

            String[] columnas = {"Periodo escolar", "Matricula", "Nombre", "Apellido paterno.", "Apellido materno.", "Semestre", "Grupo",
                "Area de Recursos Administrativos", "Servicios Escolares", "Centro Evaluador y de Capacitación"};
            modelo.setColumnIdentifiers(columnas);

            for (AlumnoPeriodo alumno : alumnos) {
                String[] renglon = {alumno.getIdPeriodo(), alumno.getMatricula(), alumno.getNombre(), alumno.getaPaterno(), alumno.getaMaterno(),
                    String.valueOf(alumno.getSemestre()), alumno.getGrupo(), alumno.getEstatusEntrega1(), alumno.getEstatusEntrega2(), alumno.getEstatusEntrega3(),};
                modelo.addRow(renglon);
            }
            tablaReportes.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelReportes = new javax.swing.JPanel();
        etiReportes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReportes = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        boxReportesPeriodo = new javax.swing.JComboBox<>();
        txtBuscarAlumnosPeriodo = new javax.swing.JTextField();
        btnBuscarAlumnosPeriodo = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        boxReportesSemestre = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        boxReportesGrupo = new javax.swing.JComboBox<>();
        btnVerComprobantes = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();

        etiReportes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        etiReportes.setText("Reportes de entrega de comprobantes");

        tablaReportes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaReportes);

        jLabel28.setText("Periodo");

        boxReportesPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        boxReportesPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxReportesPeriodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        boxReportesPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxReportesPeriodoActionPerformed(evt);
            }
        });

        txtBuscarAlumnosPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarAlumnosPeriodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarAlumnosPeriodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        txtBuscarAlumnosPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAlumnosPeriodoActionPerformed(evt);
            }
        });

        btnBuscarAlumnosPeriodo.setBackground(new java.awt.Color(0, 126, 103));
        btnBuscarAlumnosPeriodo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBuscarAlumnosPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarAlumnosPeriodo.setText("Buscar");
        btnBuscarAlumnosPeriodo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnBuscarAlumnosPeriodo.setBorderPainted(false);
        btnBuscarAlumnosPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAlumnosPeriodo.setFocusPainted(false);
        btnBuscarAlumnosPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnosPeriodoActionPerformed(evt);
            }
        });

        jLabel29.setText("Semestre");

        boxReportesSemestre.setBackground(new java.awt.Color(255, 255, 255));
        boxReportesSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxReportesSemestre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        boxReportesSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxReportesSemestreActionPerformed(evt);
            }
        });

        jLabel30.setText("Grupo");

        boxReportesGrupo.setBackground(new java.awt.Color(255, 255, 255));
        boxReportesGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxReportesGrupo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        boxReportesGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxReportesGrupoActionPerformed(evt);
            }
        });

        btnVerComprobantes.setBackground(new java.awt.Color(0, 126, 103));
        btnVerComprobantes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnVerComprobantes.setForeground(new java.awt.Color(255, 255, 255));
        btnVerComprobantes.setText("Ver comprobantes");
        btnVerComprobantes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnVerComprobantes.setBorderPainted(false);
        btnVerComprobantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerComprobantes.setFocusPainted(false);
        btnVerComprobantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerComprobantesActionPerformed(evt);
            }
        });

        jLabel31.setText("Ingrese matrícula");

        javax.swing.GroupLayout panelReportesLayout = new javax.swing.GroupLayout(panelReportes);
        panelReportes.setLayout(panelReportesLayout);
        panelReportesLayout.setHorizontalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelReportesLayout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxReportesPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxReportesSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxReportesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarAlumnosPeriodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarAlumnosPeriodo))
                    .addGroup(panelReportesLayout.createSequentialGroup()
                        .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVerComprobantes)
                            .addComponent(etiReportes))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelReportesLayout.setVerticalGroup(
            panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiReportes)
                .addGap(19, 19, 19)
                .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarAlumnosPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarAlumnosPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(boxReportesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(boxReportesSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(boxReportesPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnVerComprobantes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panelReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxReportesPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxReportesPeriodoActionPerformed
        llenarTablaReportes();
    }//GEN-LAST:event_boxReportesPeriodoActionPerformed

    private void txtBuscarAlumnosPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAlumnosPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAlumnosPeriodoActionPerformed

    private void btnBuscarAlumnosPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnosPeriodoActionPerformed
        String periodo = String.valueOf(boxReportesPeriodo.getSelectedItem());
        String matricula = txtBuscarAlumnosPeriodo.getText();

        AlumnoPeriodoDAO alumnoPeridoDAO = new AlumnoPeriodoDAOImpl();
        DefaultTableModel modelo = new DefaultTableModel();

        String[] columnas = {"Periodo escolar", "Matricula", "Nombre", "Apellido paterno.", "Apellido materno.", "Semestre", "Grupo",
            "Area de Recursos Administrativos", "Servicios Escolares", "Centro Evaluador y de Capacitación"};
        modelo.setColumnIdentifiers(columnas);

        try {
            AlumnoPeriodo alumnoPeriodo = alumnoPeridoDAO.traerUnAlumnoPeriodo(periodo, matricula);
            if (alumnoPeriodo.getMatricula() == null) {
                JOptionPane.showMessageDialog(null, "Ingrese una matrícula válida", "AVISO", JOptionPane.ERROR_MESSAGE);
                txtBuscarAlumnosPeriodo.setText("");
                return;
            }
            String[] renglon = {alumnoPeriodo.getIdPeriodo(), alumnoPeriodo.getMatricula(), alumnoPeriodo.getNombre(), alumnoPeriodo.getaPaterno(), alumnoPeriodo.getaMaterno(),
                String.valueOf(alumnoPeriodo.getSemestre()), alumnoPeriodo.getGrupo(), alumnoPeriodo.getEstatusEntrega1(), alumnoPeriodo.getEstatusEntrega2(), alumnoPeriodo.getEstatusEntrega3(),};
            modelo.addRow(renglon);
            tablaReportes.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtBuscarAlumnosPeriodo.setText("");
    }//GEN-LAST:event_btnBuscarAlumnosPeriodoActionPerformed

    private void boxReportesSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxReportesSemestreActionPerformed
        llenarTablaReportes2();
    }//GEN-LAST:event_boxReportesSemestreActionPerformed

    private void boxReportesGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxReportesGrupoActionPerformed
        llenarTablaReportes3();
    }//GEN-LAST:event_boxReportesGrupoActionPerformed

    private void btnVerComprobantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerComprobantesActionPerformed
        int fila = tablaReportes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar por lo menos una fila para realizar la operación", "AVISO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Comprobantes.matricula = String.valueOf(tablaReportes.getValueAt(fila, 1));

        Comprobantes c = new Comprobantes();
        Dashboard.showView(c);
    }//GEN-LAST:event_btnVerComprobantesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> boxReportesGrupo;
    public static javax.swing.JComboBox<String> boxReportesPeriodo;
    public static javax.swing.JComboBox<String> boxReportesSemestre;
    private javax.swing.JButton btnBuscarAlumnosPeriodo;
    private javax.swing.JButton btnVerComprobantes;
    private javax.swing.JLabel etiReportes;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelReportes;
    static javax.swing.JTable tablaReportes;
    private javax.swing.JTextField txtBuscarAlumnosPeriodo;
    // End of variables declaration//GEN-END:variables
}
