package prijemni.gui;

import java.awt.EventQueue;

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
		
		String ime;
		ime = kandidat.getTextFieldIme().getText();
		prijemni.getTextFieldIme().setText(ime);
		
		String prezime;
		prezime = kandidat.getTextFieldPrezime().getText();
		prijemni.getTextFieldPrezime().setText(prezime);
		
		String maticniBroj;
		maticniBroj = kandidat.getTextFieldMaticniBroj().getText();
		prijemni.getTextFieldMaticniBroj().setText(maticniBroj);;
		
		String bodoviIzSkole;
		bodoviIzSkole = kandidat.getTextFieldBodovi().getText();
		prijemni.getTextFieldBodoviIzSkole().setText(bodoviIzSkole);
		
		kandidat.dispose();
	}
	
	
	
}
