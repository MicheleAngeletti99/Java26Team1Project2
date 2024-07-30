import java.sql.*;

public class AntipastiDAO {
    static final String DB_URL = "jdbc:mysql://localhost:3306/progetto_ristorante";
    static final String USER = "root";
    static final String PASS = "";  // change here with the right password


    /**
     *
     * @param antipasti
     * @throws SQLException
     * metodo per insierire il primo nel database sql
     */
    public void insertAntipasti(Antipasti antipasti) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

        Statement statement = conn.createStatement();

        String populateQuery = ""
                + "insert into Primi (nome,prezzo,descrizione,ingredienti,origineProdotto) "
                + "values ('"+antipasti.getNome()+"', Bruschette, 5.99, pane tostato e pomodoro, pane, pomodoro, olio, aglio,Pomodori e aglio originari dalla Sicilia, pane di nostra produzione');"
                + "('"+antipasti.getNome()+"', Misto caldo, 8.99, patatine fritte, arancine fritte e panelle fritte, patate, farina di ceci, palle di riso fritte, Prodotti originari dal tipo streetFood Siciliano');"
                + "('"+antipasti.getNome()+"', Polenta fritta, 10.55, polenta fritta servita con funghi, farina di mais e funghi, Prodotti e tipo di piatto originario dalla Toscana');";

        statement.executeUpdate(populateQuery);
        conn.close();
        System.out.println("Antipasti inseriti:");

    }

    public void printAllAntipasti() throws SQLException {
        Connection conn = null;

        conn= DriverManager.getConnection(DB_URL,USER,PASS);

        Statement statement = conn.createStatement();

        String printQuery = """
                    select * from antipasti;
                    """;

        ResultSet resultSet = statement.executeQuery(printQuery);

        while(resultSet.next()){
            String nome = resultSet.getString("nome");
            String prezzo = resultSet.getString("prezzo");
            String descrizione = resultSet.getString("descrizione");
            String ingredienti = resultSet.getString("ingredienti");
            String origineProdotto = resultSet.getString("origineProdotto");

            System.out.print("nome: " + nome);
            System.out.print("prezzo: " + prezzo);
            System.out.print("descrizione: " + descrizione);
            System.out.print("ingredienti: " + ingredienti);
            System.out.print("origineProdotto: " + origineProdotto);
            System.out.println(" ");
        }
    }

    public void updateAntipasti(Antipasti antipasto) throws SQLException {
        Connection conn = null;
        conn= DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = conn.createStatement();

        String selectQuery = """
                    select * from antipasti;
                    """;
        ResultSet resultSet = statement.executeQuery(selectQuery);
        String findName = null;

        while(resultSet.next()){
            String nome = resultSet.getString("nome");
            if (nome.equals(antipasto.getNome())){
                findName = nome;
            }
        }
        if(findName != null) {
            String populateQuery = """
                    UPDATE antipasti
                    SET nome = ?
                    where nome = 'findName';
                    """;
            statement.executeUpdate(populateQuery);
            System.out.println("Aggiornato il nome:" + findName);
        }
    }
}

