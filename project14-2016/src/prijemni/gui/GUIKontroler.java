package prijemni.gui;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import prijemni.Kandidat;

public class GUIKontroler {

	private static PrijemniGUI prijemni;
	private static KandidatGUI kandidat;
	private static Kandidat k;
	static String[] nizResenja = new String[20];
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

	public static void prikaziProzorKandidat() {

		kandidat.setVisible(true);
		kandidat.setLocationRelativeTo(null);
	}

	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(prijemni.getContentPane(), "Da li zelite da zatvorite program?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public static void sacuvajPodatkeOKandidatu() {

		try {
			String ime;
			ime = kandidat.getTextFieldIme().getText();

			String prezime;
			prezime = kandidat.getTextFieldPrezime().getText();

			String maticniBroj;
			maticniBroj = kandidat.getTextFieldMaticniBroj().getText();

			String bodoviIzSkole;
			bodoviIzSkole = kandidat.getTextFieldBodovi().getText();
			Double bodovi = Double.parseDouble(bodoviIzSkole);

			if (maticniBroj.length() == 13 && bodovi >= 12 && bodovi <= 40) {
				prijemni.getTextFieldPrezime().setText(prezime);
				prijemni.getTextFieldMaticniBroj().setText(maticniBroj);
				;
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
			JOptionPane.showMessageDialog(kandidat.getContentPane(),
					"Doslo je do greske prilikom unosa; unesite ponovo!", "Greska", JOptionPane.ERROR_MESSAGE);
		}

		
		
	}
	
	public static void unesi(){
		
		k = new Kandidat();
		
		k.setIme(prijemni.getTextFieldIme().getText());
		k.setPrezime(prijemni.getTextFieldPrezime().getText());
		k.setMaticniBroj(prijemni.getTextFieldMaticniBroj().getText());
		k.setBrojBodovaIzSkole(Double.parseDouble(prijemni.getTextFieldBodoviIzSkole().getText()));
		k.setBrojBodovaNaPrijemnom(prijemni.bodovi);
		k.serijalizacija(k);
	}
	
	
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
	
	
	public static void sacuvajPodatke(){
		prijemni.getBtnUcitajKandidata().setVisible(false);
		prijemni.getBtnPocetak().setVisible(true);
		prijemni.getBtnSacuvaj().setVisible(false);

		i = 0;
		for (int j = 0; j < 20; j++) {
			if (nizResenjaKandidata[j] == "N") {
				prijemni.bodovi += 0;
			} else if (nizResenjaKandidata[j].equals(nizResenja[j])) {
				prijemni.bodovi += 3;
			} else {
				prijemni.bodovi = prijemni.bodovi - 0.6;
			}
		}
		prijemni.getTextAreaPitanja().setText("Pocnite unos sledeceg kandidata...");

		GUIKontroler.unesi();

		String poruka = "Ime: " + prijemni.getTextFieldIme().getText() + "\nPrezime: " + prijemni.getTextFieldPrezime().getText()
				+ "\nBroj bodova na prijemnom: " + prijemni.bodovi;
		JOptionPane.showMessageDialog(null, poruka, "Kandidat je unet uspesno", JOptionPane.OK_OPTION);
		prijemni.getTextFieldBodoviIzSkole().setText(null);
		prijemni.getTextFieldIme().setText(null);
		prijemni.getTextFieldMaticniBroj().setText(null);
		prijemni.getTextFieldPrezime().setText(null);
		prijemni.bodovi = 0;
	}
	
	
	public static void ucitajResenja(){
		try {
			JFileChooser fc = new JFileChooser();
			int opcija = fc.showOpenDialog(null);
			prijemni.getTextAreaPitanja().setText("Ucitana su resenja sa lokacije: ");
			if (opcija == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				prijemni.getTextAreaPitanja().setText("Ucitana su resenja sa lokacije: " + file.getAbsolutePath());
				prijemni.getBtnPocetak().setVisible(true);
				BufferedReader br = new BufferedReader(new FileReader(file));
				for (int i = 0; i < nizResenja.length; i++) {
					nizResenja[i] = br.readLine();
				}

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(prijemni.getContentPane(),
					"Doslo je do greske prilikom ucitavanja resenja!", "Greska", JOptionPane.ERROR_MESSAGE);
		} 

	}
	
	
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
