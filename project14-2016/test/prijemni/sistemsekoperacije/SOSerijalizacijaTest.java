package prijemni.sistemsekoperacije;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import prijemni.Kandidat;

public class SOSerijalizacijaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIzvrsi() throws IOException {
		Kandidat k = new Kandidat();
		k.setIme("Mladen");
		k.setPrezime("Lukic");
		k.setBrojBodovaIzSkole(40);
		k.setMaticniBroj("1234567891234");
		PrintWriter pw;
		pw = new PrintWriter(new BufferedWriter(new FileWriter("test.txt", true)));
		pw.println(k.toString());
		pw.close();
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String provera = br.readLine();
		assertEquals(provera, k.toString());
	}
}



