package daos;



import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection{
    public static final String dbUrl = "jdbc:mysql://localhost:3306/FF7";
    public static final String username = "matt";
    public static final String password = "zipcode0";
    static Logger demoLog =  Logger.getLogger("JDBC");


    public static java.sql.Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }



    public static void main(String[] args) throws SQLException {
        demoLog.log(Level.INFO, "somestuff");
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");

        FF7DAO dao = FF7DAO.getInstance();
        java.sql.Connection conn = null;
        try{
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connection Established to MYSQL Database");
            dao.create(new DTO("", "", 0, 0, 0, "", ""));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.out.println("Connection Failed! Check output console");

        }
        finally {
            try
            {
                if(conn != null)
                    conn.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}
