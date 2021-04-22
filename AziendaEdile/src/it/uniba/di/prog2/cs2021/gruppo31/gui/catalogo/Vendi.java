package it.uniba.di.prog2.cs2021.gruppo31.gui.catalogo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.Vendita;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.database.ProxyDB;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.gui.Form_Signin_1;
import it.uniba.di.prog2.cs2021.gruppo31.gui.Home;

@SuppressWarnings("rawtypes")
public class Vendi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox textField;
	private JTextField textField_1;
	private JTextField textField_2;

	@SuppressWarnings("unchecked")
	public Vendi(HomePage home) {

		setSize(350, 250);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// PULSANTE INDIETRO
		JButton btn_indietro = new JButton("Indietro");
		btn_indietro.setForeground(Color.WHITE);
		btn_indietro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_indietro.setBackground(new Color(178, 34, 34));
		btn_indietro.setBounds(275, 213, 65, 25);
		contentPane.add(btn_indietro);

		btn_indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home(home);
			}
		});

		// PULSANTE X
		JButton btn_x = new JButton("X");
		btn_x.setSize(new Dimension(10, 10));
		btn_x.setFont(new Font("Dialog", Font.BOLD, 10));
		btn_x.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_x.setBackground(new Color(255, 51, 0));
		btn_x.setBounds(308, 0, 42, 23);
		btn_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btn_x);

		// PULSANTE VENDI DADO
		JButton btn_vendidado = new JButton("Vendi");
		btn_vendidado.setForeground(Color.WHITE);
		btn_vendidado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btn_vendidado.setBackground(new Color(0, 153, 51));
		btn_vendidado.setBounds(275, 176, 65, 25);
		contentPane.add(btn_vendidado);

		btn_vendidado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkVendita(home);
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 12, 231, 216);
		panel.setPreferredSize(new Dimension(320, 400));
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 204));

		JLabel lblLuogoProduzione = new JLabel("Codice dado:");
		lblLuogoProduzione.setBounds(20, 12, 134, 15);
		panel.add(lblLuogoProduzione);

		JLabel lblDataDiProduzione = new JLabel("Data di vendita:");
		lblDataDiProduzione.setBounds(20, 77, 141, 15);
		panel.add(lblDataDiProduzione);

		JLabel label_6 = new JLabel("Numero pezzi:");
		label_6.setBounds(20, 142, 102, 15);
		panel.add(label_6);
		
		try {
			ArrayList<Dado> catalogo = home.getCatalogoDadi();
			String codici[] = new String[catalogo.size()];
			for(int i=0; i<catalogo.size(); i++) {
				codici[i] = Integer.toString(catalogo.get(i).getCodice());
			}
			textField = new JComboBox(codici);
			textField.setBounds(20, 35, 190, 30);
			panel.add(textField);
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: Nessun dado presente nel catalogo!");
			return;
		}

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 100, 190, 30);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(20, 165, 190, 30);
		panel.add(textField_2);
		contentPane.add(panel);

		// INFO
		ImageIcon img = new ImageIcon(Form_Signin_1.class.getResource("/info.png"));
		JButton button1 = new JButton(img);
		button1.setBounds(308, 132, 32, 32);
		button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button1.setContentAreaFilled(false);
		button1.setBorder(null);
		contentPane.add(button1);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String warning = "Vincoli data di vendita:\n";
				warning += "- La data deve rispettare il formato [gg/mm/aaaa]\n";
				warning += "- La data non puo' essere successiva a quella corrente\n";
				warning += "- L'anno minimo per la data e' il 1900\n";
				warning += "Vincoli numero di pezzi:\n";
				warning += "- Il numero di pezzi deve essere un intero positivo\n";
				warning += "- Il numero di pezzi deve essere coerente con i pezzi rimasti";
				JOptionPane.showMessageDialog(null, warning);
			}
		});

		setVisible(true);
	}

	private void checkVendita(HomePage home) {
		String codice = textField.getSelectedItem().toString();
		String tmpData = textField_1.getText();
		String tmpPezzi = textField_2.getText();

		try {
			Dado tmpDado = ProxyDB.getIstance().getDado(codice);
			int pezzi = Integer.parseInt(tmpPezzi);
			if (pezzi < 0) {
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR: Numero pezzi non valido!");
				return;
			}
			if (dateCheck(tmpData) == 1) {
				setCursor(Cursor.getDefaultCursor());
				JOptionPane.showMessageDialog(null, "ERROR: Data di vendita non valida!");
				return;
			}

			// Convert string to date
			SimpleDateFormat dataform = new SimpleDateFormat("dd/MM/yyyy");
			Date data = dataform.parse(tmpData);

			Vendita vendita = new Vendita(home.getUtente(), tmpDado, data, pezzi);
			home.addVendita(vendita);
		} catch (AziendaException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		} catch (NumberFormatException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Numero pezzi non valido!");
			return;
		} catch (ParseException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Data di vendita non valida!");
			return;
		} catch (Exception e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
			return;
		}

		dispose();
		new Home(home);
		setCursor(Cursor.getDefaultCursor());
		JOptionPane.showMessageDialog(null, "Vendita effettuata!");
	}

	// Valida una data in formato String.
	private int dateCheck(String data) {
		int lista_giorni[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (data == null)
			return 1;
		if (data.length() != 10)
			return 1;
		if (data.charAt(2) != '/' || data.charAt(5) != '/')
			return 1;
		for (int i = 0; i < data.length(); i++) {
			if (i == 2 || i == 5)
				continue;
			if (data.charAt(i) >= '0' && data.charAt(i) <= '9');
			else
				return 1;
		}

		try {
			int giorno = Integer.parseInt(data.substring(0, 2));
			int mese = Integer.parseInt(data.substring(3, 5));
			int anno = Integer.parseInt(data.substring(6, 10));

			if (mese >= 0 && mese <= 12);
			else
				return 1;

			if (giorno >= 1 && giorno <= lista_giorni[mese - 1]);
			else
				return 1;

			int corrente = Calendar.getInstance().get(Calendar.YEAR);
			if (anno >= 1900 && anno <= corrente);
			else
				return 1;
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			Date temp = c.getTime();
			if (formatter.parse(data).compareTo(temp) > 0) //Vendita nel futuro
				return 1;
			
		} catch (Exception e) {
			return 1;
		}

		return 0;
	}
}
