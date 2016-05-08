package prijemni.sistemsekoperacije;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import prijemni.Kandidat;

public class SOSerijalizacija {
	/**
	 * @author Mladen Lukic
	 * Metoda prima kandidata sa njegovim brojem ostvarenih bodova i serijalizuje ga u tekstualni fajl koji korisnik odabere
	 * @throws java.lang.Exception Baca gresku prilikom input/output operacija
	 * @param k Kandidat dobijen iz GUI forme
	 */
	public static void izvrsi(Kandidat k){
		
		JFileChooser fc = new JFileChooser();
		int opcija = fc.showSaveDialog(null);
		if(opcija==JFileChooser.APPROVE_OPTION){
			File fajl = fc.getSelectedFile();
			PrintWriter pw;
			try {
				pw = new PrintWriter(new BufferedWriter(new FileWriter(fajl, true)));
				pw.print("\n");
				pw.println(k.toString());
				pw.close();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Doslo je do greske prilikom serijalizacije", "Greska", 
						JOptionPane.OK_OPTION);
			}
	}
	}
}
