/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.vista.gui;

import java.util.List;

import co.edu.eam.disenosoft.universidad.vista.controladores.ControladorVentanaVerRegistroEstudiante;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dir_software
 */
public class VentanaVerRegistroEstudiante extends javax.swing.JInternalFrame {

    private ControladorVentanaVerRegistroEstudiante controlador;
    private List<RegistroCurso> cursos;

    /**
     * Creates new form VentanaRegistrarCurso
     */
    public VentanaVerRegistroEstudiante() {
        controlador = new ControladorVentanaVerRegistroEstudiante();
        cursos = null;
        initComponents();
        setVisible(true);
        setMaximizable(false);
        setIconifiable(true);
        setResizable(false);
        setClosable(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHorario = new javax.swing.JTable();
        btnQuitarAsignatura = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfcedulaestudiante = new javax.swing.JTextField();
        btnBuscarEstuainte = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfnombreestudiante = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfcreditosregistradosestudiante = new javax.swing.JTextField();

        setIconifiable(true);
        setTitle("Ver Registro Estudiante");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zoom37.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursos Registrados"));

        jScrollPane1.setBorder(null);

        tablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre Asignatura", "Horario"
            }
        ));
        jScrollPane1.setViewportView(tablaHorario);

        btnQuitarAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/multiplication.png"))); // NOI18N
        btnQuitarAsignatura.setToolTipText("Quitar Asignatura Registrada");
        btnQuitarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAsignaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnQuitarAsignatura)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuitarAsignatura))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Estudiante"));

        jLabel3.setText("Cedula");

        btnBuscarEstuainte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/zoom37.png"))); // NOI18N
        btnBuscarEstuainte.setToolTipText("Buscar Docente");
        btnBuscarEstuainte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstuainteActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre");

        tfnombreestudiante.setEditable(false);

        jLabel6.setText("Creditos Registrados");

        tfcreditosregistradosestudiante.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfcedulaestudiante, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(tfnombreestudiante)
                    .addComponent(tfcreditosregistradosestudiante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnBuscarEstuainte, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscarEstuainte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfcedulaestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfnombreestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfcreditosregistradosestudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarEstuainteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstuainteActionPerformed
        // TODO add your handling code here:
        try {
            if (tfcedulaestudiante.getText() == null) {
                JOptionPane.showMessageDialog(null, "Ingrese una c�dula");
            } else {
                Estudiante estudiante = controlador.buscarEstudiante(tfcedulaestudiante.getText());
                if (estudiante != null) {
                    tfnombreestudiante.setText(estudiante.getNombre() + " " + estudiante.getApellido());
                    tfcreditosregistradosestudiante.setText(controlador.contarCreditosEstudiante(estudiante)+"");
                    llenarTabla(estudiante);
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un estudiante registrado "
                            + "con la c�dula " + tfcedulaestudiante.getText());
                    limpiarCampos();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarEstuainteActionPerformed

    private void btnQuitarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAsignaturaActionPerformed
        // TODO add your handling code here:
         try {
            if (tablaHorario.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "No hay un curso seleccionado");
            } else {
                RegistroCurso registro = cursos.get(tablaHorario.getSelectedRow());
                controlador.eliminarRegistro(registro);
                btnBuscarEstuainteActionPerformed(evt);
            }
        }catch (ExcepcionNegocio ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnQuitarAsignaturaActionPerformed
    /**
     * M�todo para limpiar campos de la ventana
     */
    private void limpiarCampos() {
        tfnombreestudiante.setText(null);
        tfcreditosregistradosestudiante.setText(null);
        limpiarTabla();
    }

    /**
     * M�todo para limpiar la tabla
     */
    private void limpiarTabla() {
        DefaultTableModel tabla = (DefaultTableModel) tablaHorario.getModel();
        tabla.setRowCount(0);
    }

    /**
     * M�todo para llenar la tabla de horario
     *
     * @param estudiante, estudiante al cual se le buscar�n los registros
     * @throws PersistenciaException
     */
    private void llenarTabla(Estudiante estudiante) throws Exception {
        cursos = controlador.listarRegistroCursoPorEstudiante(estudiante);
        DefaultTableModel tabla = (DefaultTableModel) tablaHorario.getModel();
        tabla.setRowCount(0);
        for (int i = 0; i < cursos.size(); i++) {
            String horario = "";
            for (int j = 0; j < cursos.get(i).getCurso().getSesiones().size(); j++) {
                horario += cursos.get(i).getCurso().getSesiones().get(j).getDia().toString() + " ";
                horario += cursos.get(i).getCurso().getSesiones().get(j).getHoraInicio() + "-";
                horario += cursos.get(i).getCurso().getSesiones().get(j).getHoraFinal() + ". ";
            }
            tabla.addRow(new Object[]{cursos.get(i).getCurso().getAsignatura().getNombre(),
                horario});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarEstuainte;
    private javax.swing.JButton btnQuitarAsignatura;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHorario;
    private javax.swing.JTextField tfcedulaestudiante;
    private javax.swing.JTextField tfcreditosregistradosestudiante;
    private javax.swing.JTextField tfnombreestudiante;
    // End of variables declaration//GEN-END:variables
}