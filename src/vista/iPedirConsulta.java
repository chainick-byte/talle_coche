/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controller.ControladorConsulta;
import controller.ControladorFactura;
import javax.swing.JOptionPane;

/**
 *
 * @author igorr
 */
public class iPedirConsulta extends javax.swing.JFrame {

    int id_propietario;
    int id_auto;
    int id_factura;
    ControladorConsulta miControladorConsulta = new ControladorConsulta();
    ControladorFactura miControladorFactura = new ControladorFactura();

    /**
     * Creates new form iDameTodosAutos
     *
     * @param _id_propietario
     */
    public iPedirConsulta(int _id_propietario) {
        this.id_propietario = _id_propietario;
        initComponents();
        miControladorConsulta.dameTablaAutoDePropietario(tablaConsulta, id_propietario);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsulta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        formMatricula = new javax.swing.JTextField();
        formAnno = new javax.swing.JTextField();
        formModelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        formDescripcion_averia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comboBusqueda = new javax.swing.JComboBox<>();
        formBusqueda = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Consulta", "Matricula", "Descripcion", "Modelo", "Año", "Estado"
            }
        ));
        tablaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaConsulta);

        jLabel1.setText("Matricula: ");

        jLabel2.setText("Descripcion de averia");

        jLabel3.setText("Modelo: ");

        jLabel4.setText("Año fabricacion:");

        jButton1.setText("Nueva Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Generar Factura");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(formModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                            .addComponent(formDescripcion_averia)
                            .addComponent(formAnno)
                            .addComponent(formMatricula))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(formMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(formDescripcion_averia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(formModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(formAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        comboBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONA PARAMETRO DE BUSQUEDA", "AÑO", "MODELO", "MATRICULA", " " }));

        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(formBusqueda, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        miControladorConsulta.guardarConsulta(id_propietario, formMatricula.getText(), formDescripcion_averia.getText(),
                formModelo.getText(), Integer.parseInt(formAnno.getText()));
        miControladorConsulta.limpiarTabla();
        miControladorConsulta.dameTablaAutoDePropietario(tablaConsulta, id_propietario);
        limpiaForms();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultaMouseClicked
        int fila = tablaConsulta.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "no se ha seleccionado ninguna fila");
        } else {
            id_auto = Integer.parseInt(tablaConsulta.getValueAt(fila, 0).toString());
            String matricula = tablaConsulta.getValueAt(fila, 1).toString();
            String descripcion_averia = tablaConsulta.getValueAt(fila, 2).toString();
            String modelo = tablaConsulta.getValueAt(fila, 3).toString();
            String anno = tablaConsulta.getValueAt(fila, 4).toString();

            //form.setText(variables de arriba)
            formMatricula.setText(matricula);
            formDescripcion_averia.setText(descripcion_averia);
            formModelo.setText(modelo);
            formAnno.setText(anno);
        }
    }//GEN-LAST:event_tablaConsultaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        miControladorConsulta.actualizarConsulta(id_propietario, formMatricula.getText(), formDescripcion_averia.getText(),
                formModelo.getText(), Integer.parseInt(formAnno.getText()), id_auto);

        miControladorConsulta.limpiarTabla();
        miControladorConsulta.dameTablaAutoDePropietario(tablaConsulta, id_propietario);
        limpiaForms();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        miControladorConsulta.borrameConsulta(id_auto);
        miControladorConsulta.limpiarTabla();
        miControladorConsulta.dameTablaAutoDePropietario(tablaConsulta, id_propietario);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int fila = tablaConsulta.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "no se ha seleccionado ninguna fila");
        } else {
            if(!Boolean.parseBoolean(tablaConsulta.getValueAt(fila, 5).toString())){
            this.setVisible(false);
            miControladorFactura.guardaFactura(id_auto);
            id_factura=miControladorFactura.dameIdFactura(id_auto);
            System.out.println(id_factura+"<<<<<<<<======");
            iGenerarFactura mifactura = new iGenerarFactura(id_auto, id_propietario,id_factura);
            mifactura.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "esta factura ya esta elaborada!!!");
                limpiaForms();
                
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (formBusqueda.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "no has dado ningun valor de busqueda");
        } else {
            switch (comboBusqueda.getSelectedItem().toString()) {
                case "SELECCIONA PARAMETRO DE BUSQUEDA":
                    JOptionPane.showMessageDialog(this, "no has seleccionado ningun parametro de busqueda");
                    break;
                case "AÑO":
                    miControladorConsulta.limpiarTabla();
                    miControladorConsulta.buscarPorAnno(tablaConsulta, Integer.parseInt(formBusqueda.getText()), id_propietario);
                    break;
                case "MODELO":
                    miControladorConsulta.limpiarTabla();
                    miControladorConsulta.buscarPorModelo(tablaConsulta, formBusqueda.getText(), id_propietario);
                    break;
                case "MATRICULA":
                    miControladorConsulta.limpiarTabla();
                    miControladorConsulta.buscarPorMatricula(tablaConsulta, formBusqueda.getText(), id_propietario);
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    private void limpiaForms() {
        formMatricula.setText("");
        formDescripcion_averia.setText("");
        formModelo.setText("");
        formAnno.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBusqueda;
    private javax.swing.JTextField formAnno;
    private javax.swing.JTextField formBusqueda;
    private javax.swing.JTextField formDescripcion_averia;
    private javax.swing.JTextField formMatricula;
    private javax.swing.JTextField formModelo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaConsulta;
    // End of variables declaration//GEN-END:variables
}