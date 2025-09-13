import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/college_admission";
        String user = "root";
        String pass = "danish"; // Use your MySQL password
        return DriverManager.getConnection(url, user, pass);
    }
}
