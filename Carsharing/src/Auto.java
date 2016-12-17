
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

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getCosto(int costo_giornaliero) {
		return costo_giornaliero;
	}

	public void setCosto(int costo_giornaliero) {
		this.costo_giornaliero = costo_giornaliero;
	}
	
	

}
