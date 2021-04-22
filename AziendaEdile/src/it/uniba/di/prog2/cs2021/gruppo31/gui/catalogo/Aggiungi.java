package it.uniba.di.prog2.cs2021.gruppo31.gui.catalogo;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;
import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.dado.EsagonaleAlto;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Filettatura;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Materiale;
import it.uniba.di.prog2.cs2021.gruppo31.dado.RivestimentoProtettivo;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.gui.Form_Signin_1;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

@SuppressWarnings("rawtypes")
public class Aggiungi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	
	@SuppressWarnings("unchecked")
	public Aggiungi(HomePage home) {
		
		setSize(440, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton button = new JButton("X");
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setSize(new Dimension(10, 10));
		button.setFont(new Font("Dialog", Font.BOLD, 10));
		button.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		button.setBackground(new Color(255, 51, 0));
		button.setBounds(398, 0, 42, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Indietro");
		button_1.setOpaque(true);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Catalogo(home);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_1.setBackground(new Color(178, 34, 34));
		button_1.setBounds(355, 263, 75, 25);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(12, 12, 320, 276);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(320, 400));
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(panel);
		
		JLabel lblFilettatura = new JLabel("Filettatura:");
		lblFilettatura.setBounds(20, 20, 81, 15);
		panel.add(lblFilettatura);
		
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
		
		JLabel lblMateriale = new JLabel("Materiale:");
		lblMateriale.setBounds(20, 80, 73, 15);
		panel.add(lblMateriale);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(195, 80, 75, 15);
		panel.add(lblCategoria);
		
		String materiali[] = {"Acciaio 5","Acciaio 8","Acciaio 10",
				"Acciaio Inox A2","Acciaio Inox A4","Ottone OT58","Ottone OT63"};
		comboBox_1 = new JComboBox(materiali);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(20, 100, 150, 30);
		panel.add(comboBox_1);
		
		String categorie[] = {"A","B","C"};
		comboBox_2 = new JComboBox(categorie);
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(195, 100, 75, 30);
		panel.add(comboBox_2);
		
		String rivestimenti[] = {"Nessuno","Brunitura",
				"Fosfatazione","Zinco-Nichel","Zincatura a caldo"};
		comboBox_3 = new JComboBox(rivestimenti);
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(20, 160, 250, 30);
		panel.add(comboBox_3);
		
		JLabel lblRivestimentoProtettivo = new JLabel("Rivestimento protettivo:");
		lblRivestimentoProtettivo.setBounds(20, 140, 172, 15);
		panel.add(lblRivestimentoProtettivo);
		
		JLabel lblLuogoProduzione = new JLabel("Luogo produzione:");
		lblLuogoProduzione.setBounds(20, 200, 134, 15);
		panel.add(lblLuogoProduzione);
		
		JLabel lblDataDiProduzione = new JLabel("Data di produzione:");
		lblDataDiProduzione.setBounds(20, 260, 141, 15);
		panel.add(lblDataDiProduzione);
		
		JLabel label_5 = new JLabel("Prezzo:");
		label_5.setBounds(20, 320, 54, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Numero pezzi:");
		label_6.setBounds(140, 320, 102, 15);
		panel.add(label_6);
		
		textField = new JTextField();
		textField.setBounds(20, 220, 250, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 280, 250, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(20, 340, 95, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 340, 130, 30);
		panel.add(textField_3);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setOpaque(true);
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				check(home);
			}
		});
		btnAggiungi.setForeground(Color.WHITE);
		btnAggiungi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiungi.setBackground(new Color(0, 153, 51));
		btnAggiungi.setBounds(355, 229, 75, 25);
		contentPane.add(btnAggiungi);
		
		ImageIcon img = new ImageIcon(Form_Signin_1.class.getResource("/info.png"));	
		JButton button1 = new JButton(img);
		button1.setBounds(398, 190, 32, 32);
		contentPane.add(button1);
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button1.setContentAreaFilled(false);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String warning = "Vincoli data di produzione:\n";
				warning += "- Le date inserite devono rispettare il formato [gg/mm/aaaa]\n";
				warning += "- Le date non possono essere successive a quella corrente\n";
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
	
	private void check(HomePage home) {
		String tmpFilettatura = comboBox.getSelectedItem().toString();
		String tmpMateriale = comboBox_1.getSelectedItem().toString(); 
		String tmpCategoria = comboBox_2.getSelectedItem().toString();
		String tmpRivestimento = comboBox_3.getSelectedItem().toString();
		String tmpLuogo = textField.getText();
		String tmpData = textField_1.getText();
		String tmpPrezzo = textField_2.getText();
		String tmpPezzi = textField_3.getText();
		
		if(tmpFilettatura.length() == 0 || tmpMateriale.length() == 0 || tmpCategoria.length() == 0 || tmpRivestimento.length() == 0
				|| tmpLuogo.length() == 0 || tmpData.length() == 0 || tmpPrezzo.length() == 0 || tmpPezzi.length() == 0)
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Alcuni campi sono vuoti!");
			return;
		}
		
		if(tmpLuogo.length() > 50)
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Luogo di produzione non valido!");
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
			
			switch(tmpMateriale) {
				case "Acciaio 5":
					dado.setMateriale(Materiale.values()[0].toString());
					break;
				case "Acciaio 8":
					dado.setMateriale(Materiale.values()[1].toString());
					break;
				case "Acciaio 10":
					dado.setMateriale(Materiale.values()[2].toString());
					break;
				case "Acciaio Inox A2":
					dado.setMateriale(Materiale.values()[3].toString());
					break;
				case "Acciaio Inox A4":
					dado.setMateriale(Materiale.values()[4].toString());
					break;
				case "Ottone OT58":
					dado.setMateriale(Materiale.values()[5].toString());
					break;
				case "Ottone OT63":
					dado.setMateriale(Materiale.values()[6].toString());
					break;
			}
			
			switch(tmpRivestimento) {
			case "Nessuno":
				dado.setRivestimentoProtettivo(RivestimentoProtettivo.values()[0].toString());
				break;
			case "Brunitura":
				dado.setRivestimentoProtettivo(RivestimentoProtettivo.values()[1].toString());
				break;
			case "Fosfatazione":
				dado.setRivestimentoProtettivo(RivestimentoProtettivo.values()[2].toString());
				break;
			case "Zinco-Nichel":
				dado.setRivestimentoProtettivo(RivestimentoProtettivo.values()[3].toString());
				break;
			case "Zincatura a caldo":
				dado.setRivestimentoProtettivo(RivestimentoProtettivo.values()[4].toString());
				break;
			}
			
			dado.setCategoria(tmpCategoria);
			dado.setLuogoProduzione(tmpLuogo);
			dado.setDataProduzione(dataProd);
			dado.setPrezzo(tmpPrezzoConv);
			dado.setNumPezzi(tmpPezziConv);
			home.addDado(dado);
			
		} catch (AziendaException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		} catch (ParseException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Data di produzione non valida!");
			return;
		} catch (SQLException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
			return;
		}

		dispose();
		setCursor(Cursor.getDefaultCursor());
		new Catalogo(home);
		JOptionPane.showMessageDialog(null, "Dado aggiunto al catalogo!");
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
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			Date temp = c.getTime();
			if (formatter.parse(data).compareTo(temp) > 0) //Vendita nel futuro
				return 1;
			
		} catch (Exception e) {
			return 1;
		}
		
		return 0; //Valida
	}
}
