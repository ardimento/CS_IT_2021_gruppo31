package it.uniba.di.prog2.cs2021.gruppo31.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignIn2 extends JFrame {

	private static final long serialVersionUID = 1L;

	public SignIn2() {
		
		setSize(600,300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(UIManager.getColor("Button.select"));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon img = new ImageIcon(Login.class.getResource("/worker.png"));
		Image imgScaled = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		img = new ImageIcon(imgScaled);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(28, 80, 162, 163);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAziendaEdile = new JLabel("Azienda Edile");
		lblAziendaEdile.setBackground(new Color(0, 0, 139));
		lblAziendaEdile.setFont(new Font("Liberation Sans", Font.BOLD, 25));
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
		panel.setPreferredSize(new Dimension(342, 450));
		
		JTextField nome = new JTextField();
		nome.setBounds(20, 40, 250, 30);
		panel.add(nome);
		
		JTextField cognome = new JTextField();
		cognome.setBounds(20, 100, 250, 30);
		panel.add(cognome);
		
		JTextField nascita = new JTextField();
		nascita.setBounds(20, 160, 250, 30);
		panel.add(nascita);
		
		JTextField mansione = new JTextField();
		mansione.setBounds(20, 220, 250, 30);
		panel.add(mansione);
		
		JTextField entrata = new JTextField();
		entrata.setBounds(20, 280, 250, 30);
		panel.add(entrata);
		
		JTextField stipendio = new JTextField();
		stipendio.setBounds(20, 340, 250, 30);
		panel.add(stipendio);
		
		JTextField vendite = new JTextField();
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
		
		JScrollPane scroll = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(246, 50, 342, 193);
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
		lblLogin.setFont(new Font("Liberation Sans", Font.BOLD, 20));
		lblLogin.setBounds(246, 12, 134, 24);
		contentPane.add(lblLogin);
		
		ImageIcon user = new ImageIcon(Login.class.getResource("/user.png"));
		Image userScaled = user.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		user = new ImageIcon(userScaled);
		
		JButton btnNewButton_1 = new JButton("Registra");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.desktop);
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBounds(503, 263, 85, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Login();
			}
		});
		btnAnnulla.setForeground(SystemColor.text);		
		btnAnnulla.setBackground(new Color(178, 34, 34));
		btnAnnulla.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAnnulla.setBounds(406, 263, 85, 25);
		contentPane.add(btnAnnulla);
	}
}
