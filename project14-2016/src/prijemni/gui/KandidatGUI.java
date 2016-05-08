package prijemni.gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
			lblImeKandidata = new JLabel("Ime:");
			lblImeKandidata.setBounds(23, 38, 104, 14);
		}
		return lblImeKandidata;
	}
	/**
	 * Unosi se ime kandidata kao String
	 * @return textFieldIme koje sadrzi ime kandidata
	 */
	public JTextField getTextFieldIme() {
		if (textFieldIme == null) {
			textFieldIme = new JTextField();
			textFieldIme.setBounds(137, 35, 107, 20);
			textFieldIme.setColumns(10);
		}
		return textFieldIme;
	}
	
	private JLabel getLblPrezimeKandidata() {
		if (lblPrezimeKandidata == null) {
			lblPrezimeKandidata = new JLabel("Prezime:");
			lblPrezimeKandidata.setBounds(23, 86, 104, 14);
		}
		return lblPrezimeKandidata;
	}
	/**
	 * Unosise prezime kandidata kao String
	 * @return textFieldPrezime koje sadrzi prezime kandidata
	 */
	public JTextField getTextFieldPrezime() {
		if (textFieldPrezime == null) {
			textFieldPrezime = new JTextField();
			textFieldPrezime.setBounds(137, 83, 107, 20);
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
	/**
	 * Unosi se maticni broj kandidata kao String koji mora biti duzine 13 
	 * @return textFieldMaticniBroj koji sadrzi maticni broj kandidata
	 */
	public JTextField getTextFieldMaticniBroj() {
		if (textFieldMaticniBroj == null) {
			textFieldMaticniBroj = new JTextField();
			textFieldMaticniBroj.setBounds(137, 133, 107, 20);
			textFieldMaticniBroj.setColumns(10);
		}
		return textFieldMaticniBroj;
	}

	private JLabel getLblBrojBodovaIz() {
		if (lblBrojBodovaIz == null) {
			lblBrojBodovaIz = new JLabel("Bodovi iz skole:");
			lblBrojBodovaIz.setBounds(23, 185, 104, 14);
		}
		return lblBrojBodovaIz;
	}
	/**
	 * Unosi se broj bodova iz skole kao String koji mora biti broj jer se parsuje posle
	 * @return textFieldBodovi koji sadrzi broj bodova iz skole kandidata
	 */
	public JTextField getTextFieldBodovi() {
		if (textFieldBodovi == null) {
			textFieldBodovi = new JTextField();
			textFieldBodovi.setBounds(137, 182, 107, 20);
			textFieldBodovi.setColumns(10);
		}
		return textFieldBodovi;
	}
	/**
	 * Klikom na dugme sacuvaj prebacuju se podaci uneti u formu KandidatGUI u odgovarajuca polja u formi
	 * PrijemniGUI i brisu se polja u formi KandidatGUI nakon uspesnog prenosenja podataka
	 * @return btnUcitajPodatke dugme koje pokrece ovu akciju
	 */
	private JButton getBtnUcitajPodatke() {
		if (btnUcitajPodatke == null) {
			btnUcitajPodatke = new JButton("Sacuvaj");
			btnUcitajPodatke.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.sacuvajPodatkeOKandidatu();
				}
			});
			btnUcitajPodatke.setBounds(85, 227, 104, 23);
		}
		return btnUcitajPodatke;
	}
}
