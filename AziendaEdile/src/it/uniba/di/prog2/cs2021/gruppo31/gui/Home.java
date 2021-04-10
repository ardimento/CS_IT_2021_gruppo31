package it.uniba.di.prog2.cs2021.gruppo31.gui;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.Vendita;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.gui.catalogo.Catalogo;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utente;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Utente utente;

	public Home(HomePage home) {

		setSize(600, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		ImageIcon img = new ImageIcon(Form_Login.class.getResource("/computer.png"));
		Image imgScaled = img.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		img = new ImageIcon(imgScaled);

		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setSize(new Dimension(10, 10));
		button.setFont(new Font("Dialog", Font.BOLD, 10));
		button.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		button.setBackground(new Color(255, 51, 0));
		button.setBounds(558, 0, 42, 23);
		contentPane.add(button);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setAutoscrolls(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(10, 10, 60, 60);
		contentPane.add(lblNewLabel_1);
		
		utente = home.getUtente();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Impiegato impiegato = home.getInfoImpiegato();

			JLabel lblNewLabel = new JLabel("Nome: " + impiegato.getNome());
			lblNewLabel.setBounds(10, 80, 222, 15);
			contentPane.add(lblNewLabel);

			JLabel lblCognome = new JLabel("Cognome: " + impiegato.getCognome());
			lblCognome.setBounds(10, 110, 222, 15);
			contentPane.add(lblCognome);

			JLabel lblNewLabel_2 = new JLabel("Mansione: " + impiegato.getMansione());
			lblNewLabel_2.setBounds(10, 170, 222, 15);
			contentPane.add(lblNewLabel_2);

			JLabel lblDataDiNascita = new JLabel("Data di nascita: " + formatter.format(impiegato.getDataNascita()));
			lblDataDiNascita.setBounds(10, 140, 222, 15);
			contentPane.add(lblDataDiNascita);

			JLabel lblDataDiEntrata = new JLabel("Data di entrata: " + formatter.format(impiegato.getDataEntrata()));
			lblDataDiEntrata.setBounds(10, 200, 222, 15);
			contentPane.add(lblDataDiEntrata);

			JLabel lblStipendioMensile = new JLabel("Stipendio mensile: " + impiegato.getStipendioMensile() + " euro");
			lblStipendioMensile.setBounds(10, 230, 222, 15);
			contentPane.add(lblStipendioMensile);

			JLabel lblLimiteVenditeAnnuo = new JLabel("Limite vendite annuo: " + impiegato.getMaxVenditeAnno());
			lblLimiteVenditeAnnuo.setBounds(10, 260, 222, 15);
			contentPane.add(lblLimiteVenditeAnnuo);

			JLabel lblUsername = new JLabel("Username: " + utente.getUsername());
			lblUsername.setBackground(new Color(240, 230, 140));
			lblUsername.setForeground(new Color(0, 0, 255));
			lblUsername.setBounds(80, 10, 241, 15);
			contentPane.add(lblUsername);

			String account = "Account: ";
			if (utente.isAdmin())
				account += "Amministratore";
			else
				account += "Utente";
			JLabel lblAccount = new JLabel(account);
			lblAccount.setBackground(new Color(240, 230, 140));
			lblAccount.setForeground(new Color(0, 0, 255));
			lblAccount.setBounds(80, 40, 241, 15);
			contentPane.add(lblAccount);

		} catch (AziendaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
		}

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(250, 80, 337, 210);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JButton button_5 = new JButton("Vendi");
		button_5.setBounds(10, 12, 65, 25);
		panel.add(button_5);
		button_5.setForeground(Color.WHITE);
		button_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_5.setBackground(new Color(0, 153, 51));

		JButton btnEsci_1 = new JButton("Esci");
		btnEsci_1.setBounds(260, 42, 65, 25);
		panel.add(btnEsci_1);
		btnEsci_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home.logOut();
				dispose();
				new Form_Login();
			}
		});
		btnEsci_1.setForeground(Color.WHITE);
		btnEsci_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnEsci_1.setBackground(new Color(178, 34, 34));

		JButton btnEsci = new JButton("Catalogo dadi");
		btnEsci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Catalogo(home);
			}
		});
		btnEsci.setBounds(87, 12, 120, 25);
		btnEsci.setForeground(new Color(0, 0, 0));
		btnEsci.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnEsci.setBackground(new Color(255, 215, 0));
		panel.add(btnEsci);
		
		//Tabella vendite
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String[] colonne = {"Dado","Data","Pezzi","Totale"};
			ArrayList<Vendita> vendite;
			try {
				vendite = home.getVenditeImpiegato();
				String tmp[][] = new String[vendite.size()][4];
				for(int i=0;i<vendite.size();i++) {
					tmp[i][0] = Integer.toString(vendite.get(i).getDado().hashCode());
					tmp[i][1] = formatter.format(vendite.get(i).getData());
					tmp[i][2] = Integer.toString(vendite.get(i).getNumPezzi());
					tmp[i][3] = "€ " + Double.toString(vendite.get(i).getDado().getPrezzo() * (double)vendite.get(i).getNumPezzi());
				}
				table = new JTable(tmp,colonne);
				table.setBackground(new Color(204, 255, 153));
				table.setOpaque(true);
				table.setFillsViewportHeight(true);
				table.getTableHeader().setBackground(Color.WHITE);
				JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				sp.setBounds(10, 79, 315, 119);
				panel.add(sp);
			} catch (AziendaException e1) {
				DefaultTableModel model = new DefaultTableModel(0,colonne.length);
				model.setColumnIdentifiers(colonne);
				table = new JTable(model);
				table.setOpaque(true);
				table.setFillsViewportHeight(true);
				table.getTableHeader().setBackground(Color.WHITE);
				JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				sp.setBounds(10, 79, 315, 119);
				panel.add(sp);
			}

			JLabel lblNewLabel_3 = new JLabel("Le tue vendite");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("Lucida Sans", Font.BOLD, 13));
			lblNewLabel_3.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2, true), new LineBorder(new Color(255, 255, 0), 1, true)));
			lblNewLabel_3.setOpaque(true);
			lblNewLabel_3.setBackground(new Color(255, 153, 0));
			lblNewLabel_3.setBounds(10, 60, 108, 21);
			panel.add(lblNewLabel_3);
			
		} catch(SQLException | ParseException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
		}		

		setVisible(true);
	}
}
