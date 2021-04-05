package it.uniba.di.prog2.cs2021.gruppo31.gui;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.border.SoftBevelBorder;
import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Impiegato;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;

	public Home(HomePage home) {

		setSize(600, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(UIManager.getColor("Button.background"));
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

			JLabel lblStipendioMensile = new JLabel("Stipendio mensile: € " + impiegato.getStipendioMensile());
			lblStipendioMensile.setBounds(10, 230, 222, 15);
			contentPane.add(lblStipendioMensile);

			JLabel lblLimiteVenditeAnnuo = new JLabel("Limite vendite annuo: " + impiegato.getMaxVenditeAnno());
			lblLimiteVenditeAnnuo.setBounds(10, 260, 222, 15);
			contentPane.add(lblLimiteVenditeAnnuo);

			JLabel lblUsername = new JLabel("Username: " + home.getUtente().getUsername());
			lblUsername.setForeground(new Color(255, 0, 0));
			lblUsername.setBounds(80, 10, 241, 15);
			contentPane.add(lblUsername);

			String account = "Account: ";
			if (home.getUtente().isAdmin())
				account += "Amministratore";
			else
				account += "Utente";
			JLabel lblAccount = new JLabel(account);
			lblAccount.setForeground(new Color(255, 0, 0));
			lblAccount.setBounds(80, 40, 241, 15);
			contentPane.add(lblAccount);

		} catch (AziendaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Errore database!");
		}

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.highlight"));
		panel.setBounds(250, 80, 337, 210);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnEsci_1 = new JButton("Esci");
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
		btnEsci_1.setBounds(260, 173, 65, 25);
		panel.add(btnEsci_1);

		JButton button_5 = new JButton("Vendi");
		button_5.setForeground(Color.WHITE);
		button_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		button_5.setBackground(new Color(0, 153, 51));
		button_5.setBounds(210, 97, 115, 25);
		panel.add(button_5);

		JButton btnEsci = new JButton("Catalogo dadi");
		btnEsci.setBounds(210, 134, 115, 25);
		panel.add(btnEsci);
		btnEsci.setForeground(SystemColor.activeCaptionText);
		btnEsci.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnEsci.setBackground(SystemColor.info);

		setVisible(true);
	}
}
