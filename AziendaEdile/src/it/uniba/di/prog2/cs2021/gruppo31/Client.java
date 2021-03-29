package it.uniba.di.prog2.cs2021.gruppo31;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.dado.EsagonaleAlto;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utility_Utente;

class Client {

	public static void main(String[] args) {
		
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
			
			Utility_Utente.checkUtente(utente1.getUsername(),utente1.getHashPassword()); //LogIn
			HomePage hp = new HomePage(utente1);
			
			Dado dado1 = new EsagonaleAlto();
			dado1.setCategoria("A");
			dado1.setFilettatura("M16",false);
			dado1.setMateriale("Acciaio_8");
			dado1.setNumPezzi(10);
			dado1.setPrezzo(0.13);
			dado1.setRivestimentoProtettivo("Nessuno");
			dado1.setDataProduzione(formatter.parse("12/12/2001"));
			dado1.setLuogoProduzione("Spagna");
			
			Dado dado2 = new EsagonaleAlto();
			dado2.setCategoria("A");
			dado2.setFilettatura("M20",true);
			dado2.setMateriale("Acciaio_10");
			dado2.setNumPezzi(90);
			dado2.setPrezzo(0.50);
			dado2.setRivestimentoProtettivo("Brunitura");
			dado2.setDataProduzione(formatter.parse("12/08/2011"));
			dado2.setLuogoProduzione("Italia");
			
			hp.addDado(dado1);
			hp.addDado(dado2);
			ArrayList<Dado> catalogo = hp.getCatalogoDadi();
			
			System.out.println("+++++++++ CATALOGO DADI +++++++++");
			for(int i=0;i<catalogo.size();i++)
			{
				System.out.println(catalogo.get(i));
				System.out.println();
			}
			
			System.out.println("+++++++++ IMPIEGATO +++++++++");
			System.out.println(hp.getInfoImpiegato());
			System.out.println();
			
			Vendita vendita1 = new Vendita(utente1,dado1,formatter.parse("12/11/2020"),5);
			Vendita vendita2 = new Vendita(utente1,dado1,formatter.parse("13/11/2020"),5);
			hp.addVendita(vendita1);
			hp.addVendita(vendita2);
			
			catalogo = hp.getCatalogoDadi();
			System.out.println("+++++++++ CATALOGO DADI +++++++++");
			for(int i=0;i<catalogo.size();i++)
			{
				System.out.println(catalogo.get(i));
				System.out.println();
			}
			
			ArrayList<Vendita> vendite = hp.getVenditeImpiegato();
			System.out.println("+++++++++ LISTA VENDITE +++++++++");
			for(int i=0;i<catalogo.size();i++)
			{
				System.out.println(vendite.get(i).getDado().getDenominazione());
				System.out.println(formatter.format(vendite.get(i).getData()));
				System.out.println(vendite.get(i).getNumPezzi());
				System.out.println();
			}
			
			hp.deleteDado(dado1.hashCode());
			catalogo = hp.getCatalogoDadi();
			System.out.println("+++++++++ CATALOGO DADI +++++++++");
			for(int i=0;i<catalogo.size();i++)
			{
				System.out.println(catalogo.get(i));
				System.out.println();
			}
			
			hp.updatePezziDado(dado2.hashCode(),50);
			hp.updatePrezzoDado(dado2.hashCode(),0.22);
			catalogo = hp.getCatalogoDadi();
			System.out.println("+++++++++ CATALOGO DADI +++++++++");
			for(int i=0;i<catalogo.size();i++)
			{
				System.out.println(catalogo.get(i));
				System.out.println();
			}
			
			vendite = hp.getVenditeImpiegato();
			System.out.println("+++++++++ LISTA VENDITE +++++++++");
			for(int i=0;i<catalogo.size();i++)
			{
				System.out.println(vendite.get(i).getDado().getDenominazione());
				System.out.println(formatter.format(vendite.get(i).getData()));
				System.out.println(vendite.get(i).getNumPezzi());
				System.out.println();
			}
			
			hp.logOut();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			//System.out.print(e.getMessage());
		}
	}
}
