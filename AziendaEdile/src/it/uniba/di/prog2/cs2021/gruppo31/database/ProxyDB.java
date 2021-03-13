package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import it.uniba.di.prog2.cs2021.gruppo31.Vendita;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.dado.EsagonaleAlto;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Filettatura;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;
import it.uniba.di.prog2.cs2021.gruppo31.exception.*;

public class ProxyDB implements LogIn_SignIn,UserQuery,AdminQuery {
	
	private String query;
	private Connection conn;
	private static ProxyDB istance = new ProxyDB();
	
	private ProxyDB() {}
	
	public static ProxyDB getIstance() {
		return istance;
	}
	
	public int checkUtente(String username, String hashPassword) throws SQLException {
		query = "SELECT USERNAME,HASH_PASSWORD FROM UTENTE WHERE USERNAME LIKE '" + username + "';";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			return 1; //Username not found
		}
		
		String tempUsername = rs.getString("USERNAME");
		String tempPassword = rs.getString("HASH_PASSWORD");
		
		int result;
		if(tempUsername.equals(username) && tempPassword.equals(hashPassword))
			result = 0; //Username and password match
		else
			result = 2; //Password not correct
		
		ConnectorDB.close(conn);
		return result;
	}
	
	public boolean addUtente(Utente utente) throws SQLException {
		query = "INSERT INTO IMPIEGATO(NOME,COGNOME,DATA_NASCITA,MANSIONE,STIPENDIO,MAX_VENDITE_ANNO,DATA_ENTRATA) VALUES (?,?,?,?,?,?,?);";
		conn = ConnectorDB.connect();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement ps = conn.prepareStatement(query);
		if(utente.getImpiegato().getNome() != null)	ps.setString(1,utente.getImpiegato().getNome());
		if(utente.getImpiegato().getCognome() != null)	ps.setString(2,utente.getImpiegato().getCognome());
		if(utente.getImpiegato().getDataNascita() != null)	ps.setString(3,formatter.format(utente.getImpiegato().getDataNascita()));
		if(utente.getImpiegato().getMansione() != null)	ps.setString(4,utente.getImpiegato().getMansione());
		ps.setInt(5,utente.getImpiegato().getStipendioMensile());
		ps.setInt(6,utente.getImpiegato().getMaxVenditeAnno());
		ps.setString(7,formatter.format(utente.getImpiegato().getDataEntrata()));
		ps.executeUpdate();
		
		query = "SELECT last_insert_rowid();";
		ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		int lastID = rs.getInt(1);
		
		query = "INSERT INTO UTENTE VALUES (?,?,?,?);";
		ps = conn.prepareStatement(query);
		ps.setString(1,utente.getUsername());
		ps.setString(2,utente.getHashPassword());
		ps.setBoolean(3,utente.isAdmin());
		ps.setInt(4,lastID);
		
		int righeInserite = ps.executeUpdate();
		ConnectorDB.close(conn);
		
		if(righeInserite == 0)	return false;
		return true;
	}
	
	public boolean addVendita(Vendita vendita) throws SQLException {
		query = "INSERT INTO VENDITA(UTENTE,DADO,DATA,NUMERO_PEZZI) VALUES (?,?,?,?);";
		conn = ConnectorDB.connect();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,vendita.getUtente().getUsername());
		ps.setString(2,Integer.toString(vendita.getDado().hashCode()));
		ps.setString(3,formatter.format(vendita.getData()));
		ps.setInt(4,vendita.getNumPezzi());

		int righeInserite = ps.executeUpdate();
		ConnectorDB.close(conn);
		
		if(righeInserite == 0)	return false;
		return true;
	}
	
	public Impiegato getInfoImpiegato(String username) throws SQLException,AziendaException,ParseException {
		query = "SELECT * FROM IMPIEGATO WHERE CODICE = (SELECT IMPIEGATO FROM UTENTE WHERE USERNAME = ?);";
		conn = ConnectorDB.connect();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			throw new AziendaException(ErroriDB.USERNAME_NOT_FOUND);
		}
		
		String nome = rs.getString("NOME");
		String cognome = rs.getString("COGNOME");
		Date dataNascita = formatter.parse(rs.getString("DATA_NASCITA"));
		String mansione = rs.getString("MANSIONE");
		int stipendio = rs.getInt("STIPENDIO");
		int maxVenditeAnno = rs.getInt("MAX_VENDITE_ANNO");
		Date dataEntrata = formatter.parse(rs.getString("DATA_ENTRATA"));
		ConnectorDB.close(conn);
		
		Impiegato temp = new Impiegato(nome,cognome,dataNascita,mansione,dataEntrata,stipendio,maxVenditeAnno);
		return temp;
	}
	
	public Filettatura getFilettatura(String metrica, boolean passoGrosso) throws SQLException,AziendaException {
		query = "SELECT * FROM FILETTATURA WHERE METRICA LIKE ? AND PASSO_GROSSO = ?;";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,metrica);
		ps.setBoolean(2,passoGrosso);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			throw new AziendaException(ErroriDB.FILETTATURA_NOT_FOUND);
		}
		
		Filettatura filettatura = new Filettatura(metrica,passoGrosso);
		filettatura.setDimensionePasso(rs.getDouble("DIMENSIONE_PASSO"));
		filettatura.setMisuraPiatti(rs.getDouble("MISURA_PIATTI"));
		filettatura.setAltezza(rs.getDouble("ALTEZZA"));
		
		ConnectorDB.close(conn);
		return filettatura;
	}
		
	public ArrayList<Vendita> getVenditeImpiegato(String username) throws SQLException,AziendaException,ParseException {
		query = "SELECT * FROM VENDITA WHERE UTENTE LIKE ?;";
		conn = ConnectorDB.connect();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			throw new AziendaException(ErroriDB.EMPTY_LIST);
		}
		
		ArrayList<Vendita> vendite = new ArrayList<Vendita>();
		do {
			String tempID = rs.getString("DADO");
			Dado tempDado = getDado(tempID);
			Date tempData = formatter.parse(rs.getString("DATA"));
			int tempNumPezzi = rs.getInt("NUMERO_PEZZI");
			vendite.add(new Vendita(null,tempDado,tempData,tempNumPezzi));
		} while(rs.next() == true);
		
		ConnectorDB.close(conn);
		return vendite;
	}
	
	public ArrayList<Dado> getCatalogoDadi() throws SQLException,AziendaException,ParseException {
		query = "SELECT CODICE_HASH FROM DADO;";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			throw new AziendaException(ErroriDB.EMPTY_LIST);
		}
		
		ArrayList<Dado> catalogo = new ArrayList<Dado>();
		do {
			Dado dado = getDado(rs.getString("CODICE_HASH"));
			catalogo.add(dado);
		} while(rs.next() == true);
		
		ConnectorDB.close(conn);
		return catalogo;
	}
	
	public boolean addDado(String username, Dado dado) throws SQLException,AziendaException {
		if(isAdmin(username) == false)	throw new AziendaException(ErroriDB.USERNAME_NOT_ADMIN);
		
		query = "SELECT CODICE FROM FILETTATURA WHERE METRICA LIKE ? AND PASSO_GROSSO = ?;";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,dado.getFilettatura().getMetrica());
		ps.setBoolean(2,dado.getFilettatura().isPassoGrosso());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			throw new AziendaException(ErroriDB.FILETTATURA_NOT_FOUND);
		}
		
		int codice = rs.getInt(1);
		query = "INSERT INTO DADO VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		ps = conn.prepareStatement(query);
		ps.setString(1,Integer.toString(dado.hashCode()));
		ps.setInt(2,codice);
		ps.setString(3,dado.getMateriale());
		ps.setString(4,dado.getCategoria());
		ps.setString(5,dado.getRivestimentoProtettivo());
		ps.setString(6,dado.getDenominazione());
		
		if(dado.getLuogoProduzione() != null)
			ps.setString(7,dado.getLuogoProduzione());
		else
			ps.setString(7,null);
		if(dado.getDataProduzione() != null)
			ps.setString(8,formatter.format(dado.getDataProduzione()));
		else
			ps.setString(8,null);
		
		ps.setDouble(9,dado.getPeso());
		ps.setDouble(10,dado.getPrezzo());
		ps.setInt(11,dado.getNumPezzi());
		
		int righeInserite = ps.executeUpdate();
		ConnectorDB.close(conn);
		
		if(righeInserite == 0)	return false;
		return true;
	}

	public boolean deleteDado(String username, int hashDado) throws SQLException,AziendaException,ParseException {
		if(isAdmin(username) == false)	throw new AziendaException(ErroriDB.USERNAME_NOT_ADMIN);
		//if(getDado(hashDado) == null)	throw new AziendaException(ErroriDB.DADO_NOT_FOUND);
		
		query = "DELETE FROM DADO WHERE CODICE_HASH LIKE ?;";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,Integer.toString(hashDado));
		int righeRimosse = ps.executeUpdate();
		ConnectorDB.close(conn);
		
		if(righeRimosse == 0)	return false;
		return true;
	}
	
	public boolean updatePezziDado(String username, int hashDado, int numPezzi) throws SQLException,AziendaException {
		if(isAdmin(username) == false)	throw new AziendaException(ErroriDB.USERNAME_NOT_ADMIN);
		
		query = "UPDATE DADO SET NUMERO_PEZZI = ? WHERE CODICE_HASH = ?;";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1,numPezzi);
		ps.setString(2,Integer.toString(hashDado));
		int righeAggiornate = ps.executeUpdate();
		ConnectorDB.close(conn);
		
		if(righeAggiornate == 0)	return false;
		return true;
	}
	
	public boolean updatePrezzoDado(String username, int hashDado, double prezzo) throws SQLException,AziendaException {
		if(isAdmin(username) == false)	throw new AziendaException(ErroriDB.USERNAME_NOT_ADMIN);
		
		query = "UPDATE DADO SET PREZZO = ? WHERE CODICE_HASH = ?;";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setDouble(1,prezzo);
		ps.setString(2,Integer.toString(hashDado));
		int righeAggiornate = ps.executeUpdate();
		ConnectorDB.close(conn);
		
		if(righeAggiornate == 0)	return false;
		return true;
	}
	
	private Filettatura getFilettaturaByID(int codice) throws SQLException,AziendaException {
		query = "SELECT * FROM FILETTATURA WHERE CODICE = ?;";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1,codice);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			throw new AziendaException(ErroriDB.FILETTATURA_NOT_FOUND);
		}
		
		Filettatura filettatura = new Filettatura(rs.getString("METRICA"),rs.getBoolean("PASSO_GROSSO"));
		filettatura.setDimensionePasso(rs.getDouble("DIMENSIONE_PASSO"));
		filettatura.setMisuraPiatti(rs.getDouble("MISURA_PIATTI"));
		filettatura.setAltezza(rs.getDouble("ALTEZZA"));
		
		ConnectorDB.close(conn);
		return filettatura;
	}

	private Dado getDado(String hashDado) throws SQLException,AziendaException,ParseException {
		query = "SELECT * FROM DADO WHERE CODICE_HASH LIKE ?;";
		conn = ConnectorDB.connect();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,hashDado);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			throw new AziendaException(ErroriDB.DADO_NOT_FOUND);
		}
		
		Dado dado = new EsagonaleAlto();
		dado.setMateriale(rs.getString("MATERIALE"));
		dado.setCategoria(rs.getString("CATEGORIA"));
		dado.setRivestimentoProtettivo(rs.getString("RIVESTIMENTO"));
		
		Filettatura filettatura = getFilettaturaByID(rs.getInt("FILETTATURA"));
		dado.setFilettatura(filettatura.getMetrica(),filettatura.isPassoGrosso());
		dado.setNumPezzi(rs.getInt("NUMERO_PEZZI"));
		dado.setPrezzo(rs.getDouble("PREZZO"));
		dado.setLuogoProduzione(rs.getString("LUOGO_PRODUZIONE"));
		dado.setDataProduzione(formatter.parse(rs.getString("DATA_PRODUZIONE")));
		
		ConnectorDB.close(conn);
		return dado;
	}
	
	private boolean isAdmin(String username) throws SQLException,AziendaException {
		query = "SELECT ADMIN FROM UTENTE WHERE USERNAME LIKE ?;";
		conn = ConnectorDB.connect();
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next() == false)
		{
			ConnectorDB.close(conn);
			throw new AziendaException(ErroriDB.USERNAME_NOT_FOUND);
		}
		
		boolean result = rs.getBoolean(1);
		ConnectorDB.close(conn);
		return result;
	}
}
