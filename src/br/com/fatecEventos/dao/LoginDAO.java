/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecEventos.dao;

import br.com.fatecEventos.connection.ConexaoBanco;
import br.com.fatecEventos.model.Usuario;
import br.com.fatecEventos.views.Principal;
import java.io.IOException;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class LoginDAO {

    private static ConexaoBanco con;

    public int PesquisarUsuario(Connection con, Usuario usuario) throws IOException {
        System.out.println("LoginDAO");
        int valorRetorno = 0;
        this.con = new ConexaoBanco();
        try {
            con = (Connection) this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexão");
        }
        String selectUsuario = "SELECT * FROM tb_usuario";

        try (Statement stmt = (Statement) con.createStatement()) {
            ResultSet rs = (ResultSet) stmt.executeQuery(selectUsuario);
            String nomeBanco = "";
            String senhaBanco = "";
            while (rs.next()) {
                nomeBanco = rs.getString("nm_usuario");
                senhaBanco = rs.getString("senha_usuario");
                if (nomeBanco.equals(usuario.getNome()) && senhaBanco.equals(usuario.getSenha())) {
                    Principal principal = new Principal();
                    principal.nomeUsuario(rs.getInt("id_usuario"), nomeBanco, senhaBanco, rs.getString("email_usuario"), rs.getString("caminhoImagem_usuario"));
                    principal.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login/Senha incorreto(s)!");
                    valorRetorno = 1;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o login!", "Status da Pesquisa", 0);
            System.out.println(ex.getMessage());
            valorRetorno = 1;
        }
        return valorRetorno;
    }
}
