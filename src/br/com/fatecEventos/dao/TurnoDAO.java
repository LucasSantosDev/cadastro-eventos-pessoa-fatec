/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecEventos.dao;

import br.com.fatecEventos.connection.ConexaoBanco;
import br.com.fatecEventos.model.Turno;
//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class TurnoDAO {

    private ConexaoBanco con = new ConexaoBanco();
    
    public ArrayList<Turno> PesquisarComboBox(Connection con, String sql) {
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        ArrayList<Turno> lista = new ArrayList<>();
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                lista.add(new Turno(rs.getString("nm_turno")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa!", "Status da Pesquisa", 0);//mostra o status
        }
        return lista;
    }
}
