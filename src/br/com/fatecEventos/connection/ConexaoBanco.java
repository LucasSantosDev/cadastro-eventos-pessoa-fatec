package br.com.fatecEventos.connection;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class ConexaoBanco {

    private Connection con;

    public Connection conexao() throws SQLException {
        try {
            try {
                //Class.forName("org.sqlite.JDBC").newInstance();
                Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            } catch (Exception d) {
                System.out.println("Driver não carregado");
                System.out.println(d.getStackTrace());
            }
            try {
                //con = (Connection) DriverManager.getConnection("jdbc:sqlite:mydb.sqlite", "root", "");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
                System.out.println("Conexão Estabelecida - 1");
            } catch (Exception er) {
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "123");
                System.out.println("Conexão Estabelecida - 2");
            }
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        } finally {
            return con;
        }
    }
}
