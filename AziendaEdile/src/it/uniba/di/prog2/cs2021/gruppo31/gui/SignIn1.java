package it.uniba.di.prog2.cs2021.gruppo31.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class SignIn1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public SignIn1() {
		
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
		
		JTextField txtUsername = new JTextField();
		txtUsername.setBounds(246, 80, 321, 30);
		contentPane.add(txtUsername);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(246, 140, 321, 30);
		contentPane.add(passwordField);
		
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
		lblLogin.setFont(new Font("Liberation Sans", Font.BOLD, 20));
		lblLogin.setBounds(246, 12, 104, 24);
		contentPane.add(lblLogin);
		
		ImageIcon user = new ImageIcon(Login.class.getResource("/user.png"));
		Image userScaled = user.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		user = new ImageIcon(userScaled);
		
		JLabel lblUsername = new JLabel("Inserisci la password:");
		lblUsername.setBounds(246, 120, 155, 15);
		contentPane.add(lblUsername);
		
		JLabel lblUsername_1 = new JLabel("Inserisci lo username:");
		lblUsername_1.setBounds(246, 60, 156, 15);
		contentPane.add(lblUsername_1);
		
		JPasswordField passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(246, 200, 321, 30);
		contentPane.add(passwordField_1);
		
		JLabel lblInserisciNuocamenteLa = new JLabel("Inserisci nuovamente la password:");
		lblInserisciNuocamenteLa.setBounds(246, 180, 247, 15);
		contentPane.add(lblInserisciNuocamenteLa);
		
		JButton btnNewButton_1 = new JButton("Avanti");
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
