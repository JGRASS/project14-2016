package prijemni.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KandidatGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblImeKandidata;
	private JTextField textFieldIme;
	private JLabel lblPrezimeKandidata;
	private JTextField textFieldPrezime;
	private JLabel lblMaticniBroj;
	private JTextField textFieldMaticniBroj;
	private JLabel lblBrojBodovaIz;
	private JTextField textFieldBodovi;
	private JButton btnUcitajPodatke;

	

	/**
	 * Create the frame.
	 */
	public KandidatGUI() {
		setResizable(false);
		setTitle("Kandidat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblImeKandidata());
		contentPane.add(getTextFieldIme());
		contentPane.add(getLblPrezimeKandidata());
		contentPane.add(getTextFieldPrezime());
		contentPane.add(getLblMaticniBroj());
		contentPane.add(getTextFieldMaticniBroj());
		contentPane.add(getLblBrojBodovaIz());
		contentPane.add(getTextFieldBodovi());
		contentPane.add(getBtnUcitajPodatke());
	}
	private JLabel getLblImeKandidata() {
		if (lblImeKandidata == null) {
			lblImeKandidata = new JLabel("Ime kandidata:");
			lblImeKandidata.setBounds(23, 38, 104, 14);
		}
		return lblImeKandidata;
	}
	private JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setPreferredSize(new Dimension(21, 20));
			textFieldIme.setBounds(158, 35, 86, 20);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}
	private JLabel getLblPrezimeKandidata() {
		if (lblPrezimeKandidata == null) {
			lblPrezimeKandidata = new JLabel("Prezime kandidata:");
			lblPrezimeKandidata.setBounds(23, 86, 104, 14);
		}
		return lblPrezimeKandidata;
	}
	private JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setBounds(158, 83, 86, 20);
			textFieldPrezime.setColumns(10);
		}
		return textFieldPrezime;
	}
	private JLabel getLblMaticniBroj() {
		if (lblMaticniBroj == null) {
			lblMaticniBroj = new JLabel("Maticni broj:");
			lblMaticniBroj.setBounds(23, 136, 104, 14);
		}
		return lblMaticniBroj;
	}
	private JTextField getTextFieldMaticniBroj() {
		if (textFieldMaticniBroj == null) {
			textFieldMaticniBroj = new JTextField();
			textFieldMaticniBroj.setBounds(158, 133, 86, 20);
			textFieldMaticniBroj.setColumns(10);
		}
		return textFieldMaticniBroj;
	}
	private JLabel getLblBrojBodovaIz() {
		if (lblBrojBodovaIz == null) {
			lblBrojBodovaIz = new JLabel("Broj bodova iz skole:");
			lblBrojBodovaIz.setBounds(23, 185, 104, 14);
		}
		return lblBrojBodovaIz;
	}
	private JTextField getTextFieldBodovi() {
		if (textFieldBodovi == null) {
			textFieldBodovi = new JTextField();
			textFieldBodovi.setBounds(158, 182, 86, 20);
			textFieldBodovi.setColumns(10);
		}
		return textFieldBodovi;
	}
	private JButton getBtnUcitajPodatke() {
		if (btnUcitajPodatke == null) {
			btnUcitajPodatke = new JButton("Sacuvaj");
			btnUcitajPodatke.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnUcitajPodatke.setBounds(85, 227, 104, 23);
		}
		return btnUcitajPodatke;
	}
}
