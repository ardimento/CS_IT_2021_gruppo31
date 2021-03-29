package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.*;

/**
 * classe che si occupa di funzioni primarie di un database
 * @author andrea
 * @version 1.1
 */
public class ConnectorDB {
	
	private static String url = "jdbc:sqlite:sqlite3/schema.db";

	/**
	 * @return  La connessione ad uno specifico database
	 * @throws SQLException
	 */
	public static Connection connect() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url);
		return conn;
	}
	
	/**
	 * 
	 * @param conn connessione
	 * @throws SQLException
	 */
	public static void close(Connection conn) throws SQLException {
		if(conn != null)	conn.close();
	}
}