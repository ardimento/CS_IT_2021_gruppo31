package it.uniba.di.prog2.cs2021.gruppo31.gui.catalogo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("rawtypes")
public class AggiornaPrezzo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox textField;
	private JTextField textField_1;
	
	@SuppressWarnings("unchecked")
	public AggiornaPrezzo(HomePage home) {
		
		setSize(260, 200);
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
		btn_x.setBounds(218, 0, 42, 23);
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
			textField.setBounds(16, 55, 190, 30);
			contentPane.add(textField);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: Nessun dado presente nel catalogo!");
			return;
		}
				
		JLabel lblInserisciCodiceDado = new JLabel("Codice dado:");
		lblInserisciCodiceDado.setBounds(16, 35, 137, 16);
		contentPane.add(lblInserisciCodiceDado);
		
		JLabel lblInserisciPrezzoDado = new JLabel("Nuovo prezzo:");
		lblInserisciPrezzoDado.setBounds(16, 100, 142, 16);
		contentPane.add(lblInserisciPrezzoDado);
		
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
		button_1.setBounds(173, 163, 75, 25);
		contentPane.add(button_1);
		
		JButton btnAggiungi = new JButton("Aggiorna");
		btnAggiungi.setOpaque(true);
		btnAggiungi.setForeground(Color.WHITE);
		btnAggiungi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiungi.setBackground(new Color(0, 153, 51));
		btnAggiungi.setBounds(91, 163, 75, 25);
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int codice = Integer.parseInt((String) textField.getSelectedItem());
					double prezzo = Double.parseDouble(textField_1.getText());
					home.updatePrezzoDado(codice,prezzo);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"ERROR: Inserire un numero decimale positivo (es. 1.23)!");
					return;
				} catch (AziendaException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					return;
				} catch (SQLException e1) {	
					JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
					return;
				}
				dispose();
				new Catalogo(home);
				JOptionPane.showMessageDialog(null, "Prezzo aggiornato correttamente!");
			}
		});
		contentPane.add(btnAggiungi);
		
		textField_1 = new JTextField();
		textField_1.setBounds(16, 120, 190, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		setVisible(true);
	}
}
		
