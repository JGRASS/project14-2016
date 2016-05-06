package prijemni.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JOptionPane;



public class GUIKontroler {

	private static PrijemniGUI prijemni;
	private static KandidatGUI kandidat;
	
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
	
	public static void prikaziProzorKandidat(){
		
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
	
	public static void sacuvajPodatkeOKandidatu(){
		
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
			
			if(maticniBroj.length() == 13 && bodovi>=12 && bodovi<=40){
				prijemni.getTextFieldPrezime().setText(prezime);
				prijemni.getTextFieldMaticniBroj().setText(maticniBroj);;
				prijemni.getTextFieldIme().setText(ime);
				prijemni.getTextFieldBodoviIzSkole().setText(bodoviIzSkole);
				
				if(prijemni.getTextFieldIme()!=null && prijemni.getTextFieldPrezime()!=null && prijemni.getTextFieldMaticniBroj()!=null
						&& prijemni.getTextFieldBodoviIzSkole()!=null){
					kandidat.getTextFieldIme().setText(null);
					kandidat.getTextFieldPrezime().setText(null);
					kandidat.getTextFieldMaticniBroj().setText(null);
					kandidat.getTextFieldBodovi().setText(null);
					kandidat.dispose();
				}
			}else{
				if(maticniBroj.length()!=13){
					kandidat.getTextFieldMaticniBroj().setText(null);
				}
				if(bodovi<12 || bodovi >40){
					kandidat.getTextFieldBodovi().setText(null);
				}
					JOptionPane.showMessageDialog(kandidat.getContentPane(), "Unesite ponovo pogresno uneti podatak!", "Greska",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			kandidat.getTextFieldBodovi().setText(null);
			JOptionPane.showMessageDialog(kandidat.getContentPane(), "Doslo je do greske prilikom unosa; unesite ponovo!",
					"Greska", JOptionPane.ERROR_MESSAGE);
		} 
		
	
		
		
		
	}
	
	
	
}
