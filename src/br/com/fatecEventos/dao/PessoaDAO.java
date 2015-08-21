/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecEventos.dao;

import br.com.fatecEventos.connection.ConexaoBanco;
import br.com.fatecEventos.model.Pessoa;
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
public class PessoaDAO {

    private ConexaoBanco con = new ConexaoBanco();

    public int PesquisarUltimaPessoa(Connection con) throws SQLException {
        String select = "SELECT * FROM tb_pessoa WHERE id_pessoa = (SELECT max(id_pessoa) FROM tb_pessoa)";
        Pessoa pessoa = new Pessoa();
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        int codigo = 0;
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(select);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                pessoa.setCodigo(rs.getInt("id_pessoa"));
                codigo = rs.getInt("id_pessoa");
                pessoa.setNomePessoa(rs.getString("nm_pessoa"));
                pessoa.setEmailPessoa(rs.getString("email_pessoa"));
                pessoa.setDataPessoa(rs.getString("dtNasc_pessoa"));
                pessoa.setCursoPessoa(rs.getString("curso_pessoa"));
                pessoa.setContribuicao(rs.getString("contribuicao_pessoa"));
                pessoa.setTurnoPessoa(rs.getString("turno_pessoa"));
                pessoa.setCicloPessoa(rs.getInt("ciclo_pessoa"));
                pessoa.setCaminhoImagem(rs.getString("caminho_imagem"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return codigo;
    }

    public ArrayList<Pessoa> PesquisarPessoa(Connection con, String nome) throws SQLException {
        String select = "SELECT * FROM tb_pessoa WHERE nm_pessoa = '" + nome + "'";
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        ArrayList<Pessoa> lista = new ArrayList<>();
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(select);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                lista.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nm_pessoa"), rs.getString("email_pessoa"), rs.getString("dtNasc_pessoa"), rs.getString("curso_pessoa"), rs.getString("contribuicao_pessoa"), rs.getString("turno_pessoa"), rs.getInt("ciclo_pessoa"), rs.getString("caminho_imagem")));
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
            JOptionPane.showMessageDialog(null, "O cadastro foi atualizado com sucesso!", "Status do Cadastro", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a atualização!", "Status do Cadastro", 0);
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Pessoa> PesquisarTodosOsRegistros(Connection con) throws SQLException {
        String select = "SELECT * FROM tb_pessoa";
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        ArrayList<Pessoa> lista = new ArrayList<>();
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(select);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                lista.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nm_pessoa"), rs.getString("email_pessoa"), rs.getString("dtNasc_pessoa"), rs.getString("curso_pessoa"), rs.getString("contribuicao_pessoa"), rs.getString("turno_pessoa"), rs.getInt("ciclo_pessoa"), rs.getString("caminho_imagem")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa!", "Status da Pesquisa", 0);//mostra o status
        }
        return lista;
    }

    public ArrayList<Pessoa> PesquisarPessoaEmail(Connection con, String sql) throws SQLException {
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        ArrayList<Pessoa> lista = new ArrayList<>();
        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                lista.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nm_pessoa"), rs.getString("email_pessoa"), rs.getString("dtNasc_pessoa"), rs.getString("curso_pessoa"), rs.getString("contribuicao_pessoa"), rs.getString("turno_pessoa"), rs.getInt("ciclo_pessoa"), rs.getString("caminho_imagem")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a pesquisa!", "Status da Pesquisa", 0);//mostra o status
        }
        return lista;
    }

    public void CadastrarPessoa(Connection con, Pessoa pessoa) {
        try {
            con = this.con.conexao();
        } catch (SQLException ex) {
            System.out.println("Erro ao passar conexão");
        }
        String insertValores = "INSERT INTO tb_pessoa VALUES (?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement st = (PreparedStatement) con.prepareStatement(insertValores)) {

            Statement stmt = (Statement) con.createStatement();
            String selectMaiorCodigo = "SELECT MAX(id_pessoa) FROM tb_pessoa";
            ResultSet rs = (ResultSet) stmt.executeQuery(selectMaiorCodigo);
            rs.next();
            int proximoCodigo = rs.getInt(1) + 1;
            rs.close();

            st.setInt(1, proximoCodigo);
            st.setString(2, pessoa.getNomePessoa());
            st.setString(3, pessoa.getEmailPessoa());
            st.setString(4, pessoa.getDataPessoa());
            st.setString(5, pessoa.getCursoPessoa());
            st.setString(6, pessoa.getContribuicao());
            st.setString(7, pessoa.getTurnoPessoa());
            st.setInt(8, pessoa.getCicloPessoa());
            st.setString(9, pessoa.getCaminhoImagem());

            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "A pessoa foi cadastrada com sucesso!", "Status do Cadastro", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro!", "Status do Cadastro", 0);
        }
    }
}
