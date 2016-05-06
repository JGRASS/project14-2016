package prijemni.sistemsekoperacije;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import prijemni.Kandidat;

public class SOSerijalizacija {

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
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
}
