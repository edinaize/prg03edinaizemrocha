package br.com.ifba.usuario.view;

import br.com.ifba.usuario.entity.Usuario;
import java.awt.Component;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import br.com.ifba.usuario.repository.UsuarioRepository;



public class TelaUsuarioListar extends javax.swing.JFrame {
    
    private final UsuarioRepository repositorio = new UsuarioRepository();
    
    public TelaUsuarioListar() {
        initComponents();
        configurarTabela();
        carregarUsuarios();
    }

    private void configurarTabela() {
        jTable1.getTableHeader().setBackground(new java.awt.Color(10,25,50));
        jTable1.getTableHeader().setForeground(java.awt.Color.WHITE);
        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));

        // Ícone de lápis
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setText("");
                try {
                    label.setIcon(new ImageIcon(getClass().getResource("/br/com/ifba/usuario/imagens/edit.png")));
                } catch(Exception e) {
                  
                }
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        });
        
        // Ícone de lixo
        jTable1.getColumnModel().getColumn(4).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus,int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                label.setText("");
                try {
                    label.setIcon(new ImageIcon(getClass().getResource("/br/com/ifba/usuario/imagens/trash.png")));
                } catch (Exception e) {

                }
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        });
        
        // Oculta, só guarda o id de cada linha
        jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(6).setWidth(0);
    }
    
    // Busca os usuários cadastrados no banco.
    private void carregarUsuarios() {
        try {
            List<Usuario> usuarios = repositorio.listarTodos();
            preencherTabela(usuarios);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(
                    this,"Erro ao carregar usuários: " + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    // Preenche a tabela com os dados dos usuários.
    private void preencherTabela(List<Usuario> usuarios) {
        DefaultTableModel modelo =
                (DefaultTableModel) jTable1.getModel();

        modelo.setRowCount(0);

        for (Usuario usuario : usuarios) {
            modelo.addRow(new Object[]{
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getEmail(),
                "Usuário",
                "",
                "",
                usuario.getId()
            });
        }
    }
    
    private void pesquisarUsuarios() {
        String busca = TextBuscar.getText().trim();

        if (busca.isEmpty() || busca.equals("Digite aqui...")) {
            carregarUsuarios();
            return;
        }

        try {
            preencherTabela(repositorio.buscarPorNome(busca));
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(
                this,"Erro ao buscar usuários: " + e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        TextBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBuscar = new javax.swing.JButton();
        jBtcadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 61, 90));

        TextBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextBuscar.setText("Digite aqui...");
        TextBuscar.addActionListener(this::TextBuscarActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, "", "", null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NOME", "LOGIN", "EMAIL", "TIPO DE PERFIL", "REMOVER", "EDITAR", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("NOME");
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("LOGIN");
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("EMAIL");
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("TIPO DE PERFIL");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("REMOVER");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("EDITAR");
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setHeaderValue("ID");
        }

        jBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/usuario/imagens/search.png"))); // NOI18N
        jBuscar.setText("Buscar");
        jBuscar.addActionListener(this::jBuscarActionPerformed);

        jBtcadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBtcadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/ifba/usuario/imagens/plus.png"))); // NOI18N
        jBtcadastrar.setText("Cadastrar Novo");
        jBtcadastrar.addActionListener(this::jBtcadastrarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtcadastrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBuscar)
                    .addComponent(jBtcadastrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBuscarActionPerformed

    }//GEN-LAST:event_TextBuscarActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        
        pesquisarUsuarios();
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jBtcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtcadastrarActionPerformed
        TelaCadastroUsuario telaCadastro = new TelaCadastroUsuario();
        telaCadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtcadastrarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int linha = jTable1.rowAtPoint(evt.getPoint());
        int coluna = jTable1.columnAtPoint(evt.getPoint());

        if (linha == -1) {
            return;
        }

        long id = ((Number) jTable1.getValueAt(linha, 6)).longValue();

        // Remover usuário
        if (coluna == 4) {
            int resposta = JOptionPane.showConfirmDialog(
                this,"Deseja realmente remover este usuário?","Confirmar exclusão",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    repositorio.excluir(id);
                    JOptionPane.showMessageDialog(
                        this,
                        "Usuário removido com sucesso!"
                    );
                    pesquisarUsuarios();

                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(
                        this,"Erro ao remover usuário: " + e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }

        // Editar usuário
        else if (coluna == 5) {
            Usuario usuario = repositorio.buscarPorId(id);

            if (usuario != null) {
                TelaCadastroUsuario tela = new TelaCadastroUsuario(usuario);
                tela.setVisible(true);
                this.dispose();
            }
        } // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaUsuarioListar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextBuscar;
    private javax.swing.JButton jBtcadastrar;
    private javax.swing.JButton jBuscar;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
