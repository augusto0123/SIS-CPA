package fai.cpa.connection;
import java.sql.*;

public class ConectionFactory {

    private static Connection connection = null;

    // Arrumar a url com o nome do seu banco
    // colcoar a mesma senha de User e Password de: postgres

    private static final String URL = "jdbc:postgresql://localhost:5432/db-cms";

    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public ConectionFactory() {
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("[Database] Error during database connection");
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(PreparedStatement preparedStatement, Connection connection, ResultSet resultSet) {
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
        closeResultSet(resultSet);
    }

    public static void close(PreparedStatement preparedStatement, Connection connection) {
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
    }

    private static void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement == null) {
            return;
        }

        try {
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet == null) {
            return;
        }

        try {
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
