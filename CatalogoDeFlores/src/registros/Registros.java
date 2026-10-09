/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package registros;

import bean.FlorDAO;
import catalogo.CatalogoFlores;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Julia
 */
public class Registros extends javax.swing.JFrame {
    

    public Registros() {
        initComponents();
        carregarTabela();
        Color verdeFundo = new Color(125, 148, 102);
        getContentPane().setBackground(verdeFundo);
    }
    private void carregarTabela() {

    FlorDAO dao = new FlorDAO();

    ResultSet rs = dao.listar();

    DefaultTableModel modelo =
            (DefaultTableModel) tblPlantas.getModel();

    modelo.setRowCount(0);

    try {

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("nomecientifico"),
                rs.getString("tipo"),
                rs.getString("cor"),
                rs.getDouble("altura"),
                rs.getString("tamanho"),
                rs.getString("necessidadesol"),
                rs.getString("email")
            });
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this,
                "Erro ao carregar plantas: " + e.getMessage());
    }
   }
    private void mostrarFoto() {

    int linha = tblPlantas.getSelectedRow();

    if (linha == -1) {
        lblFoto.setIcon(null);
        return;
    }

    int id = (int) tblPlantas.getValueAt(linha, 0);

    FlorDAO dao = new FlorDAO();

    ResultSet rs = dao.buscarPorId(id);

    try {

        if (rs != null && rs.next()) {

            String caminhoFoto = rs.getString("foto");

            if (caminhoFoto != null && !caminhoFoto.isEmpty()) {

                File arquivo = new File(caminhoFoto);

                if (arquivo.exists()) {

                    ImageIcon imagem = new ImageIcon(caminhoFoto);

                    Image img = imagem.getImage();

                    img = img.getScaledInstance(
                            lblFoto.getWidth(),
                            lblFoto.getHeight(),
                            Image.SCALE_SMOOTH
                    );

                    lblFoto.setIcon(new ImageIcon(img));

                } else {

                    lblFoto.setIcon(null);
                }

            } else {

                lblFoto.setIcon(null);
            }
        }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(this, "Erro ao carregar foto: " + e.getMessage());
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlantas = new javax.swing.JTable();
        txfBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNomePlanta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(85, 107, 47));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPlantas.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblPlantas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Nome científico ", "Tipo", "Cor    ", "Altura ", "Tamanho ", "Necessidade do Sol", "E-mail"
            }
        ));
        tblPlantas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlantasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlantas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 127, 760, 210));

        txfBuscar.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14)); // NOI18N
        getContentPane().add(txfBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 84, 280, 30));

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(102, 102, 102));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 74, 26));

        btnEditar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(102, 102, 102));
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 570, 82, 26));

        btnExcluir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(102, 102, 102));
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.addActionListener(this::btnExcluirActionPerformed);
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 570, 83, 26));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblFoto.setBackground(new java.awt.Color(255, 255, 255));
        lblFoto.setFont(new java.awt.Font("Gadugi", 0, 24)); // NOI18N
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 400, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("--------------------------------------------------------");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 810, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("--------------------------------------------------------");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tela de Registros");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblNomePlanta.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lblNomePlanta.setForeground(new java.awt.Color(255, 255, 255));
        lblNomePlanta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomePlanta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(lblNomePlanta, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 330, 100));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pesquisar Planta:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnVoltar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(102, 102, 102));
        btnVoltar.setText("Voltar");
        btnVoltar.setBorder(null);
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 570, 83, 26));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       String busca = txfBuscar.getText();

       FlorDAO dao = new FlorDAO();
       ResultSet rs = dao.listar();

       DefaultTableModel modelo =
      (DefaultTableModel) tblPlantas.getModel();

       modelo.setRowCount(0);

        try {

        while (rs.next()) {

            String nome = rs.getString("nome");

        if (nome.toLowerCase().contains(busca.toLowerCase())) {

            modelo.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("nomecientifico"),
                rs.getString("tipo"),
                rs.getString("cor"),
                rs.getDouble("altura"),
                rs.getString("tamanho"),
                rs.getString("necessidadesol"),
                rs.getString("email")
            });
        }
    }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(this,
                "Erro ao buscar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

    int linha = tblPlantas.getSelectedRow();

    if (linha == -1) {
        JOptionPane.showMessageDialog(this,
                "Selecione uma planta para editar!");
        return;
    }

    int id = (int) tblPlantas.getValueAt(linha, 0);

    CatalogoFlores tela = new CatalogoFlores(id);

    tela.setVisible(true);

    this.dispose();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
    int linha = tblPlantas.getSelectedRow();

    if (linha == -1) {

        JOptionPane.showMessageDialog(this, "Selecione uma planta para excluir!");

        return;
    }

    int id = (int) tblPlantas.getValueAt(linha, 0);

    int resposta = JOptionPane.showConfirmDialog(
        this,
        "Tem certeza que deseja excluir esta planta?",
        "Confirmar exclusão",
        JOptionPane.YES_NO_OPTION
    );

    if (resposta == JOptionPane.YES_OPTION) {

        FlorDAO dao = new FlorDAO();

        dao.excluir(id);

        JOptionPane.showMessageDialog(this, "Planta excluída com sucesso!");

        carregarTabela();
}
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblPlantasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlantasMouseClicked
    int linha = tblPlantas.getSelectedRow();

        if (linha != -1) {
            String nome = tblPlantas.getValueAt(linha, 1).toString();
            lblNomePlanta.setText(nome);
        }
        mostrarFoto();
    }//GEN-LAST:event_tblPlantasMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        CatalogoFlores cadastro = new CatalogoFlores();
        cadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Registros().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNomePlanta;
    private javax.swing.JTable tblPlantas;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
