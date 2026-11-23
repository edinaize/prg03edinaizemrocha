package br.com.ifba.artista.view;

import br.com.ifba.artista.controller.ArtistaIController;
import br.com.ifba.artista.entity.Artista;
import br.com.ifba.infrastructure.exception.DaoException;
import br.com.ifba.usuario.controller.UsuarioIController;
import br.com.ifba.usuario.view.TelaCadastroUsuario;
import java.awt.Component;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;



public class TelaArtistaListar extends javax.swing.JFrame {
    // Controller responsável pelo acesso aos dados do usuário 
    private final UsuarioIController usuarioController;
    private final ArtistaIController artistaController;
    
    public TelaArtistaListar(UsuarioIController usuarioController, ArtistaIController controller) {
        this.usuarioController = usuarioController;
        this.artistaController = controller;
        initComponents();
        configurarTabela();
        carregarArtistas();
    }

    private void configurarTabela() {
        tblArtistas.getTableHeader().setBackground(new java.awt.Color(10,25,50));
        tblArtistas.getTableHeader().setForeground(java.awt.Color.WHITE);
        tblArtistas.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));

        // Ícone de lápis
        tblArtistas.getColumnModel().getColumn(5).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
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
        tblArtistas.getColumnModel().getColumn(4).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
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
        tblArtistas.getColumnModel().getColumn(6).setMinWidth(0);
        tblArtistas.getColumnModel().getColumn(6).setMaxWidth(0);
        tblArtistas.getColumnModel().getColumn(6).setWidth(0);
    }
    
     private void carregarArtistas() {
        try {
            preencherTabela(artistaController.findAll());
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(
                    this, "Erro ao carregar artistas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Preenche a tabela com os dados dos artistas.
    private void preencherTabela(List<Artista> artistas) {
        DefaultTableModel modelo =
                (DefaultTableModel) tblArtistas.getModel();

        modelo.setRowCount(0);

        for (Artista artista : artistas) {
            modelo.addRow(new Object[]{
                artista.getNome(),
                artista.getLogin(),
                artista.getEstilo(),
                artista.getLocalizacao(),
                "",
                "",
                artista.getId()
            });
        }
    }

    private void pesquisarArtistas() {
        String busca = TextBuscar.getText().trim();

        if (busca.isEmpty() || busca.equals("Digite aqui...")) {
            carregarArtistas();
            return;
        }

        try {
            // categoria nula = todas as categorias
            preencherTabela(artistaController.pesquisar(busca, null));
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(
                this, "Erro ao buscar artistas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jPanel1 = new javax.swing.JPanel();
        TextBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArtistas = new javax.swing.JTable();
        jBuscar = new javax.swing.JButton();
        jBtcadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(4, 61, 90));

        TextBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextBuscar.setText("Digite aqui...");
        TextBuscar.addActionListener(this::TextBuscarActionPerformed);

        tblArtistas.setModel(new javax.swing.table.DefaultTableModel(
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
                "NOME", "LOGIN", "ESTILO", "LOCALIZAÇÂO", "REMOVER", "EDITAR", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArtistas.setRowHeight(35);
        tblArtistas.setShowGrid(false);
        tblArtistas.setShowHorizontalLines(true);
        tblArtistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArtistasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArtistas);
        if (tblArtistas.getColumnModel().getColumnCount() > 0) {
            tblArtistas.getColumnModel().getColumn(0).setResizable(false);
            tblArtistas.getColumnModel().getColumn(0).setHeaderValue("NOME");
            tblArtistas.getColumnModel().getColumn(1).setResizable(false);
            tblArtistas.getColumnModel().getColumn(1).setHeaderValue("LOGIN");
            tblArtistas.getColumnModel().getColumn(2).setResizable(false);
            tblArtistas.getColumnModel().getColumn(2).setHeaderValue("EMAIL");
            tblArtistas.getColumnModel().getColumn(3).setResizable(false);
            tblArtistas.getColumnModel().getColumn(3).setHeaderValue("TIPO DE PERFIL");
            tblArtistas.getColumnModel().getColumn(4).setHeaderValue("REMOVER");
            tblArtistas.getColumnModel().getColumn(5).setHeaderValue("EDITAR");
            tblArtistas.getColumnModel().getColumn(6).setResizable(false);
            tblArtistas.getColumnModel().getColumn(6).setHeaderValue("ID");
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
        
        pesquisarArtistas();
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jBtcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtcadastrarActionPerformed
        TelaCadastroUsuario telaCadastro = new TelaCadastroUsuario(usuarioController, artistaController);
        telaCadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtcadastrarActionPerformed

    private void tblArtistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArtistasMouseClicked
        int linha = tblArtistas.rowAtPoint(evt.getPoint());
        int coluna = tblArtistas.columnAtPoint(evt.getPoint());

        if (linha == -1) {
            return;
        }

        long id = ((Number) tblArtistas.getValueAt(linha, 6)).longValue();

        // Remover artista
        if (coluna == 4) {
            int resposta = JOptionPane.showConfirmDialog(
                this,"Deseja realmente remover este artista?","Confirmar exclusão",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                try {
                    artistaController.delete(id);
                    JOptionPane.showMessageDialog(this, "Artista removido com sucesso!");
                    pesquisarArtistas();
                } catch (DaoException e) {
                    JOptionPane.showMessageDialog(
                        this, "Erro ao remover artista: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Editar artista
        else if (coluna == 5) {
            Artista artista = artistaController.findById(id);

            if (artista != null) {
                TelaArtistaCadastro tela = new TelaArtistaCadastro(usuarioController, artistaController, artista);
                tela.setVisible(true);
                this.dispose();
            }
        } // TODO add your handling code here:
    }//GEN-LAST:event_tblArtistasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextBuscar;
    private javax.swing.JButton jBtcadastrar;
    private javax.swing.JButton jBuscar;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblArtistas;
    // End of variables declaration//GEN-END:variables

}
