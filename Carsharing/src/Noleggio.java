import java.sql.Date;

public class Noleggio {
	
	int codice;
	String auto;
	String socio;
	Date inizio;
	Date fine;
	boolean restituita;

	public Noleggio(int codice, String auto, String socio, Date inizio, Date fine, boolean restituita) {
		super();
		this.codice = codice;
		this.auto = auto;
		this.socio = socio;
		this.inizio = inizio;
		this.fine = fine;
		this.restituita = restituita;
	}

	public int getCodice() {
		return codice;
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

	public String getSocio() {
		return socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}

	public Date getInizio(Date inizio) {
		return inizio;
	}

	public void setInizio(Date inizio) {
		this.inizio = inizio;
	}
	
	public Date getFine(Date fine) {
		return fine;
	}

	public void setFine(Date fine) {
		this.fine = fine;
	}
	
	public boolean getRestituita(boolean restituita) {
		return restituita;
	}

	public void setRestituita(boolean restituita) {
		this.restituita = restituita;
	}


}