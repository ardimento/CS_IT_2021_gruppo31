package it.uniba.di.prog2.cs2021.gruppo31.gui.catalogo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("rawtypes")
public class Elimina extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox textField;
	
	@SuppressWarnings("unchecked")
	public Elimina(HomePage home) {
		
		setSize(250, 150);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		// PULSANTE X	
		JButton btn_x = new JButton("X");
		btn_x.setOpaque(true);
		btn_x.setSize(new Dimension(10, 10));
		btn_x.setFont(new Font("Dialog", Font.BOLD, 10));
		btn_x.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btn_x.setBackground(new Color(255, 51, 0));
		btn_x.setBounds(208, 0, 42, 23);
		btn_x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btn_x);
		
		try {
			ArrayList<Dado> catalogo = home.getCatalogoDadi();
			String codici[] = new String[catalogo.size()];
			for (int i = 0; i < catalogo.size(); i++) {
				codici[i] = Integer.toString(catalogo.get(i).getCodice());
			}
			textField = new JComboBox(codici);
			textField.setBounds(12, 50, 190, 30);
			contentPane.add(textField);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: Nessun dado presente nel catalogo!");
			return;
		}
		
		JLabel lblInserisciCodiceDado = new JLabel("Codice dado:");
		lblInserisciCodiceDado.setBounds(12, 30, 137, 16);
		contentPane.add(lblInserisciCodiceDado);
		
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
		button_1.setBounds(163, 113, 75, 25);
		contentPane.add(button_1);
		
		JButton btnAggiungi = new JButton("Elimina");
		btnAggiungi.setOpaque(true);
		btnAggiungi.setForeground(Color.WHITE);
		btnAggiungi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiungi.setBackground(new Color(0, 153, 51));
		btnAggiungi.setBounds(81, 113, 75, 25);
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codice = Integer.parseInt((String) textField.getSelectedItem());
				try {
					home.deleteDado(codice);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
				}
				dispose();
				new Catalogo(home);
			}
		});
		contentPane.add(btnAggiungi);
		setVisible(true);
	}
}
		
