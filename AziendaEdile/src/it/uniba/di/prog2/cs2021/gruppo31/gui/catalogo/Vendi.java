package it.uniba.di.prog2.cs2021.gruppo31.gui.catalogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.Vendita;
import it.uniba.di.prog2.cs2021.gruppo31.dado.AbstractDado;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.dado.EsagonaleAlto;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Filettatura;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Materiale;
import it.uniba.di.prog2.cs2021.gruppo31.dado.RivestimentoProtettivo;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.gui.Form_Signin_1;
import it.uniba.di.prog2.cs2021.gruppo31.gui.Home;

@SuppressWarnings("rawtypes")
public class Vendi extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	//private JTable table;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	
	@SuppressWarnings("unchecked")
	public Vendi(HomePage home){
		
		setSize(500, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		
		//pannelo scrollabile
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//PANNELLO DI DEFAULT
		JPanel pannellodefault = new JPanel();
		pannellodefault.setForeground(new Color(0, 0, 128));
		pannellodefault.setBackground(new Color(240, 230, 140));
		pannellodefault.setBorder(null);
		pannellodefault.setLayout(null);
		setContentPane(pannellodefault);
		pannellodefault.add(contentPane);
		
		//PULSANTE INDIETRO
		JButton btn_indietro= new JButton("indietro");
		btn_indietro.setForeground(Color.WHITE);
		btn_indietro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_indietro.setBackground(new Color(178, 34, 34));
		btn_indietro.setBounds(425, 263, 65, 25);
		pannellodefault.add(btn_indietro);
		
		btn_indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home(home);
			}
		});
		
		//PULSANTE X
		JButton btn_x = new JButton("X");
		btn_x.setSize(new Dimension(10, 10));
		btn_x.setFont(new Font("Dialog", Font.BOLD, 10));
		btn_x.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_x.setBackground(new Color(255, 51, 0));
		btn_x.setBounds(460, 0, 42, 23);
		btn_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pannellodefault.add(btn_x);
		
		
		//PULSANTE VENDI DADO
		JButton btn_vendidado= new JButton("VENDI!");
		btn_vendidado.setForeground(Color.WHITE);
		btn_vendidado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_vendidado.setBackground(new Color(0, 153, 51));
		btn_vendidado.setBounds(380, 125, 70, 30);
		pannellodefault.add(btn_vendidado);
		
		btn_vendidado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkVendita(home);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (AziendaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 12, 320, 276);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		pannellodefault.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(320, 400));
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(panel);
		
		JLabel lblFilettatura = new JLabel("Filettatura:");
		lblFilettatura.setBounds(20, 20, 81, 15);
		panel.add(lblFilettatura);
		
		//LISTE DEI PRODOTTI 
		//Filettatura
		try {
			ArrayList<Filettatura> array = ProxyDB.getIstance().getAllFilettatura();
			String entry[] = new String[array.size()];
			for(int i=0;i<array.size();i++) {
				entry[i] = array.get(i).getMetrica() + " ";
				entry[i] += (array.get(i).isPassoGrosso() ? "- Passo Grosso" : "- Passo Fine");
			}
			
			comboBox = new JComboBox(entry);
			comboBox.setBackground(Color.WHITE);
			comboBox.setBounds(20, 40, 250, 30);
			panel.add(comboBox);
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
		}
		
		JLabel lblLuogoProduzione = new JLabel("Codice dado:");
		lblLuogoProduzione.setBounds(20, 80, 134, 15);
		panel.add(lblLuogoProduzione);
		
		JLabel lblDataDiProduzione = new JLabel("Data di vendita:");
		lblDataDiProduzione.setBounds(20, 140, 141, 15);
		panel.add(lblDataDiProduzione);
		
		JLabel label_5 = new JLabel("Prezzo:");
		label_5.setBounds(20, 200, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Numero pezzi:");
		label_6.setBounds(140, 200, 102, 15);
		panel.add(label_6);
		

		lblFilettatura.setBounds(20, 20, 81, 15);
		panel.add(lblFilettatura);
		
		textField = new JTextField();
		textField.setBounds(20,100, 250, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 160, 250, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(20, 220, 95, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 220, 130, 30);
		panel.add(textField_3);
		
		
		//INFO
		ImageIcon img = new ImageIcon(Form_Signin_1.class.getResource("/info_piccola.png"));	
		JButton button1 = new JButton(img);
		button1.setBounds(432, -5, 32, 32);
		pannellodefault.add(button1);
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button1.setContentAreaFilled(false);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String warning = "Vincoli data produzione:\n";
				warning += "- Le date inserite devono rispettare il formato [gg/mm/aaaa]\n";
				warning += "- Le date non possono essere successive all'anno corrente\n";
				warning += "- L'anno minimo per le date e' il 1900\n";
				warning += "Ulteriori vincoli:\n";
				warning += "- Luogo di produzione puo' contenere massimo 50 caratteri\n";
				warning += "- Prezzo deve contenere un numero decimale positivo\n";
				warning += "- Numero pezzi deve contenere un intero positivo";
				JOptionPane.showMessageDialog(null, warning);
			}
		});
		button1.setBorder(null);
		
		setVisible(true);
	}

	public void checkVendita(HomePage home) throws ParseException, AziendaException, SQLException {
		String tmpFilettatura = comboBox.getSelectedItem().toString();
		String Codicedado = textField.getText();
		String tmpData = textField_1.getText();
		String tmpPrezzo = textField_2.getText();
		String tmpPezzi = textField_3.getText();
		
		if(Codicedado.length() == 0 || tmpData.length() == 0 || tmpPrezzo.length() == 0 || tmpPezzi.length() == 0)
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Alcuni campi sono vuoti!");
			return;
		}
	
		try {
			if(dateCheck(tmpData) == 1) {
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR: Data di produzione non valida!");
				return;
			}
			
			//Convert string to date
			SimpleDateFormat dataform = new SimpleDateFormat("dd/MM/yyyy");
			Date dataProd = dataform.parse(tmpData);
			
			double tmpPrezzoConv;
			int tmpPezziConv;
			try {
				tmpPrezzoConv = Double.parseDouble(tmpPrezzo);
			} catch (NumberFormatException e) {
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR: Prezzo non valido!");
				return;
			}
			try {
				tmpPezziConv = Integer.parseInt(tmpPezzi);
			} catch (NumberFormatException e) {
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR: Numero di pezzi non valido!");
				return;
			}
			
			
			String metrica = tmpFilettatura.substring(0,3);
			if(metrica.charAt(2) == ' ') //Rimuove ultimo carattere se è uno spazio
				metrica = metrica.substring(0,metrica.length()-1);
			boolean passo = (tmpFilettatura.substring(tmpFilettatura.length()-1).equals("o") ? true : false);
			Dado dado = new EsagonaleAlto(metrica,passo);
			

			dado.setDataProduzione(dataProd);
			dado.setPrezzo(tmpPrezzoConv);
			dado.setNumPezzi(tmpPezziConv);
			Vendita vendita= new Vendita(home.getUtente(),dado,dataProd,tmpPezziConv);
			home.addVendita(vendita);
			
		} catch (ParseException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Data di produzione non valida!");
			return;
		}catch(AziendaException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null,e.getMessage());	
			return;
		}

			dispose();
			setCursor(Cursor.getDefaultCursor());
			new Catalogo(home);
			JOptionPane.showMessageDialog(null, "Dado venduto!");
	}

	// Valida una data in formato String.
	private int dateCheck(String data) {
		int lista_giorni[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		if(data == null)	return 1;
		if(data.length() != 10)	return 1;
		if(data.charAt(2) != '/' || data.charAt(5) != '/')	return 1;
		for(int i=0;i<data.length();i++)
		{
			if(i==2 || i==5)	continue;
			if(data.charAt(i) >= '0' && data.charAt(i) <= '9');
			else
				return 1;
		}
		
		try {
			int giorno = Integer.parseInt(data.substring(0,2));
			int mese = Integer.parseInt(data.substring(3,5));
			int anno = Integer.parseInt(data.substring(6,10));

			if(mese >= 0 && mese <= 12);
			else	return 1;
			
			if(giorno >= 1 && giorno <= lista_giorni[mese-1]);
			else	return 1;
			
			int corrente = Calendar.getInstance().get(Calendar.YEAR);
			if(anno >= 1900 && anno <= corrente);
			else	return 1;
		}
		catch (NumberFormatException e) {
			return 1;
		}
		
		return 0;
	}
}
