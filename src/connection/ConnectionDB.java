package connection;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    private static final String DRIVER = "org.postgresql.Driver";
    private static Connection connect;
    private static final String URL = "jdbc:postgresql://192.168.43.61:5432/distribuidos";
    private static final String USER = "postgres";
    private static final String PASS = "22mayo";

    public ConnectionDB(){
    }

    public boolean isConnect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        try {
            Class.forName(DRIVER).newInstance();
            connect = DriverManager.getConnection(URL, USER, PASS);
            return true;
        } catch (PSQLException e) {
            return false;
        }
    }

    public Connection getConnection(){
        return connect;
    }
}
