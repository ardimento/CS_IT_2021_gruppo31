package it.uniba.di.prog2.cs2021.gruppo31.dado;
import java.sql.SQLException;
import java.util.Date;

public interface Dado {
	
	public String getDenominazione();
	public String getMateriale();
	public boolean setMateriale(String materiale);
	public String getCategoria();
	public boolean setCategoria(String categoria);
	public String getRivestimentoProtettivo();
	public boolean setRivestimentoProtettivo(String rivestimento);
	public Filettatura getFilettatura();
	public String getFilettaturaString();
	public boolean setFilettatura(String metrica, boolean passoGrosso) throws SQLException;
	public double getPeso();
	public int getNumPezzi();
	public boolean setNumPezzi(int numPezzi);
	public double getPrezzo();
	public boolean setPrezzo(double prezzo);
	public String getLuogoProduzione();
	public void setLuogoProduzione(String luogoProduzione);
	public Date getDataProduzione();
	public void setDataProduzione(Date dataProduzione);
	public int hashCode();
	public boolean equals(Object obj);
	public String toString();
}
