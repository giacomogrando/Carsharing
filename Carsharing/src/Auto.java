
public class Auto {
	
	String targa;
	String marca;
	String modello;
	int costo_giornaliero;

	public Auto(String targa, String marca, String modello, int costo_giornaliero) {
		super();
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.costo_giornaliero = costo_giornaliero;
	}

	public String getCf() {
		return cf;
	}

	public void setId(String cf) {
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo(String indirizzo) {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getTelefono(String telefono) {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


}
