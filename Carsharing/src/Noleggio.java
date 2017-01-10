import java.sql.Date;

public class Noleggio {
	
	int codice;
	String auto;
	String nome;
	String cognome;
	Date inizio;
	Date fine;
	boolean restituita;

	public Noleggio(int codice, String auto, String nome, String cognome, Date inizio, Date fine, boolean restituita) {
		this.codice = codice;
		this.auto = auto;
		this.nome = nome;
		this.cognome = cognome;
		this.inizio = inizio;
		this.fine = fine;
		this.restituita = restituita;
	}
	

	public int getCodice() {
		return codice;
	}
	
	public String getCognome() {
		return cognome;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInizio() {
		return inizio;
	}

	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}
	
	public Date getFine() {
		return fine;
	}

	public void setFine(Date fine) {
		this.fine = fine;
	}
	
	public boolean getrestituita() {
		return restituita;
	}
	public void setrestituita(boolean restituita) {
		this.restituita = restituita;
	}
}
