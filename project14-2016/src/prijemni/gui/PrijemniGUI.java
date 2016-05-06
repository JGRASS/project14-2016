package prijemni.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prijemni.Kandidat;
import prijemni.gui.GUIKontroler;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class PrijemniGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTextArea textAreaPitanja;
	private JButton btnPocetak;
	private JButton btnSacuvaj;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnB;
	private JRadioButton rdbtnC;
	private JRadioButton rdbtnD;
	private JRadioButton rdbtnN;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JLabel lblMaticniBroj;
	private JLabel lblBodoviIzSkole;
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JTextField textFieldMaticniBroj;
	private JTextField textFieldBodoviIzSkole;
	private JButton btnUcitajResenja;
	private JButton btnUcitajKandidata;
	private JButton btnSledeciOdgovor;

	/**
	 * Create the frame.
	 */
	public PrijemniGUI() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.ugasiAplikaciju();
			}
		});

		setTitle("Rezultati prijemnog");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_1(), BorderLayout.EAST);
			panel.add(getPanel_2(), BorderLayout.SOUTH);
			panel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(150, 10));
			panel_1.setLayout(
					new MigLayout("", "[74px,grow]", "[fill][fill][fill][fill][fill][fill][fill][fill][fill][fill][]"));
			panel_1.add(getBtnUcitajResenja(), "cell 0 0,growx");
			panel_1.add(getBtnUcitajKandidata(), "cell 0 1,growx");
			panel_1.add(getLabel_1(), "cell 0 2");
			panel_1.add(getTextFieldIme(), "cell 0 3,growx");
			panel_1.add(getLabel_2(), "cell 0 4");
			panel_1.add(getTextFieldPrezime(), "cell 0 5,growx");
			panel_1.add(getLabel_3(), "cell 0 6");
			panel_1.add(getTextFieldMaticniBroj(), "cell 0 7,growx");
			panel_1.add(getLabel_4(), "cell 0 8");
			panel_1.add(getTextFieldBodoviIzSkole(), "cell 0 9,growx");
			panel_1.add(getLblBodovi(), "cell 0 10");
		}
		return panel_1;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setPreferredSize(new Dimension(10, 50));
			panel_2.setLayout(new MigLayout("",
					"[79px][65px][71px][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[23px]"));
			panel_2.add(getBtnPocetak(), "cell 0 0,growx,aligny center");
			panel_2.add(getBtnSledeciOdgovor(), "cell 1 0,growx");
			panel_2.add(getRdbtnA(), "cell 3 0");
			panel_2.add(getRdbtnB(), "cell 4 0");
			panel_2.add(getRdbtnC(), "cell 5 0");
			panel_2.add(getRdbtnD(), "cell 6 0");
			panel_2.add(getRdbtnN(), "cell 7 0");
			panel_2.add(getBtnSacuvaj(), "cell 29 0,alignx left,aligny top");
		}
		return panel_2;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextAreaPitanja());
		}
		return scrollPane;
	}

	public JTextArea getTextAreaPitanja() {
		if (textAreaPitanja == null) {
			textAreaPitanja = new JTextArea();
			textAreaPitanja.setEditable(false);
		}
		return textAreaPitanja;
	}

	private JButton getBtnPocetak() {
		if (btnPocetak == null) {
			btnPocetak = new JButton("Kreni");
			btnPocetak.setVisible(false);
			btnPocetak.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnPocetak.setVisible(false);
					textAreaPitanja.setText("Odgovor na 1. pitanje je?");
					btnSledeciOdgovor.setVisible(true);
					rdbtnA.setVisible(true);
					rdbtnB.setVisible(true);
					rdbtnC.setVisible(true);
					rdbtnD.setVisible(true);
					rdbtnN.setVisible(true);

				}
			});
		}
		return btnPocetak;
	}

	double bodovi = 0;

	public JButton getBtnSacuvaj() {
		if (btnSacuvaj == null) {
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.setVisible(false);
			btnSacuvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnUcitajKandidata.setVisible(false);
					btnPocetak.setVisible(true);
					btnSacuvaj.setVisible(false);

					i = 0;
					for (int j = 0; j < 20; j++) {
						if (nizResenjaKandidata[j] == "N") {
							bodovi += 0;
						} else if (nizResenjaKandidata[j].equals(nizResenja[j])) {
							bodovi += 3;
						} else {
							bodovi = bodovi - 0.6;
						}
					}
					textAreaPitanja.setText("Pocnite unos sledeceg kandidata...");

					GUIKontroler.unesi();

					String poruka = "Ime: " + textFieldIme.getText() + "\nPrezime: " + textFieldPrezime.getText()
							+ "\nBroj bodova na prijemnom: " + bodovi;
					JOptionPane.showMessageDialog(null, poruka, "Kandidat je unet uspesno", JOptionPane.OK_OPTION);
					textFieldBodoviIzSkole.setText(null);
					textFieldIme.setText(null);
					textFieldMaticniBroj.setText(null);
					textFieldPrezime.setText(null);
					bodovi = 0;

				}
			});
		}
		return btnSacuvaj;
	}

	private JRadioButton getRdbtnA() {
		if (rdbtnA == null) {
			rdbtnA = new JRadioButton("A");
			rdbtnA.setVisible(false);
			buttonGroup.add(rdbtnA);
			rdbtnA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (rdbtnA.isSelected()) {

					}
				}
			});
		}
		return rdbtnA;
	}

	private JRadioButton getRdbtnB() {
		if (rdbtnB == null) {
			rdbtnB = new JRadioButton("B");
			rdbtnB.setVisible(false);
			buttonGroup.add(rdbtnB);
		}
		return rdbtnB;
	}

	private JRadioButton getRdbtnC() {
		if (rdbtnC == null) {
			rdbtnC = new JRadioButton("C");
			rdbtnC.setVisible(false);
			buttonGroup.add(rdbtnC);
		}
		return rdbtnC;
	}

	private JRadioButton getRdbtnD() {
		if (rdbtnD == null) {
			rdbtnD = new JRadioButton("D");
			rdbtnD.setVisible(false);
			buttonGroup.add(rdbtnD);
		}
		return rdbtnD;
	}

	private JRadioButton getRdbtnN() {
		if (rdbtnN == null) {
			rdbtnN = new JRadioButton("N");
			rdbtnN.setVisible(false);
			buttonGroup.add(rdbtnN);
		}
		return rdbtnN;
	}

	private JLabel getLabel_1() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime");
		}
		return lblIme;
	}

	private JLabel getLabel_2() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime");
		}
		return lblPrezime;
	}

	private JLabel getLabel_3() {
		if (lblMaticniBroj == null) {
			lblMaticniBroj = new JLabel("Maticni broj");
		}
		return lblMaticniBroj;
	}

	private JLabel getLabel_4() {
		if (lblBodoviIzSkole == null) {
			lblBodoviIzSkole = new JLabel("Bodovi iz skole");
		}
		return lblBodoviIzSkole;
	}

	public JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setEditable(false);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}

	public JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setEditable(false);
			textFieldPrezime.setColumns(10);
		}
		return textFieldPrezime;
	}

	public JTextField getTextFieldMaticniBroj() {
		if (textFieldMaticniBroj == null) {
			textFieldMaticniBroj = new JTextField();
			textFieldMaticniBroj.setEditable(false);
			textFieldMaticniBroj.setColumns(10);
		}
		return textFieldMaticniBroj;
	}

	public JTextField getTextFieldBodoviIzSkole() {
		if (textFieldBodoviIzSkole == null) {
			textFieldBodoviIzSkole = new JTextField();
			textFieldBodoviIzSkole.setEditable(false);
			textFieldBodoviIzSkole.setColumns(10);
		}
		return textFieldBodoviIzSkole;
	}

	String[] nizResenja = new String[20];

	private JButton getBtnUcitajResenja() {
		if (btnUcitajResenja == null) {
			btnUcitajResenja = new JButton("Ucitaj resenja");
			btnUcitajResenja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						JFileChooser fc = new JFileChooser();
						int opcija = fc.showOpenDialog(null);
						textAreaPitanja.setText("Ucitana su resenja sa lokacije: ");
						if (opcija == JFileChooser.APPROVE_OPTION) {
							File file = fc.getSelectedFile();
							textAreaPitanja.setText("Ucitana su resenja sa lokacije: " + file.getAbsolutePath());
							btnPocetak.setVisible(true);
							BufferedReader br = new BufferedReader(new FileReader(file));
							for (int i = 0; i < nizResenja.length; i++) {
								nizResenja[i] = br.readLine();
							}

						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
		}
		return btnUcitajResenja;
	}

	private JButton getBtnUcitajKandidata() {
		if (btnUcitajKandidata == null) {
			btnUcitajKandidata = new JButton("Ucitaj kandidata");
			btnUcitajKandidata.setVisible(false);
			btnUcitajKandidata.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziProzorKandidat();
				}
			});
		}
		return btnUcitajKandidata;
	}

	int i = 0;
	String[] nizResenjaKandidata = new String[20];
	private JLabel lblBodovi;

	private JButton getBtnSledeciOdgovor() {
		if (btnSledeciOdgovor == null) {
			btnSledeciOdgovor = new JButton("Sledeci odgovor");
			btnSledeciOdgovor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (i < 19) {
						if (rdbtnA.isSelected()) {
							nizResenjaKandidata[i] = "A";
						} else if (rdbtnB.isSelected()) {
							nizResenjaKandidata[i] = "B";
						} else if (rdbtnC.isSelected()) {
							nizResenjaKandidata[i] = "C";
						} else if (rdbtnD.isSelected()) {
							nizResenjaKandidata[i] = "D";
						} else if (rdbtnN.isSelected()) {
							nizResenjaKandidata[i] = "N";
						} else {
							JOptionPane.showMessageDialog(null, "Morate odabrati odgovor!", "Greska",
									JOptionPane.OK_OPTION);
							i--;
						}
						i++;
						textAreaPitanja.setText("Odgovor na " + (i + 1) + ". pitanje je?");
						// buttonGroup.clearSelection();
					} else {
						if (rdbtnA.isSelected()) {
							nizResenjaKandidata[i] = "A";
						} else if (rdbtnB.isSelected()) {
							nizResenjaKandidata[i] = "B";
						} else if (rdbtnC.isSelected()) {
							nizResenjaKandidata[i] = "C";
						} else if (rdbtnD.isSelected()) {
							nizResenjaKandidata[i] = "D";
						} else if (rdbtnN.isSelected()) {
							nizResenjaKandidata[i] = "N";
						} else {
							JOptionPane.showMessageDialog(null, "Morate odabrati odgovor!", "Greska",
									JOptionPane.OK_OPTION);
							i--;
						}
						btnSledeciOdgovor.setVisible(false);
						btnUcitajKandidata.setVisible(true);
						rdbtnA.setVisible(false);
						rdbtnB.setVisible(false);
						rdbtnC.setVisible(false);
						rdbtnD.setVisible(false);
						rdbtnN.setVisible(false);
						textAreaPitanja.setText("Uneti su svi odgovori, sad mozete da unesete kandidata!");

					}
				}
			});
			btnSledeciOdgovor.setVisible(false);
		}
		return btnSledeciOdgovor;
	}

	private JLabel getLblBodovi() {
		if (lblBodovi == null) {
			lblBodovi = new JLabel("");
			lblBodovi.setVisible(false);
		}
		return lblBodovi;
	}
}
