/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecEventos.views;

import br.com.fatecEventos.connection.ConexaoBanco;
import br.com.fatecEventos.dao.EventoDAO;
import br.com.fatecEventos.dao.ItemDAO;
import br.com.fatecEventos.dao.PessoaDAO;
import br.com.fatecEventos.model.Evento;
import br.com.fatecEventos.model.Item;
import br.com.fatecEventos.model.Pessoa;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author lucas
 */
public class PesquisarPessoa extends javax.swing.JDialog {

    private Pessoa pessoa = new Pessoa();
    private ItemDAO itemDAO = new ItemDAO();
    private ArrayList<Pessoa> pessoas = new ArrayList();
    private ArrayList<Evento> arrayEventos = new ArrayList();
    private ArrayList<Item> item = new ArrayList();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private EventoDAO eventoDAO = new EventoDAO();
    private Connection con;
    private ConexaoBanco conexaoBanco = new ConexaoBanco();
    private static String nmEvento = "";

    /**
     * Creates new form PesquisarPessoa
     */
    public PesquisarPessoa() throws SQLException, IOException {
        initComponents();
        setLocationRelativeTo(null);
        String path = new File(".").getCanonicalPath();
        String nf = path.replace("dist", "");
        String arqCam = nf + "\\src\\br\\com\\fatecEventos\\images\\icone_JFrame.png";
        ImageIcon icone = new ImageIcon(arqCam);
        setIconImage(icone.getImage());
        con = conexaoBanco.conexao();
        this.setModal(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPessoa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisarPessoa = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnTodosOsRegistros = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("fatecEventos 1.0");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PESQUISAR PESSOA");
        jLabel1.setOpaque(true);

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fatecEventos/images/Botao_Cancelar.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        tPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Email", "Data Nascimento", "Curso", "Contribuicao", "Turno", "Ciclo", "Evento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPessoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tPessoa);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Digite o nome:");

        txtPesquisarPessoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPesquisarPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarPessoaKeyPressed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fatecEventos/images/Menu_Pesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPesquisarPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisarPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnTodosOsRegistros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fatecEventos/images/Botao_TodosOsRegistros.png"))); // NOI18N
        btnTodosOsRegistros.setText("Todos os Registros");
        btnTodosOsRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosOsRegistrosActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fatecEventos/images/Botao_Salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTodosOsRegistros)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFechar, btnSalvar, btnTodosOsRegistros});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvar)
                    .addComponent(btnTodosOsRegistros))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnFechar, btnSalvar, btnTodosOsRegistros});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtPesquisarPessoaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarPessoaKeyPressed
        int tecla = evt.getKeyCode();
        if (tecla == KeyEvent.VK_ENTER) {
            try {
                pesquisaPessoa();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_txtPesquisarPessoaKeyPressed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            pesquisaPessoa();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnTodosOsRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosOsRegistrosActionPerformed
        TodosRegistros todosRegistros = null;
        try {
            try {
                todosRegistros = new TodosRegistros();
            } catch (IOException ex) {
                Logger.getLogger(PesquisarPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        todosRegistros.setVisible(true);
        
    }//GEN-LAST:event_btnTodosOsRegistrosActionPerformed

    private void tPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPessoaMouseClicked
        if (tPessoa.getSelectedRow() != -1) {
            btnSalvar.setEnabled(true);
        } else {
            btnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_tPessoaMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int linha = 0;
        int coluna = 0;
        if (tPessoa.getSelectedRow() != -1) {
            linha = tPessoa.getSelectedRow();
            coluna = tPessoa.getSelectedColumn();
            try {
                setValueChanged(linha, coluna);
                //chama método que verifica se os dados da linha selecionada foram modificados
            } catch (SQLException ex) {
                Logger.getLogger(PesquisarPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não selecionou");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int tecla = evt.getKeyCode();
        if (tecla == KeyEvent.VK_ESCAPE) {
            try {
                this.dispose();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formKeyPressed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PesquisarPessoa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PesquisarPessoa.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(PesquisarPessoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnTodosOsRegistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable tPessoa;
    private static javax.swing.JTextField txtPesquisarPessoa;
    // End of variables declaration//GEN-END:variables

    private void pesquisaPessoa() throws SQLException {
        pessoas = pessoaDAO.PesquisarPessoa(con, txtPesquisarPessoa.getText());
        int idPessoa = 0;
        int cont = 0;
        while (pessoas.size() > cont) {
            idPessoa = pessoas.get(cont).getCodigo();
            cont++;
        }

        item = itemDAO.PesquisarItem(con, "SELECT * FROM tb_item_evento_pessoa WHERE id_pessoa = '" + idPessoa + "'");
        int idEvento = 0;
        cont = 0;
        while (item.size() > cont) {
            idEvento = item.get(cont).getIdEvento();
            cont++;
        }

        arrayEventos = eventoDAO.PesquisarComboBox(con, "SELECT * FROM tb_evento WHERE id_evento = '" + idEvento + "'");
        cont = 0;
        while (arrayEventos.size() > cont) {
            this.nmEvento = arrayEventos.get(cont).getNomeEvento();
            cont++;
        }

        atualizarTabela(pessoas);
        setResultados();
    }

    public void setValueChanged(int rowIndex, int columnIndex) throws SQLException {
        String modelColuna = tPessoa.getColumnName(columnIndex).toString();
        String codigo = (String) tPessoa.getValueAt(rowIndex, 0).toString();
        String valorLinhaColuna = (String) tPessoa.getValueAt(rowIndex, columnIndex).toString();
        String valorLinhaColunaNome = (String) tPessoa.getValueAt(rowIndex, 1).toString();
        String nmVariavelBd = "";
        //"Nome", "Email", "Data Nascimento", "Curso", "Turno", "Ciclo", "Evento"
        if (modelColuna.equals("Nome")) {
            nmVariavelBd = "nm_pessoa";
        } else if (modelColuna.equals("Email")) {
            nmVariavelBd = "email_pessoa";
        } else if (modelColuna.equals("Data Nascimento")) {
            nmVariavelBd = "dtNasc_pessoa";
        } else if (modelColuna.equals("Curso")) {
            nmVariavelBd = "curso_pessoa";
        }  else if (modelColuna.equals("Contribuicao")) {
            nmVariavelBd = "contribuicao_pessoa";
        } else if (modelColuna.equals("Turno")) {
            nmVariavelBd = "turno_pessoa";
        } else if (modelColuna.equals("Ciclo")) {
            nmVariavelBd = "ciclo_pessoa";
        } else if (modelColuna.equals("Evento")) {
            nmVariavelBd = "id_evento";
        }

        if (nmVariavelBd.equals("id_evento")) {
            //String nm = "SELECT id_pessoa FROM tb_pessoa WHERE nm_pessoa = '" + valorLinhaColunaNome + "'";
            pessoas = pessoaDAO.PesquisarPessoa(con, valorLinhaColunaNome);
            int cont = 0;
            int id = 0;
            while (pessoas.size() > cont) {
                id = pessoas.get(cont).getCodigo();
                cont++;
            }
            String cd_item = "SELECT * FROM tb_item_evento_pessoa WHERE id_pessoa = " + id;
            System.out.println(cd_item);
            item = itemDAO.PesquisarItem(con, cd_item);
            cont = 0;
            int codigoI = 0;
            while (item.size() > cont) {
                codigoI = item.get(cont).getIdItem();
                cont++;
            }
            System.out.println(codigoI);
            String sql = "UPDATE tb_item_evento_pessoa SET " + nmVariavelBd + " = (SELECT id_evento FROM tb_evento WHERE nm_evento = '" + valorLinhaColuna + "') WHERE id_item = " + codigoI;
            itemDAO.UpdateDados(con, sql);
        } else {
            String sql = "UPDATE tb_pessoa SET " + nmVariavelBd + " = '" + valorLinhaColuna + "' WHERE id_pessoa = " + codigo;
            pessoaDAO.UpdateDados(con, sql);
        }
    }

    private void atualizarTabela(ArrayList<Pessoa> pessoas) {
        tPessoa.setModel(new javax.swing.table.DefaultTableModel(new Object[pessoas.size()][pessoas.size()], new String[]{
            "Codigo", "Nome", "Email", "Data Nascimento", "Curso", "Contribuicao", "Turno", "Ciclo", "Evento"}));
    }

    private void setResultados() {
        TableCellRenderer tcr = new br.com.fatecEventos.views.AlinharCentro();
        TableColumn column = tPessoa.getColumnModel().getColumn(0);
        TableColumn column2 = tPessoa.getColumnModel().getColumn(1);
        TableColumn column3 = tPessoa.getColumnModel().getColumn(2);
        TableColumn column4 = tPessoa.getColumnModel().getColumn(3);
        TableColumn column5 = tPessoa.getColumnModel().getColumn(4);
        TableColumn column6 = tPessoa.getColumnModel().getColumn(5);
        TableColumn column7 = tPessoa.getColumnModel().getColumn(6);
        TableColumn column8 = tPessoa.getColumnModel().getColumn(7);
        TableColumn column9 = tPessoa.getColumnModel().getColumn(8);
        column.setCellRenderer(tcr);
        column2.setCellRenderer(tcr);
        column3.setCellRenderer(tcr);
        column4.setCellRenderer(tcr);
        column5.setCellRenderer(tcr);
        column6.setCellRenderer(tcr);
        column7.setCellRenderer(tcr);
        column8.setCellRenderer(tcr);
        column9.setCellRenderer(tcr);
        int cont = 0;
        while (pessoas.size() > cont) {
            tPessoa.setValueAt(pessoas.get(cont).getCodigo(), cont, 0);
            tPessoa.setValueAt(pessoas.get(cont).getNomePessoa(), cont, 1);
            tPessoa.setValueAt(pessoas.get(cont).getEmailPessoa(), cont, 2);
            tPessoa.setValueAt(pessoas.get(cont).getDataPessoa(), cont, 3);
            tPessoa.setValueAt(pessoas.get(cont).getCursoPessoa(), cont, 4);
            tPessoa.setValueAt(pessoas.get(cont).getContribuicao(), cont, 5);
            tPessoa.setValueAt(pessoas.get(cont).getTurnoPessoa(), cont, 6);
            tPessoa.setValueAt(pessoas.get(cont).getCicloPessoa(), cont, 7);
            tPessoa.setValueAt(this.nmEvento, cont, 8);
            cont++;
        }
    }

    class AlinharCentro extends DefaultTableCellRenderer {

        public AlinharCentro() {
            setHorizontalAlignment(CENTER); // ou LEFT, RIGHT, etc
        }
    }

}