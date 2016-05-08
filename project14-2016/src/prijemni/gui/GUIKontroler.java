package prijemni.gui;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import prijemni.Kandidat;

/**
 * Klasa sadrzi metode koje koriste forme KandidatGUI i PrijemniGUI
 * @author ValeVale i Mladen Lukic
 *
 */
public class GUIKontroler {
	/**
	 * promenljiva kojom se pristupa prozoru PrijemniGUI
	 */
	private static PrijemniGUI prijemni;
	/**
	 * promenljiva kojom se pristupa prozoru KandidatGUI
	 */
	private static KandidatGUI kandidat;
	/**
	 * Objekat klase Kandidat
	 */
	private static Kandidat k;
	/**
	 * niz Stringova koji predstavlja niz tacnih resenja zadataka iz fajla gde se nalaze
	 */
	static String[] nizResenja = new String[20];
	/**
	 * niz Stringova koji predstavlja resenja zadataka sa prijemnog kandidata
	 */
	static String[] nizResenjaKandidata = new String[20];
	
	static int i = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					prijemni = new PrijemniGUI();
					prijemni.setVisible(true);
					prijemni.setLocationRelativeTo(null);
					kandidat = new KandidatGUI();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Metoda koja prikazuje prozor Kandidat kad se klikne na dugme UcitajKandidata
	 */
	public static void prikaziProzorKandidat() {

		kandidat.setVisible(true);
		kandidat.setLocationRelativeTo(null);
	}
	/**
	 * Metoda koja gasi celu aplikaciju pritiskom na dugme x 
	 * Aplikacija ce se ugasiti samo kada se pritisne yes opcija na popup prozoru
	 */
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(prijemni.getContentPane(), "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}
	/**
	 * Metoda koja se pokrece na dugme Sacuvaj u prozoru Kandidat; podaci uneti u formu Kandidat se prebacuju u odgovarajuca
	 * polja u formi Prijemni 
	 * @throws Java.lang.Exception ako nije uneto  broj bodova manji od 12 ili veci od 40
	 * <ul> 
	 * <li> 13 brojeva kao maticni broj</li>
	 * <li> broj bodova manji od 12 ili veci od 40</li>
	 * </ul>
	 */
	public static void sacuvajPodatkeOKandidatu() {

		try {
			String ime;
			ime = kandidat.getTextFieldIme().getText();

			String prezime;
			prezime = kandidat.getTextFieldPrezime().getText();

			String maticniBroj;
			maticniBroj = kandidat.getTextFieldMaticniBroj().getText();
			long maticniBroj1 = Long.parseLong(maticniBroj);

			String bodoviIzSkole;
			bodoviIzSkole = kandidat.getTextFieldBodovi().getText();
			Double bodovi = Double.parseDouble(bodoviIzSkole);

			if (maticniBroj.length() == 13 && bodovi >= 12 && bodovi <= 40 && maticniBroj1>0) {
				prijemni.getTextFieldPrezime().setText(prezime);
				prijemni.getTextFieldMaticniBroj().setText(maticniBroj);
				prijemni.getTextFieldIme().setText(ime);
				prijemni.getTextFieldBodoviIzSkole().setText(bodoviIzSkole);

				if (prijemni.getTextFieldIme() != null && prijemni.getTextFieldPrezime() != null
						&& prijemni.getTextFieldMaticniBroj() != null && prijemni.getTextFieldBodoviIzSkole() != null) {
					kandidat.getTextFieldIme().setText(null);
					kandidat.getTextFieldPrezime().setText(null);
					kandidat.getTextFieldMaticniBroj().setText(null);
					kandidat.getTextFieldBodovi().setText(null);
					prijemni.getTextAreaPitanja().setText("Uneti su svi odgovori, sad mozete da ih sacuvate!");
					kandidat.dispose();
					
					prijemni.getBtnSacuvaj().setVisible(true);
				}
			} else {
				if (maticniBroj.length() != 13) {
					kandidat.getTextFieldMaticniBroj().setText(null);
				}
				if (bodovi < 12 || bodovi > 40) {
					kandidat.getTextFieldBodovi().setText(null);
				}
				JOptionPane.showMessageDialog(kandidat.getContentPane(), "Unesite ponovo pogresno uneti podatak!",
						"Greska", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			kandidat.getTextFieldBodovi().setText(null);
			kandidat.getTextFieldMaticniBroj().setText(null);
			JOptionPane.showMessageDialog(kandidat.getContentPane(),
					"Doslo je do greske prilikom unosa; unesite ponovo!", "Greska", JOptionPane.ERROR_MESSAGE);
		}

		
		
	}
	/**
	 * @author Mladen Lukic
	 * Ova metoda se pokrece klikom na dugme Sacuvaj, pomocu odgovarajucih tekstualnih polja formiraju se 
	 * podaci za novog kandidata i nakon toga njegovi podaci se serijalizuju
	 */
	public static void unesi(){
		
		k = new Kandidat();
		
		k.setIme(prijemni.getTextFieldIme().getText());
		k.setPrezime(prijemni.getTextFieldPrezime().getText());
		k.setMaticniBroj(prijemni.getTextFieldMaticniBroj().getText());
		k.setBrojBodovaIzSkole(Double.parseDouble(prijemni.getTextFieldBodoviIzSkole().getText()));
		k.setBrojBodovaNaPrijemnom(prijemni.bodovi);
		k.serijalizacija(k);
	}
	
	/**
	 * @author Mladen Lukic
	 * Ova metoda se pokrece klikom na dugme Kreni, to dugme se gubi, dobija se dugme Sledece pitanje i dobijaju se 
	 * Radio Button-i pomocu kojih krece unosenje odgovora kandidata
	 */
	public static void pocniIzvrsenjeAplikacije(){
		prijemni.getBtnPocetak().setVisible(false);
		prijemni.getTextAreaPitanja().setText("Odgovor na 1. pitanje je?");
		prijemni.getBtnSledeciOdgovor().setVisible(true);
		prijemni.getRdbtnA().setVisible(true);
		prijemni.getRdbtnB().setVisible(true);
		prijemni.getRdbtnC().setVisible(true);
		prijemni.getRdbtnD().setVisible(true);
		prijemni.getRdbtnN().setVisible(true);
	}
	
	/**
	 * @author Mladen Lukic
	 * Ova metoda se poziva klikom na dugme Sacuvaj, ona proverava dva niza nizResenja i nizResenjaKandidata i na osnovu
	 * poklapanja formira konacan broj bodova na prijemnom za odredjenog kandidata, i nakon toga serijalizuje njegove podatke
	 * u tekstualni fajl koji korisnik odabere
	 */
	public static void sacuvajPodatke(){
		prijemni.getBtnUcitajKandidata().setVisible(false);
		prijemni.getBtnPocetak().setVisible(true);
		prijemni.getBtnSacuvaj().setVisible(false);

		i = 0;
		for (int j = 0; j < 20; j++) {
			if (nizResenjaKandidata[j].equals("N")) {
				prijemni.bodovi += 0;
			} else if (nizResenjaKandidata[j].equalsIgnoreCase(nizResenja[j])) {
				prijemni.bodovi += 3;
			} else {
				prijemni.bodovi = prijemni.bodovi - 0.6;
			}
		}
		prijemni.getTextAreaPitanja().setText("Pocnite unos sledeceg kandidata...");

		GUIKontroler.unesi();

		String poruka = "Ime: " + prijemni.getTextFieldIme().getText() + "\nPrezime: " + prijemni.getTextFieldPrezime().getText()
				+ "\nBroj bodova na prijemnom: " + prijemni.bodovi;
		JOptionPane.showMessageDialog(null, poruka, "Kandidat je uspesno unet", JOptionPane.PLAIN_MESSAGE);
		prijemni.getTextFieldBodoviIzSkole().setText(null);
		prijemni.getTextFieldIme().setText(null);
		prijemni.getTextFieldMaticniBroj().setText(null);
		prijemni.getTextFieldPrezime().setText(null);
		prijemni.bodovi = 0;
	}
	
	/**
	 * @author Mladen Lukic
	 * Ova metoda se poziva kada se klikne dugme Ucitaj resenja, ucitava tacna resenja prijemnog ispita iz tekstualnog fajla koji korisnik odabere u niz nizResenja
	 */
	public static void ucitajResenja(){
		try {
			JFileChooser fc = new JFileChooser();
			int opcija = fc.showOpenDialog(null);
			if (opcija == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				BufferedReader br = new BufferedReader(new FileReader(file));
				for (int i = 0; i < nizResenja.length; i++) {
					nizResenja[i] = br.readLine();
				}
				boolean provera = false;
				for (int i = 0; i < nizResenja.length; i++) {
					if(!nizResenja[i].toUpperCase().startsWith("A") && !nizResenja[i].toUpperCase().startsWith("B") && !nizResenja[i].toUpperCase().startsWith("C") && !nizResenja[i].toUpperCase().startsWith("D")){
						provera=true;
						prijemni.getTextAreaPitanja().setText("Resenja na lokaciji: " + file.getAbsolutePath()+ " \nnisu validna, pokusajte ponovo!");
						break;
					}
				}
				if(!provera){
					prijemni.getBtnPocetak().setVisible(true);
					prijemni.getTextAreaPitanja().setText("Ucitana su resenja sa lokacije: " + file.getAbsolutePath());
				}
				br.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(prijemni.getContentPane(),
					"Doslo je do greske prilikom ucitavanja resenja!", "Greska", JOptionPane.ERROR_MESSAGE);
			prijemni.getTextAreaPitanja().setText("Resenja nisu validna, pokusajte ponovo!");
		} 

	}
	
	/**
	 * @author Mladen Lukic
	 * Metoda se pokrece klikom na dugme Sledece pitanje, ona proverava koji od Radio Button-a je selektovan
	 * i na osnovu toga puni nizResenjaKandidata sa njegovim resenjima, posle 20-og pitanja
	 * dugme se gasi(setVisible(false)), a dobijamo novo dugme Ucitaj kandidata
	 */
	public static void idiNaSledecePitanje(){
		if (i < 19) {
			if (prijemni.getRdbtnA().isSelected()) {
				nizResenjaKandidata[i] = "A";
			} else if (prijemni.getRdbtnB().isSelected()) {
				nizResenjaKandidata[i] = "B";
			} else if (prijemni.getRdbtnC().isSelected()) {
				nizResenjaKandidata[i] = "C";
			} else if (prijemni.getRdbtnD().isSelected()) {
				nizResenjaKandidata[i] = "D";
			} else if (prijemni.getRdbtnN().isSelected()) {
				nizResenjaKandidata[i] = "N";
			} else {
				JOptionPane.showMessageDialog(null, "Morate odabrati odgovor!", "Greska",
						JOptionPane.OK_OPTION);
				i--;
			}
			i++;
			prijemni.getTextAreaPitanja().setText("Odgovor na " + (i + 1) + ". pitanje je?");
			//buttonGroup.clearSelection();
		} else {
			if (prijemni.getRdbtnA().isSelected()) {
				nizResenjaKandidata[i] = "A";
			} else if (prijemni.getRdbtnB().isSelected()) {
				nizResenjaKandidata[i] = "B";
			} else if (prijemni.getRdbtnC().isSelected()) {
				nizResenjaKandidata[i] = "C";
			} else if (prijemni.getRdbtnD().isSelected()) {
				nizResenjaKandidata[i] = "D";
			} else if (prijemni.getRdbtnN().isSelected()) {
				nizResenjaKandidata[i] = "N";
			} else {
				JOptionPane.showMessageDialog(null, "Morate odabrati odgovor!", "Greska",
						JOptionPane.OK_OPTION);
				i--;
			}
			prijemni.getBtnSledeciOdgovor().setVisible(false);
			prijemni.getBtnUcitajKandidata().setVisible(true);
			prijemni.getRdbtnA().setVisible(false);
			prijemni.getRdbtnB().setVisible(false);
			prijemni.getRdbtnC().setVisible(false);
			prijemni.getRdbtnD().setVisible(false);
			prijemni.getRdbtnN().setVisible(false);
			prijemni.getTextAreaPitanja().setText("Uneti su svi odgovori, sad mozete da unesete kandidata!");

		}
	}
	
	
	
}
