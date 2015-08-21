/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecEventos.dao;

import br.com.fatecEventos.connection.ConexaoBanco;
import br.com.fatecEventos.model.Evento;
//import static com.sun.corba.se.impl.util.Utility.printStackTrace;
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
public class EventoDAO {

    private ConexaoBanco con = new ConexaoBanco();

    public void CadastrarEvento(Connection con, Evento evento) throws SQLException {
         con = this.con.conexao();
        String insertValores = "INSERT INTO tb_evento VALUES (?,?,?)";
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(insertValores)) {

            Statement stmt = (Statement) con.createStatement();
            String selectMaiorCodigo = "SELECT MAX(id_evento) FROM tb_evento";
            ResultSet rs = (ResultSet) stmt.executeQuery(selectMaiorCodigo);
            rs.next();
            int proximoCodigo = rs.getInt(1) + 1;
            rs.close();

            st.setInt(1, proximoCodigo);
            st.setString(2, evento.getNomeEvento());
            st.setString(3, evento.getDataEvento());

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "O evento foi cadastrado com sucesso!", "Status do Cadastro", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro!", "Status do Cadastro", 0);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Evento> PesquisarComboBox(Connection con, String sql) throws SQLException {
        System.out.println("EventoDAO");
        ArrayList<Evento> lista = new ArrayList<>();
        System.out.println("aqui1");
        try (PreparedStatement st = (PreparedStatement) this.con.conexao().prepareStatement(sql)) {
            System.out.println("aqui2");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(new Evento(rs.getInt("id_evento"), rs.getString("nm_evento"), rs.getString("dt_evento")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa!", "Status da Pesquisa", 0);//mostra o status
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
            con.close();
            JOptionPane.showMessageDialog(null, "O cadastro foi atualizado com sucesso!", "Status do Cadastro", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a atualização!", "Status do Cadastro", 0);
        }
    }

    public void ExcluirEvento(Connection con, Object parametro) {
    }
}
