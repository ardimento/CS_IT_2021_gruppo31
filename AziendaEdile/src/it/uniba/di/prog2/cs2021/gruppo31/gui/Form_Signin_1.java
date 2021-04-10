package it.uniba.di.prog2.cs2021.gruppo31.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.exception.ErroriDB;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utility_Utente;
import java.awt.Cursor;

public class Form_Signin_1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public Form_Signin_1() {
		
		setSize(600,300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(UIManager.getColor("Button.select"));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon img = new ImageIcon(Form_Signin_1.class.getResource("/worker.png"));
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
		
		txtUsername = new JTextField();
		txtUsername.setBounds(246, 80, 321, 30);
		contentPane.add(txtUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(246, 140, 321, 30);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(246, 200, 321, 30);
		contentPane.add(passwordField_1);
		
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
		
		JLabel lblLogin = new JLabel("Info Utente");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLogin.setBounds(246, 10, 117, 32);
		contentPane.add(lblLogin);
		
		ImageIcon user = new ImageIcon(Form_Login.class.getResource("/user.png"));
		Image userScaled = user.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		user = new ImageIcon(userScaled);
		
		JLabel lblUsername = new JLabel("Inserisci la password:");
		lblUsername.setBounds(246, 120, 155, 15);
		contentPane.add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Inserisci lo username:");
		lblUsername_1.setBounds(246, 60, 156, 15);
		contentPane.add(lblUsername_1);
		
		JLabel lblInserisciNuocamenteLa = new JLabel("Inserisci nuovamente la password:");
		lblInserisciNuocamenteLa.setBounds(246, 180, 247, 15);
		contentPane.add(lblInserisciNuocamenteLa);
		
		JButton btnNewButton_1 = new JButton("Avanti");
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
				String warning = "Vincoli username:\n";
				warning += "- Lunghezza minima = 5\n";
				warning += "- Lunghezza massima = 20\n";
				warning += "- Puo' contenere solo lettere, cifre e i seguenti caratteri: {._-}\n";
				warning += "- Deve iniziare con una lettera\n";
				warning += "Vincoli password:\n";
				warning += "- Lunghezza minima = 8\n";
				warning += "- Lunghezza massima = 50\n";
				warning += "- Puo' contenere solo lettere, cifre e i seguenti caratteri: {.,;:_+/*^=?!()\\\\[\\\\]{}@%#$-}\n";
				JOptionPane.showMessageDialog(null, warning);
			}
		});
		button.setBorder(null);
		button.setBounds(369, 10, 32, 32);
		contentPane.add(button);
		
		setVisible(true);
	}
	
	private void check() {
		String user = txtUsername.getText();
		char[] charPass = passwordField.getPassword();
		String pass = new String(charPass);
		char[] charPass_1 = passwordField_1.getPassword();
		String pass_1 = new String(charPass_1);
		
		if(user.length() == 0 || pass.length() == 0 || pass_1.length() == 0)
		{
			JOptionPane.showMessageDialog(null, "ERROR: Alcuni campi sono vuoti!");
			return;
		}
		
		if(pass.equals(pass_1));
		else
		{
			JOptionPane.showMessageDialog(null, "ERROR: Le password non coincidono!");
			return;
		}
		
		int res = Utility_Utente.checkCorrettezzaCredenziali(user,pass);
		if(res == 0);
		else {
			JOptionPane.showMessageDialog(null, "ERROR: Vincoli non rispettati!\nPremere su Info per controllare i vincoli.");
			return;
		}
		
		try {
			Utility_Utente.checkUtente(user,Utility_Utente.hashPwd(pass));
		} catch (AziendaException e) {
			if(e.getMessage().equals(ErroriDB.USERNAME_NOT_FOUND)) { //Username valido
				dispose();
				new Form_Signin_2(user,pass);
				return;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
			return;
		}
		
		JOptionPane.showMessageDialog(null, "ERROR: Username già in uso!");
		return;
	}
}
