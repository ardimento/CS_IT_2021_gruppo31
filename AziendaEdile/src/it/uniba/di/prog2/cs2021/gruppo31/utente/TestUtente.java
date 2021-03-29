package it.uniba.di.prog2.cs2021.gruppo31.utente;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Assert;
import org.junit.Test;

/**
 * Classe di test per il package {@link it.uniba.di.prog2.cs2021.gruppo31.utente}.<br>
 * Vengono effettuati alcuni test sul funzionamento delle classi all'interno del package.<br>
 * Nota: per effettuare i test è necessario importare la libreria esterna JUnit 5.
 * @author marco
 * @version 1.1
 */
public class TestUtente {
	
	@Test
	public static void UtenteTest() {
		Date dataprova = new Date(System.currentTimeMillis());
		boolean flag = false;
		
		Impiegato i = new Impiegato("marco","Deggi",dataprova,"impiegato",dataprova,1200,500);
		Utente u = new Utente(i,"username","password",flag);
		
		//Assert
		Assert.assertNotNull(i);
		Assert.assertNotNull(u);
	}
	
	@Test
	public static void ImpiegatoTest() {
		Date dataprova = new Date(System.currentTimeMillis());
		Impiegato i = new Impiegato("marco","Deggi",dataprova,"impiegato",dataprova,1200,500);
		
		//Assert
		Assert.assertNotNull(i);
	}
	
	@Test
	public static void CheckImpiegatoTest() {
		DateFormat datauno = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
		DateFormat datadue = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
		Date Datadinascita = null;
		Date datafirma = null;
		
		try {
			Datadinascita= datauno.parse("10/10/2000");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			datafirma= datadue.parse("10/10/2020");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Impiegato i = new Impiegato("marco","deggi",Datadinascita,"impiegato",datafirma,1400,1000);
		
		//Assert
		Assert.assertTrue(Utility_Utente.checkImpiegato(i) == 0);	
	}
	
	@Test
	public static void addUtenteTest() throws SQLException, AziendaException {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Impiegato impiegato1 = new Impiegato("Matteo","Costa",formatter.parse("19/04/2000"),"Magazzino",formatter.parse("12/11/2020"),1200,500);
			String username = "matteo.costa";
			String password = "password1";
			
			if(Utility_Utente.checkImpiegato(impiegato1) == 0);
			else
				throw new AziendaException();
			
			if(Utility_Utente.checkCorrettezzaCredenziali(username,password) == 0);
			else
				throw new AziendaException();
			
			Utente utente1 = new Utente(impiegato1,username,password,true);
			utente1.addUtente();
			
			//Assert
			Assert.assertNotNull(utente1);
			
		} catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
}