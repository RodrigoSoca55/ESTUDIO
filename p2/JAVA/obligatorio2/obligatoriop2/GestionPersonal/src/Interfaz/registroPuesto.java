package Interfaz;

import Dominio.Sistema;
import Dominio.Tematica;
import Exceptions.Exception_DuplicateName;
import Exceptions.Exception_StringVacio;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class registroPuesto extends javax.swing.JPanel {

    private Sistema modelo;
    DefaultListModel<Tematica> Lmodelo = new DefaultListModel<>();

    
    public registroPuesto() {
        initComponents();
    }

    public registroPuesto(Sistema modelo) {
        this.modelo = modelo;
        initComponents();
        buttonGroup2.add(jRbMixto);
        buttonGroup2.add(jRbPresencial);
        buttonGroup2.add(jRbRemoto);
        buttonGroup2.clearSelection();
        jLabelException.setVisible(false);
        for (int i = 0; i < modelo.getListaTematicas().size(); i++) {
            jCbTematicas.addItem(modelo.getListaTematicas().get(i));
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRbRemoto = new javax.swing.JRadioButton();
        jRbMixto = new javax.swing.JRadioButton();
        jRbPresencial = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCbTematicas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLTematica = new javax.swing.JList<>();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jTfPuesto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBRegistrar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLabelException = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(850, 880));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Puesto:");
        add(jLabel1);
        jLabel1.setBounds(50, 100, 90, 20);

        jRbRemoto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRbRemoto.setText("Remoto");
        jRbRemoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbRemotoActionPerformed(evt);
            }
        });
        add(jRbRemoto);
        jRbRemoto.setBounds(230, 160, 120, 25);

        jRbMixto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRbMixto.setText("Mixto");
        add(jRbMixto);
        jRbMixto.setBounds(680, 160, 110, 25);

        jRbPresencial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRbPresencial.setText("Presencial");
        jRbPresencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRbPresencialActionPerformed(evt);
            }
        });
        add(jRbPresencial);
        jRbPresencial.setBounds(450, 160, 130, 25);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Formato:");
        add(jLabel8);
        jLabel8.setBounds(50, 160, 90, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Temas Requeridos");
        add(jLabel9);
        jLabel9.setBounds(50, 220, 150, 20);

        add(jCbTematicas);
        jCbTematicas.setBounds(220, 220, 440, 22);

        jScrollPane1.setViewportView(jLTematica);

        add(jScrollPane1);
        jScrollPane1.setBounds(220, 320, 570, 94);

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });
        add(jBAgregar);
        jBAgregar.setBounds(660, 220, 120, 23);

        jBEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        add(jBEliminar);
        jBEliminar.setBounds(50, 320, 140, 27);

        jTfPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfPuestoActionPerformed(evt);
            }
        });
        add(jTfPuesto);
        jTfPuesto.setBounds(220, 100, 570, 22);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro puesto");
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 20));
        add(jLabel2);
        jLabel2.setBounds(0, 30, 850, 25);

        jBRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBRegistrar.setText("Registrar");
        jBRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarActionPerformed(evt);
            }
        });
        add(jBRegistrar);
        jBRegistrar.setBounds(620, 500, 160, 27);

        jBCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });
        add(jBCancelar);
        jBCancelar.setBounds(50, 490, 140, 27);

        jLabelException.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jLabelException.setText("jLabel4");
        add(jLabelException);
        jLabelException.setBounds(220, 430, 370, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void jRbRemotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbRemotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRbRemotoActionPerformed

    private void jRbPresencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRbPresencialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRbPresencialActionPerformed

    private void jTfPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfPuestoActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // TODO add your handling code here:
        if (!Lmodelo.contains(jCbTematicas.getSelectedItem())) {
            jLTematica.setModel(Lmodelo);
            Lmodelo.addElement((Tematica) jCbTematicas.getSelectedItem());
        }

    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarActionPerformed
        // TODO add your handling code here:
        borderPainted(false);
        jTfPuesto.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        jLTematica.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        Border border = BorderFactory.createLineBorder(Color.RED, 2);
        String formato = obtenerStringRB();
        try {
            if (!Lmodelo.isEmpty()) {
            modelo.registrarPuesto(jTfPuesto.getText(), formato);
                for (int i = 0; i < Lmodelo.getSize(); i++) {
                    modelo.getListaPuestos().get(modelo.getListaPuestos().size() - 1).getListaRequerimientos().add(Lmodelo.get(i));
                }
                jTfPuesto.setText("");
                jRbRemoto.setSelected(false);
                jRbPresencial.setSelected(false);
                jRbMixto.setSelected(false);
                Lmodelo.clear();
            }else{
                jLTematica.setBorder(border);
            }

        } catch (Exception_StringVacio ex) {
            if (jTfPuesto.getText().equals("")) {
                jTfPuesto.setBorder(border);
            }
            if (formato.equals("")) {
                borderPainted(true);
                jRbMixto.setBorder(border);
                jRbPresencial.setBorder(border);
                jRbRemoto.setBorder(border);
            }
            jLabelException.setVisible(true);
            jLabelException.setText("Complete las áreas indicadas");

        } catch (Exception_DuplicateName ex) {
            JOptionPane.showMessageDialog(null, "El puesto que ingreso ya se encuentra registrado");
        }


    }//GEN-LAST:event_jBRegistrarActionPerformed

    private void borderPainted(boolean b) {
        jRbMixto.setBorderPainted(b);
        jRbPresencial.setBorderPainted(b);
        jRbRemoto.setBorderPainted(b);
        jLabelException.setVisible(b);
    }
    private String obtenerStringRB(){
        String formato = "";
        if (jRbRemoto.isSelected()) {
            formato = "Remoto";
        } else if (jRbPresencial.isSelected()) {
            formato = "Presencial";
        } else if (jRbMixto.isSelected()) {
            formato = "Mixto";
        }
        return formato;
    }

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        jTfPuesto.setText("");
        jRbRemoto.setSelected(false);
        jRbPresencial.setSelected(false);
        jRbMixto.setSelected(false);
        Lmodelo.clear();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        Lmodelo.remove(jCbTematicas.getSelectedIndex());
    }//GEN-LAST:event_jBEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBRegistrar;
    private javax.swing.JComboBox<Tematica> jCbTematicas;
    private javax.swing.JList<Tematica> jLTematica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelException;
    private javax.swing.JRadioButton jRbMixto;
    private javax.swing.JRadioButton jRbPresencial;
    private javax.swing.JRadioButton jRbRemoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTfPuesto;
    // End of variables declaration//GEN-END:variables

}
