package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    public ConnectionDB connectionDB = new ConnectionDB();
    public SQL sql = new SQL();

    public DAO(){

    }

    public ResultSet getPersons() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        if(connectionDB.isConnect()){
            Statement st = connectionDB.getConnection().createStatement();
            return st.executeQuery(sql.getPersons());
        }
        return null;
    }
}
