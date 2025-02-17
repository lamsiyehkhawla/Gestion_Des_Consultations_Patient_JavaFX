package ma.enset.gestionconsultationdb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection con;

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_cabinet","root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
