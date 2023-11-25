package br.com.fiap.janusGs.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "rm551938";
    private static final String PASS = "080105";

    private static final Logger logger = Logger.getLogger(ConnectionFactory.class.getName());

    private static Connection connection;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Driver JDBC do Oracle não encontrado", e);
            throw new RuntimeException("Driver JDBC do Oracle não encontrado", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
            return connection;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao obter conexão com o banco de dados.", e);
            throw e;
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao fechar a conexão com o banco de dados.", e);
        }
    }
}
