package dao;

import connection.ConnectionFactory;
import model.Comenzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class ComenziDAO extends AbstractDAO<Comenzi>{
    /***
     * metoda ajutatoare insert in comenzi
     * @param value
     * @return
     */
    public String insertQuery(String value) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO comenzi(comenzi.client, comenzi.product, comenzi.quantity) ");
        sb.append(" VALUES (" + value + ");");
        return sb.toString();
    }
    /***
     * metoda insert in comenzi
     * @param
     * @return
     */
    public int insertNewOrder(Object object) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String value = formatForString(object);
        String query = insertQuery(value);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            int y = statement.executeUpdate(query);

            return y;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return 0;
    }

}
