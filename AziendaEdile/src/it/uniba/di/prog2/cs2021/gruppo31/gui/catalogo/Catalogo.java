package it.uniba.di.prog2.cs2021.gruppo31.gui.catalogo;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import it.uniba.di.prog2.cs2021.gruppo31.HomePage;
import it.uniba.di.prog2.cs2021.gruppo31.dado.Dado;
import it.uniba.di.prog2.cs2021.gruppo31.exception.AziendaException;
import it.uniba.di.prog2.cs2021.gruppo31.gui.Home;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Dimension;

public class Catalogo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public Catalogo(HomePage home) {
		
		setSize(600, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnAggiungiDado = new JButton("Aggiungi Dado");
		btnAggiungiDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Aggiungi(home);
			}
		});
		btnAggiungiDado.setForeground(Color.WHITE);
		btnAggiungiDado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiungiDado.setBackground(new Color(0, 153, 51));
		btnAggiungiDado.setBounds(465, 44, 125, 22);
		contentPane.add(btnAggiungiDado);
		
		JButton btnEliminaDado = new JButton("Elimina Dado");
		btnEliminaDado.setForeground(Color.WHITE);
		btnEliminaDado.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnEliminaDado.setBackground(new Color(0, 153, 51));
		btnEliminaDado.setBounds(465, 78, 125, 22);
		contentPane.add(btnEliminaDado);
		
		JButton btnAggiornaPrezzo = new JButton("Aggiorna Prezzo");
		btnAggiornaPrezzo.setForeground(Color.WHITE);
		btnAggiornaPrezzo.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiornaPrezzo.setBackground(new Color(218, 112, 214));
		btnAggiornaPrezzo.setBounds(465, 112, 125, 22);
		contentPane.add(btnAggiornaPrezzo);
		
		JButton btnAggiornaScorte = new JButton("Aggiorna Scorte");
		btnAggiornaScorte.setForeground(Color.WHITE);
		btnAggiornaScorte.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAggiornaScorte.setBackground(new Color(218, 112, 214));
		btnAggiornaScorte.setBounds(465, 146, 125, 22);
		contentPane.add(btnAggiornaScorte);
		
		JButton btnIndietro = new JButton("Indietro");
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home(home);
			}
		});
		btnIndietro.setForeground(Color.WHITE);
		btnIndietro.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnIndietro.setBackground(new Color(178, 34, 34));
		btnIndietro.setBounds(523, 263, 65, 25);
		contentPane.add(btnIndietro);
		
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
		
		try {
			String[] colonne = {"Codice","Prezzo","Scorte","Dettagli"};
			ArrayList<Dado> dadi;
			try {
				dadi = home.getCatalogoDadi();
				String tmp[][] = new String[dadi.size()][4];
				for(int i=0;i<dadi.size();i++) {
					tmp[i][0] = Integer.toString(dadi.get(i).getCodice());
					tmp[i][1] = Double.toString(dadi.get(i).getPrezzo()) + " euro";
					tmp[i][2] = Integer.toString(dadi.get(i).getNumPezzi());
				}
				
				DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
				cellRenderer.setHorizontalAlignment(JLabel.CENTER);
				table = new JTable(tmp,colonne);
				//table.setEnabled(false);
				table.setBackground(new Color(204, 204, 255));
				table.setOpaque(true);
				table.setFillsViewportHeight(true);
				table.getTableHeader().setBackground(Color.WHITE);
				table.getColumnModel().getColumn(3).setPreferredWidth(90);
				table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
				
				Action box = new AbstractAction() {
					private static final long serialVersionUID = 1L;
					public void actionPerformed(ActionEvent e) {
						int row = Integer.valueOf(e.getActionCommand());
						JOptionPane.showMessageDialog(null, dadi.get(row).toString());
					}
				};
				new ButtonColumn(table,box,3);
				
				JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				sp.setBounds(10, 10, 443, 280);
				contentPane.add(sp);
				
			} catch (AziendaException e1) {	//Tabella vuota
				DefaultTableModel model = new DefaultTableModel(0,colonne.length);
				model.setColumnIdentifiers(colonne);
				table = new JTable(model);
				table.setOpaque(true);
				table.setFillsViewportHeight(true);
				table.getTableHeader().setBackground(Color.WHITE);
				JScrollPane sp = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				sp.setBounds(10, 10, 447, 278);
				contentPane.add(sp);
			}
			
		} catch(SQLException | ParseException e) {
			JOptionPane.showMessageDialog(null, "ERROR: Errore interno database!");
		}
		
		setVisible(true);
	}
}
