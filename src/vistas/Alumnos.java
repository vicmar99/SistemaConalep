/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import interfaces.AlumnoDAO;
import interfaces.AlumnoPeriodoDAO;
import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.AlumnoPeriodo;
import model.Grupo;
import model.Periodo;
import model.Semestre;
import sistemaconalep.AlumnoDAOImpl;
import sistemaconalep.AlumnoPeriodoDAOImpl;
import sistemaconalep.GrupoDAOImpl;
import sistemaconalep.PeriodoDAOImpl;
import sistemaconalep.SemestreDAOImpl;

/**
 *
 * @author Yair
 */
public class Alumnos extends javax.swing.JPanel {

    /**
     * Creates new form Alumnos
     */
    public Alumnos() {
        initComponents();
        llenarcomboBox();
        deshabilitarPanel();
        llenarTablaAlumnos();
        llenarcomboBoxSemestreGrupo();
    }

    private void llenarcomboBox() {
        try {
            //Llenar el box semestre
            DefaultComboBoxModel modeloSemestre = new DefaultComboBoxModel();
            List<Semestre> semestres = new SemestreDAOImpl().listar();

            for (Semestre semestre : semestres) {
                modeloSemestre.addElement(semestre.getIdSemestre());
            }
            boxAlumnosSemestre.setModel(modeloSemestre);

            //Llenar el box grupo
            DefaultComboBoxModel modeloGrupo = new DefaultComboBoxModel();
            List<Grupo> grupos = new GrupoDAOImpl().listar();

            for (Grupo grupo : grupos) {
                modeloGrupo.addElement(grupo.getIdGrupo());
            }
            boxAlumnosGrupo.setModel(modeloGrupo);

            //Llenar el box periodo
            DefaultComboBoxModel modeloPeriodo = new DefaultComboBoxModel();
            List<Periodo> periodos = new PeriodoDAOImpl().listar();

            for (Periodo periodo : periodos) {
                modeloPeriodo.addElement(periodo.getIdPeriodo());
            }

            boxAlumnosPeriodo.setModel(modeloPeriodo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void habilitarPanel() {
        Component[] componentes = panelnuevoalumno.getComponents();
        for (Component componente : componentes) {
            componente.setEnabled(true);
        }
    }

    //Llenar combobox sestre en otro metodo para que no me altere la informacion de los demás combobox
    private void llenarcomboBoxSemestreGrupo() {
        try {
            //Llenar el box semestre
            DefaultComboBoxModel modeloSemestre = new DefaultComboBoxModel();
            List<Semestre> semestres = new SemestreDAOImpl().listar();

            for (Semestre semestre : semestres) {
                modeloSemestre.addElement(semestre.getIdSemestre());
            }
            boxSemestre.setModel(modeloSemestre);

            DefaultComboBoxModel modeloGrupo = new DefaultComboBoxModel();
            List<Grupo> grupos = new GrupoDAOImpl().listar();

            for (Grupo grupo : grupos) {
                modeloGrupo.addElement(grupo.getIdGrupo());
            }
            boxGrupo.setModel(modeloGrupo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //rellenar la tabla alumnos
    private static void llenarTablaAlumnos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            List<AlumnoPeriodo> alumnos = new AlumnoPeriodoDAOImpl().listar(String.valueOf(boxAlumnosPeriodo.getSelectedItem()));

            String[] columnas = {"Periodo escolar", "Matricula", "Nombre", "Apellido paterno", "Apellido materno", "Semestre", "Grupo"};
            modelo.setColumnIdentifiers(columnas);

            for (AlumnoPeriodo alumno : alumnos) {
                String[] renglon = {alumno.getIdPeriodo(), alumno.getMatricula(), alumno.getNombre(), alumno.getaPaterno(), alumno.getaMaterno(),
                    String.valueOf(alumno.getSemestre()), alumno.getGrupo()};
                modelo.addRow(renglon);
            }
           
            tablaAlumnos.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //rellenar la tabla alumnos filtrando por Periodo y semestre
    private static void llenarTablaAlumnos2() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            List<AlumnoPeriodo> alumnos = new AlumnoPeriodoDAOImpl().listar2(String.valueOf(boxAlumnosPeriodo.getSelectedItem()),
                    String.valueOf(boxAlumnosSemestre.getSelectedItem()));

            String[] columnas = {"Periodo escolar", "Matricula", "Nombre", "Apellido paterno.", "Apellido materno.", "Semestre", "Grupo"};
            modelo.setColumnIdentifiers(columnas);

            for (AlumnoPeriodo alumno : alumnos) {
                String[] renglon = {alumno.getIdPeriodo(), alumno.getMatricula(), alumno.getNombre(), alumno.getaPaterno(), alumno.getaMaterno(),
                    String.valueOf(alumno.getSemestre()), alumno.getGrupo()};
                modelo.addRow(renglon);
            }
            tablaAlumnos.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //rellenar la tabla alumnos filtrando por Periodo, semestre y grupo
    private static void llenarTablaAlumnos3() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            List<AlumnoPeriodo> alumnos = new AlumnoPeriodoDAOImpl().listar3(String.valueOf(boxAlumnosPeriodo.getSelectedItem()),
                    String.valueOf(boxAlumnosSemestre.getSelectedItem()), String.valueOf(boxAlumnosGrupo.getSelectedItem()));

            String[] columnas = {"Periodo escolar", "Matricula", "Nombre", "Apellido paterno.", "Apellido materno.", "Semestre", "Grupo"};
            modelo.setColumnIdentifiers(columnas);

            for (AlumnoPeriodo alumno : alumnos) {
                String[] renglon = {alumno.getIdPeriodo(), alumno.getMatricula(), alumno.getNombre(), alumno.getaPaterno(), alumno.getaMaterno(),
                    String.valueOf(alumno.getSemestre()), alumno.getGrupo()};
                modelo.addRow(renglon);
            }
            tablaAlumnos.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo para deshabilitar panelNuevoAlumno
    private void deshabilitarPanel() {
        Component[] componentes = panelnuevoalumno.getComponents();
        for (Component componente : componentes) {
            componente.setEnabled(false);
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

        panelAlumnos = new javax.swing.JPanel();
        etiAlumnos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        btnNuevoAlumno = new javax.swing.JButton();
        btnModificarAlumno = new javax.swing.JButton();
        btnEliminarAlumno = new javax.swing.JButton();
        panelnuevoalumno = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNombreAlumno = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtApellidoPaterno = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnAceptarActNuevAl = new javax.swing.JButton();
        boxSemestre = new javax.swing.JComboBox<>();
        boxGrupo = new javax.swing.JComboBox<>();
        boxAlumnosSemestre = new javax.swing.JComboBox<>();
        boxAlumnosGrupo = new javax.swing.JComboBox<>();
        txtBuscarAlumnosMatricula = new javax.swing.JTextField();
        btnBuscarAlumnos = new javax.swing.JButton();
        boxAlumnosPeriodo = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();

        etiAlumnos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        etiAlumnos.setText("Alumnos");

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaAlumnos);

        btnNuevoAlumno.setBackground(new java.awt.Color(0, 126, 103));
        btnNuevoAlumno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnNuevoAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoAlumno.setText("Nuevo");
        btnNuevoAlumno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnNuevoAlumno.setBorderPainted(false);
        btnNuevoAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoAlumno.setFocusPainted(false);
        btnNuevoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAlumnoActionPerformed(evt);
            }
        });

        btnModificarAlumno.setBackground(new java.awt.Color(0, 126, 103));
        btnModificarAlumno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnModificarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarAlumno.setText("Modificar");
        btnModificarAlumno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnModificarAlumno.setBorderPainted(false);
        btnModificarAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarAlumno.setFocusPainted(false);
        btnModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAlumnoActionPerformed(evt);
            }
        });

        btnEliminarAlumno.setBackground(new java.awt.Color(0, 126, 103));
        btnEliminarAlumno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnEliminarAlumno.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAlumno.setText("Eliminar");
        btnEliminarAlumno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnEliminarAlumno.setBorderPainted(false);
        btnEliminarAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarAlumno.setFocusPainted(false);
        btnEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlumnoActionPerformed(evt);
            }
        });

        panelnuevoalumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel14.setText("Matrícula");

        txtMatricula.setBackground(new java.awt.Color(255, 255, 255));
        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel15.setText("Nombre");

        txtNombreAlumno.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreAlumno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel16.setText("Apellido paterno");

        txtApellidoPaterno.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoPaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidoPaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel17.setText("Apellido materno");

        txtApellidoMaterno.setBackground(new java.awt.Color(255, 255, 255));
        txtApellidoMaterno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtApellidoMaterno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel18.setText("Semestre");

        jLabel19.setText("Grupo");

        btnAceptarActNuevAl.setBackground(new java.awt.Color(0, 126, 103));
        btnAceptarActNuevAl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAceptarActNuevAl.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarActNuevAl.setText("Aceptar");
        btnAceptarActNuevAl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnAceptarActNuevAl.setBorderPainted(false);
        btnAceptarActNuevAl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarActNuevAl.setFocusPainted(false);
        btnAceptarActNuevAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActNuevAlActionPerformed(evt);
            }
        });

        boxSemestre.setBackground(new java.awt.Color(255, 255, 255));
        boxSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxSemestre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        boxSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSemestreActionPerformed(evt);
            }
        });

        boxGrupo.setBackground(new java.awt.Color(255, 255, 255));
        boxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxGrupo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout panelnuevoalumnoLayout = new javax.swing.GroupLayout(panelnuevoalumno);
        panelnuevoalumno.setLayout(panelnuevoalumnoLayout);
        panelnuevoalumnoLayout.setHorizontalGroup(
            panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnuevoalumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidoMaterno)
                    .addComponent(txtMatricula))
                .addGroup(panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelnuevoalumnoLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel15))
                    .addGroup(panelnuevoalumnoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boxSemestre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreAlumno))
                .addGap(25, 25, 25)
                .addGroup(panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidoPaterno)
                    .addComponent(boxGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(btnAceptarActNuevAl)
                .addContainerGap())
        );
        panelnuevoalumnoLayout.setVerticalGroup(
            panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnuevoalumnoLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelnuevoalumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(boxSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelnuevoalumnoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarActNuevAl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        boxAlumnosSemestre.setBackground(new java.awt.Color(255, 255, 255));
        boxAlumnosSemestre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxAlumnosSemestre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        boxAlumnosSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAlumnosSemestreActionPerformed(evt);
            }
        });

        boxAlumnosGrupo.setBackground(new java.awt.Color(255, 255, 255));
        boxAlumnosGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxAlumnosGrupo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        boxAlumnosGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAlumnosGrupoActionPerformed(evt);
            }
        });

        txtBuscarAlumnosMatricula.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscarAlumnosMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscarAlumnosMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnBuscarAlumnos.setBackground(new java.awt.Color(0, 126, 103));
        btnBuscarAlumnos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnBuscarAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarAlumnos.setText("Buscar");
        btnBuscarAlumnos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnBuscarAlumnos.setBorderPainted(false);
        btnBuscarAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarAlumnos.setFocusPainted(false);
        btnBuscarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumnosActionPerformed(evt);
            }
        });

        boxAlumnosPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        boxAlumnosPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxAlumnosPeriodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        boxAlumnosPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAlumnosPeriodoActionPerformed(evt);
            }
        });

        jLabel23.setText("Perido");

        jLabel24.setText("Semestre");

        jLabel32.setText("Grupo");

        jLabel27.setText("Ingrese matrícula");

        javax.swing.GroupLayout panelAlumnosLayout = new javax.swing.GroupLayout(panelAlumnos);
        panelAlumnos.setLayout(panelAlumnosLayout);
        panelAlumnosLayout.setHorizontalGroup(
            panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelAlumnosLayout.createSequentialGroup()
                        .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelnuevoalumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etiAlumnos)
                            .addGroup(panelAlumnosLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxAlumnosPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxAlumnosSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxAlumnosGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarAlumnosMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarAlumnos))
                            .addGroup(panelAlumnosLayout.createSequentialGroup()
                                .addComponent(btnNuevoAlumno)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarAlumno)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarAlumno)))
                        .addContainerGap())))
        );
        panelAlumnosLayout.setVerticalGroup(
            panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlumnosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(etiAlumnos)
                .addGap(18, 18, 18)
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxAlumnosSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxAlumnosGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarAlumnosMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxAlumnosPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel32)
                    .addComponent(jLabel27))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelnuevoalumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 892, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAlumnoActionPerformed
        txtMatricula.setText("");
        txtNombreAlumno.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        llenarcomboBox();
        habilitarPanel();
        txtMatricula.setEditable(true);
    }//GEN-LAST:event_btnNuevoAlumnoActionPerformed

    private void btnModificarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAlumnoActionPerformed

        int fila = tablaAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar por lo menos una fila para realizar la operación", "AVISO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String matricula = String.valueOf(tablaAlumnos.getValueAt(fila, 1));
        AlumnoDAO alumnoDAO = new AlumnoDAOImpl();

        try {
            Alumno alumno = alumnoDAO.traerUnAlumno(matricula);
            txtMatricula.setText(alumno.getMatricula());
            txtNombreAlumno.setText(alumno.getNombre());
            txtApellidoPaterno.setText(alumno.getaPaterno());
            txtApellidoMaterno.setText(alumno.getaMaterno());
            boxSemestre.setSelectedItem(alumno.getSemestre());
            boxGrupo.setSelectedItem(alumno.getGrupo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        habilitarPanel();
        txtMatricula.setEditable(false);
    }//GEN-LAST:event_btnModificarAlumnoActionPerformed

    private void btnEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlumnoActionPerformed
        int fila = tablaAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar por lo menos una fila para realizar la operación", "AVISO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(null, "Los registro seleccionados se eliminarán de forma definitiva\n¿Desea continuar?",
                "Confirmar eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
            AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
            for (int i : tablaAlumnos.getSelectedRows()) {
                try {
                    alumnoDAO.eliminar(String.valueOf(tablaAlumnos.getValueAt(i, 1)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            llenarTablaAlumnos();
        }
    }//GEN-LAST:event_btnEliminarAlumnoActionPerformed

    private void btnAceptarActNuevAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActNuevAlActionPerformed
        String periodo = String.valueOf(boxAlumnosPeriodo.getSelectedItem());
        String matricula = txtMatricula.getText();
        String nombre = txtNombreAlumno.getText();
        String aPaterno = txtApellidoPaterno.getText();
        String aMaterno = txtApellidoMaterno.getText();
        int semestre = Integer.parseInt(boxSemestre.getSelectedItem().toString());
        String grupo = boxGrupo.getSelectedItem().toString();

        if (matricula.trim().isEmpty() || nombre.trim().isEmpty() || aPaterno.trim().isEmpty() || aMaterno.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Alumno alumno = new Alumno();
        alumno.setMatricula(matricula);
        alumno.setNombre(nombre);
        alumno.setaPaterno(aPaterno);
        alumno.setaMaterno(aMaterno);
        alumno.setSemestre(semestre);
        alumno.setGrupo(grupo);

        AlumnoPeriodo alumnoPeriodo = new AlumnoPeriodo();
        alumnoPeriodo.setIdPeriodo(periodo);
        alumnoPeriodo.setMatricula(matricula);
        alumnoPeriodo.setSemestre(semestre);
        alumnoPeriodo.setGrupo(grupo);

        try {
            AlumnoDAO dao = new AlumnoDAOImpl();
            AlumnoPeriodoDAO aO = new AlumnoPeriodoDAOImpl();
            Alumno alumnoBuscado = dao.traerUnAlumno(matricula);
            if (alumnoBuscado.getMatricula() == null) {
                dao.registrar(alumno);
                aO.registrar(alumnoPeriodo);
                JOptionPane.showMessageDialog(null, "Operación exitosa", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dao.modificar(alumno);
                aO.modificarAl(alumnoPeriodo);
                JOptionPane.showMessageDialog(null, "Operación exitosa", "AVISO", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la opeación", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        txtMatricula.setText("");
        txtNombreAlumno.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        llenarTablaAlumnos();
        llenarcomboBox();
        deshabilitarPanel();
    }//GEN-LAST:event_btnAceptarActNuevAlActionPerformed

    private void boxSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSemestreActionPerformed

    private void boxAlumnosSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAlumnosSemestreActionPerformed
        llenarTablaAlumnos2();
    }//GEN-LAST:event_boxAlumnosSemestreActionPerformed

    private void boxAlumnosGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAlumnosGrupoActionPerformed
        llenarTablaAlumnos3();
    }//GEN-LAST:event_boxAlumnosGrupoActionPerformed

    private void btnBuscarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumnosActionPerformed
        String periodo = String.valueOf(boxAlumnosPeriodo.getSelectedItem());
        String matricula = txtBuscarAlumnosMatricula.getText();

        AlumnoPeriodoDAO alumnoPeridoDAO = new AlumnoPeriodoDAOImpl();
        DefaultTableModel modelo = new DefaultTableModel();

        String[] columnas = {"Periodo escolar", "Matricula", "Nombre", "Apellido paterno.", "Apellido materno.", "Semestre", "Grupo"};
        modelo.setColumnIdentifiers(columnas);

        try {
            AlumnoPeriodo alumnoPeriodo = alumnoPeridoDAO.traerUnAlumnoPeriodo(periodo, matricula);
            if (alumnoPeriodo.getMatricula() == null) {
                JOptionPane.showMessageDialog(null, "Ingrese una matrícula válida", "AVISO", JOptionPane.ERROR_MESSAGE);
                txtBuscarAlumnosMatricula.setText("");
                return;
            }
            String[] renglon = {alumnoPeriodo.getIdPeriodo(), alumnoPeriodo.getMatricula(), alumnoPeriodo.getNombre(),
                alumnoPeriodo.getaPaterno(), alumnoPeriodo.getaMaterno(), String.valueOf(alumnoPeriodo.getSemestre()), alumnoPeriodo.getGrupo()};
            modelo.addRow(renglon);
            tablaAlumnos.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtBuscarAlumnosMatricula.setText("");
    }//GEN-LAST:event_btnBuscarAlumnosActionPerformed

    private void boxAlumnosPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAlumnosPeriodoActionPerformed
        llenarTablaAlumnos();
    }//GEN-LAST:event_boxAlumnosPeriodoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> boxAlumnosGrupo;
    public static javax.swing.JComboBox<String> boxAlumnosPeriodo;
    public static javax.swing.JComboBox<String> boxAlumnosSemestre;
    private javax.swing.JComboBox<String> boxGrupo;
    private javax.swing.JComboBox<String> boxSemestre;
    private javax.swing.JButton btnAceptarActNuevAl;
    private javax.swing.JButton btnBuscarAlumnos;
    private javax.swing.JButton btnEliminarAlumno;
    private javax.swing.JButton btnModificarAlumno;
    private javax.swing.JButton btnNuevoAlumno;
    private javax.swing.JLabel etiAlumnos;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelAlumnos;
    private javax.swing.JPanel panelnuevoalumno;
    static javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtBuscarAlumnosMatricula;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombreAlumno;
    // End of variables declaration//GEN-END:variables
}
