package prijemni;

public class Kandidat {

	private String ime;
	private String prezime;
	private String maticniBroj;
	private int brojBodovaIzSkole;
	private int brojBodovaNaPrijemnom;
	
	
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
	
	public int getBrojBodovaIzSkole() {
		return brojBodovaIzSkole;
	}
	
	public void setBrojBodovaIzSkole(int brojBodovaIzSkole) {
		this.brojBodovaIzSkole = brojBodovaIzSkole;
	}

	public int getBrojBodovaNaPrijemnom() {
		return brojBodovaNaPrijemnom;
	}

	public void setBrojBodovaNaPrijemnom(int brojBodovaNaPrijemnom) {
		this.brojBodovaNaPrijemnom = brojBodovaNaPrijemnom;
	}
	
	@Override
	public String toString() {
		return "Ime: " +getIme() + " Prezime " + getPrezime() + " UKUPAN BROJ BODOVA: " +(getBrojBodovaIzSkole()+getBrojBodovaNaPrijemnom()); 
	}
	
}
