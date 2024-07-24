import java.sql.*;

public class BevandeDAO {
    static final String DB_URL = "jdbc:mysql://localhost:3306/develhope";
    static final String USER = "root";
    static final String PASS = "admin";  // change here with the right password


    /**
     * @param bevande
     * @throws SQLException metodo per inserire la bevanda nel database sql
     */
    public void insertBevande(Bevande bevande) throws SQLException {
        // crea la connessione
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        // crea lo statement
        Statement statement = conn.createStatement();
        // inizializza la query
        String populateQuery = ""
                + "insert into Bevande (nome, prezzo, descrizione, ingredienti, anno_di_produzione, certificazione_DOP) "
                + "values ('" + bevande.getNome() + "', " + bevande.getPrezzo() + ", '" + bevande.getDescrizione()
                + "', '" + bevande.getIngredienti() + "', '" + bevande.getAnnoDiProduzione() + "', '" + bevande.getCertificazioneDOP() + "');";
        // esegue la query
        statement.executeUpdate(populateQuery);
        // chiude la connessione
        conn.close();
        // messaggio finale
        System.out.println("Bevanda aggiunta al database");
    }

    public void printAllBevande() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = conn.createStatement();

        String printQuery = """
                select * from Bevande;
                """;

        ResultSet resultSet = statement.executeQuery(printQuery);

        while (resultSet.next()) {
            String nome = resultSet.getString("nome");
            Double prezzo = resultSet.getDouble("prezzo");
            String descrizione = resultSet.getString("descrizione");
            String ingredienti = resultSet.getString("ingredienti");
            String annoDiProduzione = resultSet.getString("anno_di_produzione");
            Boolean certificazioneDOP = resultSet.getBoolean("certificazione_DOP");
            // copio dal metodo stampaDettagli

            System.out.print('\n' + nome + " ");
            // inseriamo i puntini
            Integer puntini = 40 - nome.length();
            for(int i = 0; i<= puntini; i++ ){
                System.out.print(".");
            }

            System.out.println(prezzo + "€");
            System.out.println(descrizione);
            System.out.println(ingredienti);

            System.out.println("Prodotto nell'anno " + annoDiProduzione);
            if (certificazioneDOP) {
                System.out.println("Prodotto con certificazione DOP");
            }
        }

        conn.close();
    }

    public void updateHeroPower() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String selectQuery = """
                select * from superheroes;
                """;
        ResultSet resultSet = statement.executeQuery(selectQuery);
        String findName = null;

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String team = resultSet.getString("team");
            if (team.equals(EsempioDAO.TeamsName.XMEN.getTeam())) {
                findName = name;
            }
        }
        if (findName != null) {
            String populateQuery = """
                    UPDATE superheroes
                    SET power = 'high'
                    where name = 'findName';
                    """;
            statement.executeUpdate(populateQuery);
            System.out.println("Table updated if find name diverso da null:" + findName);
        }


    }
}
