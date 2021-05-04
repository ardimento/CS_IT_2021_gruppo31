package it.uniba.di.prog2.cs2021.gruppo31.gui.catalogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.gui.Home;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AggiornaScorte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private JComboBox textField;
	private JTextField textField_1;
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AggiornaScorte (HomePage home) {
		
		setSize(400, 150);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(255, 255, 204));
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
				btn_x.setBounds(352, 0, 42, 23);
				btn_x.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				contentPane.add(btn_x);
		
		

				try {
					ArrayList<Dado> catalogo = home.getCatalogoDadi();
					String codici[] = new String[catalogo.size()];
					for(int i=0; i<catalogo.size(); i++) {
						codici[i] = Integer.toString(catalogo.get(i).getCodice());
					}
					textField = new JComboBox(codici);
					textField.setBounds(0, 23, 190, 30);
					contentPane.add(textField);
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "ERROR: Nessun dado presente nel catalogo!");
					return;
				}
		
				
		JLabel lblInserisciCodiceDado = new JLabel("Inserisci codice dado:");
		lblInserisciCodiceDado.setBounds(16, 7, 137, 16);
		contentPane.add(lblInserisciCodiceDado);
		
		JLabel lblInserisciScorteDado = new JLabel("Inserisci scorte dado :");
		lblInserisciScorteDado .setBounds(10, 60, 142, 16);
		contentPane.add(lblInserisciScorteDado );
		
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
		button_1.setBounds(319, 119, 75, 25);
		contentPane.add(button_1);
		
		JButton btnAggiungi =  new JButton("Aggiorna");
		btnAggiungi.setOpaque(true);
		btnAggiungi.setForeground(Color.WHITE);
		btnAggiungi.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiungi.setBackground(new Color(0, 153, 51));
		btnAggiungi.setBounds(239, 119, 75, 25);
		contentPane.add(btnAggiungi);
		
		textField_1 = new JTextField();
		textField_1.setBounds(26, 76, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
	
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int codice = Integer.parseInt((String) textField.getSelectedItem());
				int scorte = Integer.parseInt(textField_1.getText());
				
				try {
					home.updatePezziDado(codice,scorte);
				} catch (AziendaException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				} catch (SQLException e1) {
						
					JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				new Catalogo(home);
				
				
		}
		
	});
		setVisible(true);// RENDE VISIBILE IL FRAME ESEGUITO.si mette sempre alla fine.
	}
}
		
