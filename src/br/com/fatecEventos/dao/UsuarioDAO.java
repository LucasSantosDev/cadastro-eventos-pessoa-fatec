/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecEventos.dao;

import br.com.fatecEventos.connection.ConexaoBanco;
import br.com.fatecEventos.model.Usuario;
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
public class UsuarioDAO {

    private static ConexaoBanco con = new ConexaoBanco();

    public ArrayList<Usuario> PesquisarUsuario(Connection con, String select) throws SQLException {
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        ArrayList<Usuario> lista = new ArrayList<>();
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(select);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                lista.add(new Usuario(rs.getInt("id_usuario"), rs.getString("nm_usuario"), rs.getString("senha_usuario"), rs.getString("email_usuario"), rs.getString("caminhoImagem_usuario")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa!", "Status da Pesquisa", 0);//mostra o status
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
            con.close();
            JOptionPane.showMessageDialog(null, "A imagem foi cadastrada com sucesso!", "Status do Cadastro", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro da imagem!", "Status do Cadastro", 0);
        }
    }

}
