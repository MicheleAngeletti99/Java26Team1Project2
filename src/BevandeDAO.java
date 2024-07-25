import java.sql.*;

public class BevandeDAO {
    static final String DB_URL = "jdbc:mysql://localhost:3306/progetto_ristorante";
    static final String USER = "root";
    static final String PASS = "";  // change here with the right password


    // metodo per inserire una bevanda nel database
    public void insertBevande(Bevande bevande) throws SQLException {
        // creo la connessione
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        // creo lo statement
        Statement statement = conn.createStatement();
        // inizializzo la query per l'insert
        String populateQuery = "insert into bevande (nome, prezzo, descrizione, ingredienti, anno_di_produzione, certificazione_DOP) "
                + "values ('" + bevande.getNome() + "', " + bevande.getPrezzo() + ", '" + bevande.getDescrizione()
                + "', '" + bevande.getIngredienti() + "', '" + bevande.getAnnoDiProduzione() + "', " + bevande.getCertificazioneDOP() + ");";
        // eseguo la query
        statement.executeUpdate(populateQuery);
        // chiudo la connessione
        conn.close();
        // messaggio finale
        System.out.println("\nBevanda aggiunta al database");
    }

    // metodo per stampare tutte le bevande del database
    public void printAllBevande() throws SQLException {
        // creo la connessione
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        // creo lo statement
        Statement statement = conn.createStatement();
        // inizializzo la query
        String printQuery = """
                select * from bevande;
                """;
        // eseguo la query e salvo il risultato
        ResultSet resultSet = statement.executeQuery(printQuery);
        // stampo il risultato
        while (resultSet.next()) {
            // salvo i valori dal risultato
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
        // chiudo la connessione
        conn.close();
    }

    // metodo per aggiornare una bevanda nel database
    // Attenzione: funziona solo se il nome non è stato modificato e se non ci sono nomi duplicati
    public void updateBevande(Bevande updatedBevande) throws SQLException {
        // creo la connessione
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        // creo lo statement
        Statement statement = conn.createStatement();
        // inizializzo la query per la select
        String selectQuery = """
                select * from bevande;
                """;
        // eseguo la query select e salvo il risultato
        ResultSet resultSet = statement.executeQuery(selectQuery);
        // inizializzo una variabile per cercare l'oggetto da modificare
        boolean isThere = false;
        // controllo tutte le righe ricavate dalla select
        while (resultSet.next()) {
            // salvo il nome e lo confronto con la bevanda modificata
            String nome = resultSet.getString("nome");
            if (nome.equals(updatedBevande.getNome())) {
                // se ne trovo una con il nome uguale me lo salvo
                isThere = true;
            }
        }
        // se l'ho trovato nel database, faccio l'update
        if (isThere) {
            // inizializzo la stringa per l'update
            String populateQuery = " UPDATE bevande SET prezzo = " + updatedBevande.getPrezzo() +
                    ", descrizione = '" + updatedBevande.getDescrizione() + "', ingredienti = '" + updatedBevande.getIngredienti() + "', " +
                    "anno_di_produzione = '" + updatedBevande.getAnnoDiProduzione() + "', certificazione_DOP =" +
                    updatedBevande.getCertificazioneDOP() + " where nome = '" + updatedBevande.getNome() + "';";
            // eseguo la query di update
            statement.executeUpdate(populateQuery);
            // messaggio finale
            System.out.println("\nBevanda modificata correttamente");
        }
        // chiudo la connessione
        conn.close();
    }

    // metodo per creare la relazione tra una bevanda ed un menu
    // Attenzione: funziona solo se le bevande non hanno nomi duplicati e se i menu non hanno tipi duplicati
    public void relateBevandeMenu(Bevande bevande, Menu menu) throws SQLException {
        // creo la connessione
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        // creo lo statement
        Statement statement = conn.createStatement();
        // inizializzo la query per la select delle bevande
        String selectQuery = """
                select * from bevande;
                """;
        // eseguo la query select e salvo il risultato
        ResultSet resultSet = statement.executeQuery(selectQuery);
        // inizializzo una variabile per cercare la bevanda da relazionare
        boolean isThereB = false;
        // controllo tutte le righe ricavate dalla select
        while (resultSet.next()) {
            // salvo il nome e lo confronto con la bevanda da relazionare
            String nome = resultSet.getString("nome");
            if (nome.equals(bevande.getNome())) {
                // se ne trovo una con il nome uguale me lo salvo
                isThereB = true;
            }
        }
        // faccio la stessa cosa per il menu da relazionare
        // inizializzo la query per la select dei menu
         selectQuery = """
                select * from menu;
                """;
        // eseguo la query select e salvo il risultato
        resultSet = statement.executeQuery(selectQuery);
        // inizializzo una variabile per cercare l'id del menu da relazionare
        Integer menuId = null;
        // controllo tutte le righe ricavate dalla select
        while (resultSet.next()) {
            // salvo il tipo e lo confronto con il menu da relazionare
            String tipo = resultSet.getString("tipo_menu");
            if (tipo.equals(menu.getTipo().getStringTipo())) {
                // se ne trovo uno con il tipo uguale mi salvo l'id
                menuId = resultSet.getInt("id");
            }
        }
        // se trovo sia la bevanda che il menu faccio la relazione
        if(isThereB && menuId != null){
            // inizializzo la stringa per l'update
            String populateQuery = " UPDATE bevande SET menu_id = " + menuId + ";";
            // eseguo la query di update
            statement.executeUpdate(populateQuery);
            // messaggio finale
            System.out.println("\nRelazione effettuata correttamente");
        }
        // chiudo la connessione
        conn.close();
    }
}
