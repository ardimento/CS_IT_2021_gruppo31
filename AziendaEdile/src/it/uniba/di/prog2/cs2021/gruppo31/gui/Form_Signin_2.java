package it.uniba.di.prog2.cs2021.gruppo31.gui;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utility_Utente;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Form_Signin_2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField cognome;
	private JTextField nascita;
	private JTextField mansione;
	private JTextField entrata;
	private JTextField stipendio;
	private JTextField vendite;
	private JCheckBox chckbxSeiUnAmministratore;
	
	public Form_Signin_2(String username, String password) {
		
		this.username = username;
		this.password = password;
		
		setSize(600,300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(UIManager.getColor("Button.select"));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon img = new ImageIcon(Form_Signin_2.class.getResource("/worker.png"));
		Image imgScaled = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		img = new ImageIcon(imgScaled);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(28, 80, 162, 163);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAziendaEdile = new JLabel("Azienda Edile");
		lblAziendaEdile.setHorizontalAlignment(SwingConstants.CENTER);
		lblAziendaEdile.setBackground(new Color(0, 0, 139));
		lblAziendaEdile.setFont(new Font("Dialog", Font.BOLD, 21));
		lblAziendaEdile.setForeground(Color.BLACK);
		lblAziendaEdile.setBounds(28, 50, 162, 29);
		lblAziendaEdile.setHorizontalTextPosition(JLabel.CENTER);
		lblAziendaEdile.setVerticalTextPosition(JLabel.TOP);
		contentPane.add(lblAziendaEdile);
		
		// Pannello info
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(176, 224, 230));
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(342, 480));
		
		nome = new JTextField();
		nome.setBounds(20, 40, 250, 30);
		panel.add(nome);
		
		cognome = new JTextField();
		cognome.setBounds(20, 100, 250, 30);
		panel.add(cognome);
		
		nascita = new JTextField();
		nascita.setBounds(20, 160, 250, 30);
		panel.add(nascita);
		
		mansione = new JTextField();
		mansione.setBounds(20, 220, 250, 30);
		panel.add(mansione);
		
		entrata = new JTextField();
		entrata.setBounds(20, 280, 250, 30);
		panel.add(entrata);
		
		stipendio = new JTextField();
		stipendio.setBounds(20, 340, 250, 30);
		panel.add(stipendio);
		
		vendite = new JTextField();
		vendite.setBounds(20, 400, 250, 30);
		panel.add(vendite);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 20, 45, 15);
		panel.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(20, 80, 71, 15);
		panel.add(lblCognome);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita:");
		lblDataDiNascita.setBounds(20, 140, 112, 15);
		panel.add(lblDataDiNascita);
		
		JLabel lblMansione = new JLabel("Mansione:");
		lblMansione.setBounds(20, 200, 74, 15);
		panel.add(lblMansione);
		
		JLabel lblDataDiEntrata = new JLabel("Data di entrata:");
		lblDataDiEntrata.setBounds(20, 260, 114, 15);
		panel.add(lblDataDiEntrata);
		
		JLabel lblStipendioMensile = new JLabel("Stipendio mensile:");
		lblStipendioMensile.setBounds(20, 320, 132, 15);
		panel.add(lblStipendioMensile);
		
		JLabel lblVendite = new JLabel("Limite di vendite annuo:");
		lblVendite.setBounds(20, 380, 171, 15);
		panel.add(lblVendite);
		
		chckbxSeiUnAmministratore = new JCheckBox("Sei un amministratore?");
		chckbxSeiUnAmministratore.setBackground(new Color(176, 224, 230));
		chckbxSeiUnAmministratore.setBounds(20, 440, 189, 23);
		panel.add(chckbxSeiUnAmministratore);
		
		JScrollPane scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(246, 50, 342, 193);
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		contentPane.add(scroll);
		
		JButton btnNewButton_2 = new JButton("X");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setSize(new Dimension(10, 10));
		btnNewButton_2.setBackground(new Color(255, 51, 0));
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_2.setBounds(558, 0, 42, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblNewLabel.setBounds(0, 0, 228, 400);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Info Impiegato");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLogin.setBounds(246, 10, 148, 32);
		contentPane.add(lblLogin);
		
		JButton btnNewButton_1 = new JButton("Registra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(46, 139, 87));
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBounds(503, 263, 85, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Form_Login();
			}
		});
		btnAnnulla.setForeground(new Color(255, 255, 255));		
		btnAnnulla.setBackground(new Color(178, 34, 34));
		btnAnnulla.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAnnulla.setBounds(406, 263, 85, 25);
		contentPane.add(btnAnnulla);
		
		img = new ImageIcon(Form_Signin_1.class.getResource("/info.png"));
		JButton button = new JButton(img);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setContentAreaFilled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String warning = "Vincoli di inserimento:\n";
				warning += "- Nome e cognome devono contenere solo lettere\n";
				warning += "- Nome, cognome e mansione possono contenere massimo 20 caratteri\n";
				warning += "- Stipendio e limite di vendite devono essere interi positivi\n";
				warning += "- Le date inserite devono rispettare il formato [gg/mm/aaaa]\n";
				warning += "- Le date non possono essere successive all'anno corrente\n";
				warning += "- L'anno minimo per le date e' il 1900\n";
				warning += "- La data di entrata deve essere maggiore di almeno 18 anni\n"
						+ "  da quella di nascita: possono lavorare solo i maggiorenni\n";
				JOptionPane.showMessageDialog(null, warning);
			}
		});
		button.setBorder(null);
		button.setBounds(400, 10, 32, 32);
		contentPane.add(button);
		
		setVisible(true);
	}
	
	// Controlla campi inseriti
	private void check() {
		String tmpNome = nome.getText();
		String tmpCognome = cognome.getText();
		String tmpNascita = nascita.getText();
		String tmpMansione = mansione.getText();
		String tmpEntrata = entrata.getText();
		String tmpStipendio = stipendio.getText();
		String tmpVendite = vendite.getText();
		
		if(tmpNome.length() == 0 || tmpCognome.length() == 0 || tmpNascita.length() == 0 || tmpMansione.length() == 0
				|| tmpEntrata.length() == 0 || tmpStipendio.length() == 0 || tmpVendite.length() == 0)
		{
			JOptionPane.showMessageDialog(null, "ERROR: Alcuni campi sono vuoti!");
			return;
		}
		
		if(tmpNome.length() > 20)
		{
			JOptionPane.showMessageDialog(null, "ERROR: Nome non valido!");
			return;
		}
		if(tmpCognome.length() > 20)
		{
			JOptionPane.showMessageDialog(null, "ERROR: Cognome non valido!");
			return;
		}
		if(tmpMansione.length() > 20)
		{
			JOptionPane.showMessageDialog(null, "ERROR: Mansione non valida!");
			return;
		}
		
		try {
			if(dateCheck(tmpNascita) == 1) {
				JOptionPane.showMessageDialog(null, "ERROR: Data di nascita non valida!");
				return;
			}
			if(dateCheck(tmpEntrata) == 1) {
				JOptionPane.showMessageDialog(null, "ERROR: Data di entrata non valida!");
				return;
			}
			
			//Convert string to date
			SimpleDateFormat dataform = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNascita;
			Date dataEntrata;			
			try {
				dataNascita = dataform.parse(tmpNascita);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "ERROR: Data di nascita non valida!");
				return;
			}
			try {
				dataEntrata = dataform.parse(tmpEntrata);
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "ERROR: Data di entrata non valida!");
				return;
			}
			
			int stipendio;
			int vendite;
			try {
				stipendio = Integer.parseInt(tmpStipendio);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "ERROR: Stipendio mensile non valido!");
				return;
			}
			try {
				vendite = Integer.parseInt(tmpVendite);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "ERROR: Limite vendite annuo non valido!");
				return;
			}
			
			Impiegato impiegato = new Impiegato(tmpNome,tmpCognome,dataNascita,tmpMansione,dataEntrata,stipendio,vendite);
			int res = Utility_Utente.checkImpiegato(impiegato);
			switch(res) {
				case 0: //Valido
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "ERROR: Nome non valido!");
					return;
				case 2:
					JOptionPane.showMessageDialog(null, "ERROR: Cognome non valido!");
					return;
				case 3:
					JOptionPane.showMessageDialog(null, "ERROR: Data di nascita non valida!");
					return;
				case 4:
					JOptionPane.showMessageDialog(null, "ERROR: Data di entrata non valida!");
					return;
				case 5:
					JOptionPane.showMessageDialog(null, "ERROR: Stipendio mensile non valido!");
					return;
				case 6:
					JOptionPane.showMessageDialog(null, "ERROR: Limite vendite annuo non valido!");
					return;
			}
			
			boolean admin = chckbxSeiUnAmministratore.isSelected();
			Utente utente = new Utente(impiegato,username,Utility_Utente.hashPwd(password),admin);
			utente.addUtente();
			
		} catch (AziendaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
			return;
		}
		
		dispose();
		new Form_Login();
		JOptionPane.showMessageDialog(null, "Registrazione completata!");
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
		
		return 0; //Valida
	}
}
