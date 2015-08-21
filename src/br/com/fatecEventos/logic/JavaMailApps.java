package br.com.fatecEventos.logic;

import br.com.fatecEventos.connection.ConexaoBanco;
import br.com.fatecEventos.dao.EventoDAO;
import br.com.fatecEventos.dao.ItemDAO;
import br.com.fatecEventos.model.Item;
import br.com.fatecEventos.dao.PessoaDAO;
import br.com.fatecEventos.model.Evento;
import br.com.fatecEventos.model.Pessoa;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class JavaMailApps {

    private static Pessoa pessoa = new Pessoa();
    private static ArrayList<Pessoa> pessoas = new ArrayList();
    private static PessoaDAO pessoaDAO = new PessoaDAO();
    private static ArrayList<Item> item = new ArrayList();
    private static ItemDAO itemDAO = new ItemDAO();
    private static Item itemModel = new Item();
    private static Connection con;
    private static ConexaoBanco conexaoBanco = new ConexaoBanco();
    private static Evento eventoModelo = new Evento();
    private static EventoDAO eventoDAO;
    private static ArrayList<Evento> arrayEventos = new ArrayList<>();
    private static ArrayList<Evento> arrayEventos2 = new ArrayList<>();
    private static String nomeEvento = "";

    public JavaMailApps() throws SQLException {
        enviarHotmail();
    }

    public static void enviarHotmail() throws SQLException {

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Hotmail
         */
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("seuemail", "suasenha");
                    }
                });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("seuemail")); //Remetente  

            arrayEventos = eventoDAO.PesquisarComboBox(con, "SELECT * FROM tb_evento WHERE nm_evento = '" + verificaEvento() + "'");
            int cont = 0;
            int idEvento = 0;
            while (arrayEventos.size() > cont) {
                idEvento = arrayEventos.get(cont).getCodigo();
                cont++;
            }
            
            item = itemDAO.PesquisarItem(con, "SELECT * FROM tb_item_evento_pessoa WHERE id_evento = '" + idEvento + "'");
            int idPessoa = 0;
            cont = 0;
            while (item.size() > cont) {
                idPessoa = item.get(cont).getIdPessoa();
                cont++;
            }
            
            pessoas = pessoaDAO.PesquisarPessoaEmail(con, "SELECT * FROM tb_pessoa WHERE id_pessoa = '" + idPessoa + "'");
            cont = 0;
            while (pessoas.size() > cont) {
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(pessoas.get(cont).getEmailPessoa())); //Destinatário(s)  
                message.setSubject("Fatec Eventos");//Assunto  
                message.setText("Ei, psiu! Hoje tem o incrivel evento " + verificaEvento() + " não se esqueça de comparecer!!!");
                /**
                 * Método para enviar a mensagem criada
                 */
                Transport.send(message);
                cont++;
            }

        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível enviar os Emails.");
        }
    }

    public static String verificaEvento() throws SQLException {
        eventoDAO = new EventoDAO();
        arrayEventos2 = eventoDAO.PesquisarComboBox(con, "SELECT * FROM tb_evento");
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String novaData = formatador.format(data);
        int cont = 0;
        while (arrayEventos2.size() > cont) {
            if (arrayEventos2.get(cont).getDataEvento().equals(novaData)) {
                nomeEvento = arrayEventos2.get(cont).getNomeEvento().toString();
            } else {

            }

            cont++;
        }
        return nomeEvento;
    }

}
