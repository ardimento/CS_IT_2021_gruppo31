package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.*;

/**
 * Classe che si occupa dell'apertura e della chiusura della connessione al database.
 * @author matteo
 * @version 1.1
 */
public class ConnectorDB {
	
	/** Stringa di connessione contenente il path del database. */
	private static String url = "jdbc:sqlite:sqlite3/schema.db";

	/**
	 * Metodo statico che si occupa di aprire una connessione verso il database.
	 * @return Oggetto Connection istaziato attraverso l'url di connessione del database.
	 * @throws SQLException
	 * @see Connection
	 * @see DriverManager#getConnection(String)
	 */
	public static Connection connect() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url);
		return conn;
	}
	
	/**
	 * Metodo statico che si occupa di chiudere una connessione verso il database.<br>
	 * Questo metodo può essere invocato dopo l'apertura della connessione con il metodo {@link ConnectorDB#connect()}
	 * @param conn Oggetto Connection contenente la connessione da chiuedere.
	 * @throws SQLException
	 * @see Connection
	 */
	public static void close(Connection conn) throws SQLException {
		if(conn != null)	conn.close();
	}
}