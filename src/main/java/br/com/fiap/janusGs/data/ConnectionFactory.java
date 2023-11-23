package br.com.fiap.janusGs.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException {
		String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	    String USER = "rm551938";
	    String PASS = "080105";
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    return DriverManager.getConnection(URL, USER, PASS);
	    } catch(ClassNotFoundException e) {
		      e.getMessage();
	    }
		return null;
    }
}
