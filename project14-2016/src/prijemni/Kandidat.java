package prijemni;

import prijemni.sistemsekoperacije.SOSerijalizacija;
/**
 * Klasa sadrzi podatke o kandidatu koji polaze prijemni
 * @author ValeVale
 */
public class Kandidat {

	/**
	 * Ime kandidata se unosi kao String
	 */
	private String ime;
	/**
	 * Prezime kandidata se unosi kao String
	 */
	private String prezime;
	/**
	 * Maticni broj kandidata se unosi kao String
	 */
	private String maticniBroj;
	/**
	 * Broj bodova iz skole koje je kandidat imao se unosi kao double
	 */
	private double brojBodovaIzSkole;
	/**
	 * Broj osvojenih bodova na prijemnom se unosi kao double
	 */
	
	private double brojBodovaNaPrijemnom;
	
	/**
	 * Metoda vraca ime kandidata koji polaze
	 * @return ime ime kandidata
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * Metoda postavalja ime kandidata 
	 * @param ime koji se unosi kao String
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}
	/**
	 * Metoda vraca prezime kandidata koji polaze
	 * @return prezime prezime kandidata
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * Metoda postavlja prezime kandidata
	 * @param prezime koji se unosi kao String
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	/**
	 * Metoda varca maticni broj kanidata koji polaze
	 * @return maticniBroj maticni broj kandidata
	 */
	public String getMaticniBroj() {
		return maticniBroj;
	}
	/**
	 * Metoda postavlja maticni broj kandidata 
	 * @param maticniBroj maticni broj kandidata koji se unosi kao String
	 */
	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}
	/**
	 * Metoda vraca broj bodova iz srednje skole kandidata koji polaze
	 * @return brojBodovaIzSkole broj bodova kandidata iz srednje skole
	 */
	public double getBrojBodovaIzSkole() {
		return brojBodovaIzSkole;
	}
	/**
	 * Metoda postavlja broj bodova iz skole kandidata koji polaze
	 * @param d broj bodova iz skole koji se unosi kao double
	 */
	public void setBrojBodovaIzSkole(double d) {
		this.brojBodovaIzSkole = d;
	}
	/**
	 * Metoda vraca broj bodova koje je kandidat osvojio na prijemnom
	 * @return brojBodovaNaPrijemnom broj bodova kandidata na prijemnom
	 */
	public double getBrojBodovaNaPrijemnom() {
		return brojBodovaNaPrijemnom;
	}
	/**
	 * Metoda postavlja broj bodova kandidata na prijemnom
	 * @param bodovi broj bodova kandidata na prijemnom koji se unosi kao double
	 */
	public void setBrojBodovaNaPrijemnom(double bodovi) {
		this.brojBodovaNaPrijemnom = bodovi;
	}

	/**
	 * toString metoda ispisuje ime i prezime kandidata kao i ukupan broj bodova 
	 * osvojenih na prijemnom(broj bodova iz skole + broj bodova sa prijemnog)
	 */
	public String toString() {
		return "Ime: " + getIme() + " \t\tPrezime: " + getPrezime() + " \t\tUKUPAN BROJ BODOVA: "
				+ (getBrojBodovaIzSkole() + getBrojBodovaNaPrijemnom());
	}
	/**
	 * Metoda upisuje podatke o kandidatu u fajl
	 * @param k objekat klase Kandidat koji predstavkja kandidata kog treba upisati u fajl
	 */
	public void serijalizacija(Kandidat k){
		
		SOSerijalizacija.izvrsi(k);
			
	}
		
	
	
	
}
