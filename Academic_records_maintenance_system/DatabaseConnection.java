import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Navan Maphalala
 */

public class DatabaseConnection {
    private static final String DB_NAME = "academic_records";
    private static final String JDBC_URL = "jdbc;mysql://localhost:3306/"+DB_NAME;
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";
    
    private Connection connection;
    
    public DatabaseConnection() {
        try {
//            Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
            if (connection != null) {
                System.out.println("Connected to DB successfully!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver Not Found!");
        } catch (SQLException e) {
            System.err.println("Failed to connect " + e.getMessage());
        }
        
    }
    
//    Method to get the connection
    public Connection getConnection() {
        return connection;
    }
}