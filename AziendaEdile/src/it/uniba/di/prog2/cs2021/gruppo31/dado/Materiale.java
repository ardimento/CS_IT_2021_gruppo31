package it.uniba.di.prog2.cs2021.gruppo31.dado;

/**
 * Enumerazione contenente tutti i tipi di materiale disponibili per un dado.
 * <p>
 * La sigla accanto al materiale (incisa sul dado) indica la classe di resistenza, ossia
 * rappresenta la resistenza alla rottura, la quale si misura in MPa (Mega Pascal) e va moltiplicato x100.
 * @author matteo
 * @version 1.1
 */
public enum Materiale {
	Acciaio_5,
	Acciaio_8,
	Acciaio_10,
	AcciaioInox_A2,
	AcciaioInox_A4,
	Ottone_OT58,
	Ottone_OT63;
}
