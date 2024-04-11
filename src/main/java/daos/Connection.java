package daos;



import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    public static final String dbUrl = "jdbc:mysql://localhost:3306/FF7";
    public static final String username = "matt";
    public static final String password = "zipcode0";

    /**
     * Get a connection to database
     *
     * @return Connection object
     */
    public static java.sql.Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public void resultSet() throws SQLException {
        java.sql.Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from ff7");
    }

    /**
     * Test Connection
     */
    public static void main(String[] args) throws SQLException {
        java.sql.Connection conn = Connection.getConnection();
        try{
            conn = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("Connection Established to MYSQL Database");

        } catch (SQLException e) {

            System.err.println(e.getMessage());

        } finally {

            conn.close();

        }

    }

}
