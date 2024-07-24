import java.sql.*;
// DAO = Data Access Object
public class EsempioDAO {

    static final String DB_URL = "jdbc:mysql://localhost:3306/develhope";
    static final String USER = "root";
    static final String PASS = "admin";  // change here with the right password


    /**
     *
     * @param primi
     * @throws SQLException
     * metodo per insierire il primo nel database sql
     */
    public void insertPrimiPiatti(Primi primi) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

        Statement statement = conn.createStatement();

        String populateQuery = ""
                + "insert into Primi (nome,prezzo,descrizione,ingredienti,cottura,regioneProvenienza) "
                + "values ('"+primi.getNome()+"', 30.99, 'Guanciale come sempre', 'Uova,guanciale,pecorino a sentimento', 'Pentola', 'Firenze');";;
        statement.executeUpdate(populateQuery);
        conn.close();
        System.out.println("SuperEroe Creato:");

    }

    public void printAllHeroes() throws SQLException {
        Connection conn = null;

        conn= DriverManager.getConnection(DB_URL,USER,PASS);

        Statement statement = conn.createStatement();

        String printQuery = """
                    select * from superheroes;
                    """;

        ResultSet resultSet = statement.executeQuery(printQuery);

        while(resultSet.next()){
            String name = resultSet.getString("name");
            String team = resultSet.getString("team");
            String power = resultSet.getString("power");

            System.out.print("name:" + name);
            System.out.print("team:" + team);
            System.out.print("power:" + power);
            System.out.println(" ");
        }
    }

    public void updateHeroPower() throws SQLException {
        Connection conn = null;
        conn= DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = conn.createStatement();

        String selectQuery = """
                    select * from superheroes;
                    """;
        ResultSet resultSet = statement.executeQuery(selectQuery);
        String findName = null;

        while(resultSet.next()){
            String name = resultSet.getString("name");
            String team = resultSet.getString("team");
            if (team.equals(TeamsName.XMEN.getTeam())){
                findName = name;
            }
        }
        if(findName != null) {
            String populateQuery = """
                    UPDATE superheroes
                    SET power = 'high'
                    where name = 'findName';
                    """;
            statement.executeUpdate(populateQuery);
            System.out.println("Table updated if find name diverso da null:" + findName);
        }


    }


    public enum TeamsName {

        XMEN("XMEN"),
        FANTASTICI4("FANTASTICI4"),
        FREELANCE("FREELANCE");

        private String team;

        public String getTeam() {
            return team;
        }
        private TeamsName(String team){
            this.team = team;
        }
    }

}
