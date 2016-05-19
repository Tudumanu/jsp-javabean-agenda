package tadeu.agenda;

import java.sql.*;
import java.util.ArrayList;

public class DadosBean {
    private Connection connection;

    public DadosBean(){
        try {
            Class.forName("org.postgresql.Driver"); //verifica se existe a classe do driver JDBC - classNotFoundException

            //tenta conectar ao banco - SQLException
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/agenda", "postgres", "postgres");
        } catch (Exception e) {
            System.err.println("Falha ao conectar ao banco de dados." + e);
            e.printStackTrace();
        }
    }

    public void adicionarContato(ContatoBean c) {
        String sql = "INSERT INTO contato(id, nome, telefone, email) " +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, c.getId());
            preparedStatement.setString(2, c.getNome());
            preparedStatement.setString(3, c.getTelefone());
            preparedStatement.setString(4, c.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.err.println("Falha ao adicionarContato." + e);
            e.printStackTrace();
        }
    }

    public void removerContato(int id) {
        String sql = "DELETE FROM contato WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.err.println("Falha ao removerContato." + e);
            e.printStackTrace();
        }
    }

    public ArrayList<ContatoBean> listarTodosContatos() {
        String sql = "SELECT id, nome, telefone, email FROM contato";
        ArrayList<ContatoBean> lista = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                ContatoBean contato = new ContatoBean();
                contato.setId(resultSet.getInt(1));
                contato.setNome(resultSet.getString(2));
                contato.setTelefone(resultSet.getString(3));
                contato.setEmail(resultSet.getString(4));
                lista.add(contato);
            }

            statement.close();
        } catch (Exception e) {
            System.err.println("Falha ao listarTodosContatos." + e);
            e.printStackTrace();
        }

        return lista;
    }

    public ArrayList<ContatoBean> buscarContatos(String nome) {
        String sql = "SELECT id, nome, telefone, email FROM contato WHERE nome ILIKE ?";
        ArrayList<ContatoBean> lista = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, '%'+ nome +'%');
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                ContatoBean contato = new ContatoBean();
                contato.setId(resultSet.getInt(1));
                contato.setNome(resultSet.getString(2));
                contato.setTelefone(resultSet.getString(3));
                contato.setEmail(resultSet.getString(4));
                lista.add(contato);
            }

            preparedStatement.close();
        } catch (Exception e) {
            System.err.println("Falha ao buscarContatos." + e);
            e.printStackTrace();
        }

        return lista;
    }
}
