package prijemni;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import prijemni.sistemsekoperacije.SOSerijalizacija;

public class Kandidat {

	private String ime;
	private String prezime;
	private String maticniBroj;
	private double brojBodovaIzSkole;
	private double brojBodovaNaPrijemnom;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public double getBrojBodovaIzSkole() {
		return brojBodovaIzSkole;
	}

	public void setBrojBodovaIzSkole(double d) {
		this.brojBodovaIzSkole = d;
	}

	public double getBrojBodovaNaPrijemnom() {
		return brojBodovaNaPrijemnom;
	}

	public void setBrojBodovaNaPrijemnom(double bodovi) {
		this.brojBodovaNaPrijemnom = bodovi;
	}

	
	public String toString() {
		return "Ime: " + getIme() + " \t\tPrezime: " + getPrezime() + " \t\tUKUPAN BROJ BODOVA: "
				+ (getBrojBodovaIzSkole() + getBrojBodovaNaPrijemnom());
	}

	public void serijalizacija(Kandidat k){
		
		SOSerijalizacija.izvrsi(k);
			
	}
		
	
	
	
}
