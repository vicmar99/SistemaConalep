/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import interfaces.AlumnoDAO;
import interfaces.AlumnoPeriodoDAO;
import interfaces.PeriodoDAO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.Grupo;
import model.Periodo;
import model.Semestre;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import controller.AlumnoDAOImpl;
import controller.AlumnoPeriodoDAOImpl;
import controller.GrupoDAOImpl;
import controller.PeriodoDAOImpl;
import controller.SemestreDAOImpl;

/**
 *
 * @author Yair
 */
public class PeriodoEscolar extends javax.swing.JPanel {

    String rutaArchivoExcel = "";

    /**
     * Creates new form PeriodoEscolar
     */
    public PeriodoEscolar() {
        initComponents();
        rellenarTablaPeriodos();
        llenarcomboBox();
    }

    //Metodo para obtener la lista de alumnos del archivo excel
    public List<Alumno> obtenerListaAlumnos(String rutaArchivo) {
        List<Alumno> listaAlumnos = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(new File(rutaArchivo))) {
            Sheet sheet = workbook.getSheetAt(0); //Los datosdeben estar en la primera hoja del archivo

            int rowCount = sheet.getLastRowNum(); // Obtiene el número total de filas

            // Itera a partir de la segunda fila (omitir la primera fila que son los encabezados)
            for (int i = 1; i <= rowCount; i++) {
                XSSFRow row = (XSSFRow) sheet.getRow(i);  // Obtiene la fila actual

                // Leer los valores de las celdas 
                Cell matriculaCell = row.getCell(0);
                Cell nombreCell = row.getCell(1);
                Cell aPaternoCell = row.getCell(2);
                Cell aMaternoCell = row.getCell(3);
                Cell semestreCell = row.getCell(4);
                Cell grupoCell = row.getCell(5);

                //y almacenarlos en variables
                String matricula = getStringCellValue(matriculaCell);
                String nombre = getStringCellValue(nombreCell);
                String aPaterno = getStringCellValue(aPaternoCell);
                String aMaterno = getStringCellValue(aMaternoCell);
                String semestre = getStringCellValue(semestreCell);
                String grupo = getStringCellValue(grupoCell);

                Alumno alumno = new Alumno(matricula, nombre, aPaterno, aMaterno, Integer.parseInt(semestre), grupo);
                listaAlumnos.add(alumno);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaAlumnos;
    }

    //Método que nos ayudará a leer la información de las celdas y devolver el contenido en String
    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        CellType cellType = cell.getCellType();
        if (cellType == CellType.STRING) {
            return cell.getStringCellValue().trim();
        } else if (cellType == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(cell)) {
                // Si la celda contiene una fecha, puedes hacer algo como esto:
                return cell.getDateCellValue().toString();
            } else {
                // Si la celda contiene un número, verifica si es un valor válido
                double numericValue = cell.getNumericCellValue();
                if (Double.isNaN(numericValue)) {
                    return "";
                } else {
                    return String.valueOf((int) numericValue);
                }
            }
        } else {
            return "";
        }
    }

    //Rellenar la tabla periodos
    private static void rellenarTablaPeriodos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            List<Periodo> periodos = new PeriodoDAOImpl().listar();

            String[] columnas = {"Periodos"};
            modelo.setColumnIdentifiers(columnas);

            for (Periodo periodo : periodos) {
                String[] renglon = {periodo.getIdPeriodo()};
                modelo.addRow(renglon);
            }
            tablaPeriodos.setModel(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Llenar el box periodo
    private void llenarcomboBox() {
        try {

            DefaultComboBoxModel modeloPeriodo = new DefaultComboBoxModel();
            List<Periodo> periodos = new PeriodoDAOImpl().listar();

            for (Periodo periodo : periodos) {
                modeloPeriodo.addElement(periodo.getIdPeriodo());
            }
            boxSelectPeriodoEscolar.setModel(modeloPeriodo);
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

        panelPeriodoEscolar = new javax.swing.JPanel();
        etiSemestre = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        boxSelectPeriodoEscolar = new javax.swing.JComboBox<>();
        btnSeleccionarArchivo = new javax.swing.JButton();
        btnAceptarCargarListaAlumnos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaPeriodos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtNuevoPeriodo = new javax.swing.JTextField();
        btnAceptarNuevoPeriodo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaGrupos = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNuevoGrupo = new javax.swing.JTextField();
        btnAceptarNGrupo = new javax.swing.JButton();

        etiSemestre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        etiSemestre.setText("Configurar periodo escolar");

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel7.setText("Cargar lista de alumnos");

        jLabel12.setText("Seleccione periodo escolar");

        boxSelectPeriodoEscolar.setBackground(new java.awt.Color(255, 255, 255));
        boxSelectPeriodoEscolar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxSelectPeriodoEscolar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnSeleccionarArchivo.setBackground(new java.awt.Color(0, 126, 103));
        btnSeleccionarArchivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnSeleccionarArchivo.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarArchivo.setText("Seleccionar archivo...");
        btnSeleccionarArchivo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnSeleccionarArchivo.setBorderPainted(false);
        btnSeleccionarArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeleccionarArchivo.setFocusPainted(false);
        btnSeleccionarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarArchivoActionPerformed(evt);
            }
        });

        btnAceptarCargarListaAlumnos.setBackground(new java.awt.Color(0, 126, 103));
        btnAceptarCargarListaAlumnos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAceptarCargarListaAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarCargarListaAlumnos.setText("Aceptar");
        btnAceptarCargarListaAlumnos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnAceptarCargarListaAlumnos.setBorderPainted(false);
        btnAceptarCargarListaAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarCargarListaAlumnos.setFocusPainted(false);
        btnAceptarCargarListaAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarCargarListaAlumnosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleccionarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(boxSelectPeriodoEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptarCargarListaAlumnos)
                .addGap(98, 98, 98))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(boxSelectPeriodoEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnSeleccionarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnAceptarCargarListaAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tablaPeriodos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tablaPeriodos);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel13.setText("Nuevo periodo escolar");

        txtNuevoPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        txtNuevoPeriodo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNuevoPeriodo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnAceptarNuevoPeriodo.setBackground(new java.awt.Color(0, 126, 103));
        btnAceptarNuevoPeriodo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAceptarNuevoPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarNuevoPeriodo.setText("Aceptar");
        btnAceptarNuevoPeriodo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnAceptarNuevoPeriodo.setBorderPainted(false);
        btnAceptarNuevoPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarNuevoPeriodo.setFocusPainted(false);
        btnAceptarNuevoPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarNuevoPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNuevoPeriodo)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnAceptarNuevoPeriodo)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(txtNuevoPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptarNuevoPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tablaGrupos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tablaGrupos);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel14.setText("Nuevo grupo");

        txtNuevoGrupo.setBackground(new java.awt.Color(255, 255, 255));
        txtNuevoGrupo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNuevoGrupo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnAceptarNGrupo.setBackground(new java.awt.Color(0, 126, 103));
        btnAceptarNGrupo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAceptarNGrupo.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarNGrupo.setText("Aceptar");
        btnAceptarNGrupo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 10, new java.awt.Color(0, 0, 0)));
        btnAceptarNGrupo.setBorderPainted(false);
        btnAceptarNGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarNGrupo.setFocusPainted(false);
        btnAceptarNGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarNGrupoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNuevoGrupo)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(btnAceptarNGrupo)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(txtNuevoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnAceptarNGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPeriodoEscolarLayout = new javax.swing.GroupLayout(panelPeriodoEscolar);
        panelPeriodoEscolar.setLayout(panelPeriodoEscolarLayout);
        panelPeriodoEscolarLayout.setHorizontalGroup(
            panelPeriodoEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeriodoEscolarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPeriodoEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiSemestre)
                    .addGroup(panelPeriodoEscolarLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPeriodoEscolarLayout.setVerticalGroup(
            panelPeriodoEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPeriodoEscolarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiSemestre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(panelPeriodoEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelPeriodoEscolar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelPeriodoEscolar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(5, 5, 5)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarArchivoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos XLSX", "xlsx");
        fileChooser.setFileFilter(filter);
        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            rutaArchivoExcel = fileChooser.getSelectedFile().getPath();
            btnSeleccionarArchivo.setText(fileName);

        }
    }//GEN-LAST:event_btnSeleccionarArchivoActionPerformed

    private void btnAceptarCargarListaAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarCargarListaAlumnosActionPerformed
        String rutaArchivo = rutaArchivoExcel;

        if (rutaArchivo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo de Excel ",
                    "AVISO", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Alumno> listaAlumnos = obtenerListaAlumnos(rutaArchivo);
        AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
        AlumnoPeriodoDAO alumnoPeriodoDAO = new AlumnoPeriodoDAOImpl();

        if (listaAlumnos == null) {
            JOptionPane.showMessageDialog(null, "Error con el archivo seleccionado",
                    "AVISO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            alumnoDAO.registrarLista(listaAlumnos);
            JOptionPane.showMessageDialog(null, "Operación exitosa",
                    "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            alumnoPeriodoDAO.registrarLista(listaAlumnos,
                    String.valueOf(boxSelectPeriodoEscolar.getSelectedItem()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        rellenarTablaPeriodos();
        llenarcomboBox();
        btnSeleccionarArchivo.setText("Seleccionar archivo...");
        rutaArchivoExcel = "";
    }//GEN-LAST:event_btnAceptarCargarListaAlumnosActionPerformed

    private void btnAceptarNuevoPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarNuevoPeriodoActionPerformed
        String idPeriodo = txtNuevoPeriodo.getText();

        Periodo periodo = new Periodo();
        periodo.setIdPeriodo(idPeriodo);

        if (idPeriodo.trim().isEmpty()) {//Eliminar espacios y validar si está vacío o no
            JOptionPane.showMessageDialog(null, "Ingrese un periodo nuevo",
                    "AVISO", JOptionPane.WARNING_MESSAGE);
            return;//Si está vacío terminamos detenemos la ejecución
        }
        try {
            PeriodoDAO dao = new PeriodoDAOImpl();
            dao.registrar(periodo);
            JOptionPane.showMessageDialog(null, "Operación exitosa",
                    "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocurrió un error al realizar la opeación",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        txtNuevoPeriodo.setText("");
        rellenarTablaPeriodos();
        llenarcomboBox();
    }//GEN-LAST:event_btnAceptarNuevoPeriodoActionPerformed

    private void btnAceptarNGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarNGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarNGrupoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> boxSelectPeriodoEscolar;
    private javax.swing.JButton btnAceptarCargarListaAlumnos;
    private javax.swing.JButton btnAceptarNGrupo;
    private javax.swing.JButton btnAceptarNuevoPeriodo;
    private javax.swing.JButton btnSeleccionarArchivo;
    private javax.swing.JLabel etiSemestre;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel panelPeriodoEscolar;
    static javax.swing.JTable tablaGrupos;
    static javax.swing.JTable tablaPeriodos;
    private javax.swing.JTextField txtNuevoGrupo;
    private javax.swing.JTextField txtNuevoPeriodo;
    // End of variables declaration//GEN-END:variables
}
