/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecEventos.dao;

import br.com.fatecEventos.connection.ConexaoBanco;
import br.com.fatecEventos.model.Item;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class ItemDAO {
    
    private ConexaoBanco con = new ConexaoBanco();

    public void CadastrarItem(Connection con, Item item) {
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        String insertValores = "INSERT INTO tb_item_evento_pessoa VALUES (?,?,?)";
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(insertValores)) {

            Statement stmt = (Statement) con.createStatement();
            String selectMaiorCodigo = "SELECT MAX(id_item) FROM tb_item_evento_pessoa";
            ResultSet rs = (ResultSet) stmt.executeQuery(selectMaiorCodigo);
            rs.next();
            int proximoCodigo = rs.getInt(1) + 1;
            rs.close();

            st.setInt(1, proximoCodigo);
            st.setInt(2, item.getIdPessoa());
            st.setInt(3, item.getIdEvento());

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Item> PesquisarItem(Connection con, String sql) {
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        ArrayList<Item> lista = new ArrayList<>();
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                lista.add(new Item(rs.getInt("id_item"), rs.getInt("id_pessoa"), rs.getInt("id_evento")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    public void UpdateDados(Connection con, String update) {
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate(update);
            JOptionPane.showMessageDialog(null, "O cadastro foi atualizado com sucesso!", "Status do Cadastro", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a atualização!", "Status do Cadastro", 0);
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
}
//