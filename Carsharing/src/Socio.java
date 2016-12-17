
public class Socio {
	
	
		String cf;
		String nome;
		String cognome;
		String indirizzo;
		String telefono;

		public Socio(String cf, String nome, String cognome, String indirizzo, String telefono) {
			super();
			this.cf = cf;
			this.nome = nome;
			this.cognome = cognome;
			this.indirizzo = indirizzo;
			this.telefono = telefono;
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


