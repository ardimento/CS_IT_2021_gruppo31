package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import it.uniba.di.prog2.cs2021.gruppo31.Vendita;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;

public interface UserQuery {
	public boolean addVendita(Vendita vendita) throws SQLException;
	public Impiegato getInfoImpiegato(String username) throws SQLException,AziendaException,ParseException;
	public ArrayList<Vendita> getVenditeImpiegato(String username) throws SQLException,AziendaException,ParseException;
	public ArrayList<Dado> getCatalogoDadi() throws SQLException,AziendaException,ParseException;
}
