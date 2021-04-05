package it.uniba.di.prog2.cs2021.gruppo31.gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.utente.Utility_Utente;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Form_Login extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel contentPane;
	JTextField txtUsername;
	JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_Login frame = new Form_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Form_Login() {
		
		setSize(600,300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(UIManager.getColor("Button.select"));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		ImageIcon img = new ImageIcon(Form_Login.class.getResource("/worker.png"));
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
		
		txtUsername = new JTextField();
		txtUsername.setBounds(291, 100, 250, 30);
		contentPane.add(txtUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(291, 160, 250, 30);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Registrati!");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Form_Signin_1();
			}
		});
		btnNewButton.setForeground(SystemColor.activeCaption);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(518, 280, 75, 15);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Accedi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				login();
			}
		});
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.desktop);
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBounds(456, 202, 85, 25);
		contentPane.add(btnNewButton_1);
		
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
		
		JLabel lblSeiUnNuovo = new JLabel("Sei un nuovo utente?");
		lblSeiUnNuovo.setBounds(362, 280, 150, 15);
		contentPane.add(lblSeiUnNuovo);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Liberation Sans", Font.BOLD, 20));
		lblLogin.setBounds(373, 29, 62, 24);
		contentPane.add(lblLogin);
		
		ImageIcon user = new ImageIcon(Form_Login.class.getResource("/user.png"));
		Image userScaled = user.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		user = new ImageIcon(userScaled);
		
		JLabel label = new JLabel("");
		label.setIcon(user);
		label.setBounds(432, 24, 31, 29);
		contentPane.add(label);
		
		JLabel lblUsername = new JLabel("Password");
		lblUsername.setBounds(291, 140, 70, 15);
		contentPane.add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Username");
		lblUsername_1.setBounds(291, 80, 72, 15);
		contentPane.add(lblUsername_1);
		
		setVisible(true);
	}
	
	private void login() {
		String user = txtUsername.getText();
		char[] charPass = passwordField.getPassword();
		String pass = new String(charPass);
		
		if(user.length() == 0 || pass.length() == 0)
		{
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Inserire username e password!");
			return;
		}
		
		try {
			Utility_Utente.checkUtente(user,Utility_Utente.hashPwd(pass));
		} catch (AziendaException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		} catch (Exception e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
			return;
		}
		
		try {
			HomePage home = new HomePage(Utility_Utente.getUtente(user));
			dispose();
			new Home(home);
		} catch (AziendaException e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, e.getMessage());
			return;
		} catch (Exception e) {
			setCursor(Cursor.getDefaultCursor());
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
			return;
		}
		
		setCursor(Cursor.getDefaultCursor());
		return;
	}
}