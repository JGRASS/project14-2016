package prijemni.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import prijemni.gui.GUIKontroler;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;

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
	
	/**
	 * @author Mladen Lukic
	 * Ovo dugme pokrece listu sa pitanjima
	 * @return
	 */
	public JButton getBtnPocetak() {
		if (btnPocetak == null) {
			btnPocetak = new JButton("Kreni");
			btnPocetak.setVisible(false);
			btnPocetak.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.pocniIzvrsenjeAplikacije();

				}
			});
		}
		return btnPocetak;
	}

	double bodovi = 0;
	
	/**
	 * @author Mladen Lukic
	 * Ovo dugme racuna ukupan broj bodova i serijalizuje podatke u tekstualni fajl koji korisnik odabere
	 * @return
	 */
	public JButton getBtnSacuvaj() {
		if (btnSacuvaj == null) {
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.setVisible(false);
			btnSacuvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					GUIKontroler.sacuvajPodatke();
				}
			});
		}
		return btnSacuvaj;
	}
	
	/**
	 * @author Mladen Lukic
	 * Ukoliko se selektuje ovaj RadioButton, znaci da je kandidat na postavljeno pitanje odgovorio pod A
	 * @return
	 */
	public JRadioButton getRdbtnA() {
		if (rdbtnA == null) {
			rdbtnA = new JRadioButton("A");
			rdbtnA.setVisible(false);
			buttonGroup.add(rdbtnA);
			rdbtnA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rdbtnA.isSelected()) {

					}
				}
			});
		}
		return rdbtnA;
	}
	
	/**
	 * @author Mladen Lukic
	 * Ukoliko se selektuje ovaj RadioButton, znaci da je kandidat na postavljeno pitanje odgovorio pod B
	 * @return
	 */
	public JRadioButton getRdbtnB() {
		if (rdbtnB == null) {
			rdbtnB = new JRadioButton("B");
			rdbtnB.setVisible(false);
			buttonGroup.add(rdbtnB);
		}
		return rdbtnB;
	}
	
	/**
	 * @author Mladen Lukic
	 * Ukoliko se selektuje ovaj RadioButton, znaci da je kandidat na postavljeno pitanje odgovorio pod C
	 * @return
	 */
	public JRadioButton getRdbtnC() {
		if (rdbtnC == null) {
			rdbtnC = new JRadioButton("C");
			rdbtnC.setVisible(false);
			buttonGroup.add(rdbtnC);
		}
		return rdbtnC;
	}
	
	/**
	 * @author Mladen Lukic
	 * Ukoliko se selektuje ovaj RadioButton, znaci da je kandidat na postavljeno pitanje odgovorio pod D
	 * @return
	 */
	public JRadioButton getRdbtnD() {
		if (rdbtnD == null) {
			rdbtnD = new JRadioButton("D");
			rdbtnD.setVisible(false);
			buttonGroup.add(rdbtnD);
		}
		return rdbtnD;
	}
	
	/**
	 * @author Mladen Lukic
	 * Ukoliko se selektuje ovaj RadioButton, znaci da je kandidat na postavljeno pitanje odgovorio pod N-ne znam
	 * @return
	 */
	public JRadioButton getRdbtnN() {
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

	
	/**
	 * @author Mladen Lukic
	 * Ovo dugme je na pocetku jedino koje se moze kliknuti, klikom na njega korisnik dobija mogucnost da odabere
	 * tekstualni fajl sa resenjima, ukoliko je fajl validan, moze se ucitati i nastaviti sa radom aplikacije
	 * @return
	 */
	public JButton getBtnUcitajResenja() {
		if (btnUcitajResenja == null) {
			btnUcitajResenja = new JButton("Ucitaj resenja");
			btnUcitajResenja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					GUIKontroler.ucitajResenja();
				}
			});
		}
		return btnUcitajResenja;
	}
	
	/**
	 * @author Mladen Lukic
	 * Ovo dugme otvara formu KandidatGUI u kom se unosi kandidat koji je radio dati prijemni 
	 * @return
	 */
	public JButton getBtnUcitajKandidata() {
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


	private JLabel lblBodovi;
	/**
	 * @author Mladen Lukic
	 * Klikom na ovo dugme unosi se odgovor na ponudjeno pitanje(sa RadioButton-a) i prelazi se na sledece pitanje
	 * @return
	 */
	public JButton getBtnSledeciOdgovor() {
		if (btnSledeciOdgovor == null) {
			btnSledeciOdgovor = new JButton("Sledeci odgovor");
			btnSledeciOdgovor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					GUIKontroler.idiNaSledecePitanje();
				}
			});
			btnSledeciOdgovor.setVisible(false);
		}
		return btnSledeciOdgovor;
	}

	public JLabel getLblBodovi() {
		if (lblBodovi == null) {
			lblBodovi = new JLabel("");
			lblBodovi.setVisible(false);
		}
		return lblBodovi;
	}

	public ButtonGroup getButtonGroup() {
		
		return buttonGroup;
	}
	
	
	
}
