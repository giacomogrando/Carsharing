import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Database {

	/**
	 * Restituisce l'elenco degli amici presenti nella tabella amici
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<Noleggio> noleggiPerSocio(Date dataN, String nome) {
		ArrayList<Noleggio> elenco = new ArrayList<Noleggio>();
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;

		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			// Creo la connessione al database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");

			Calendar data = Calendar.getInstance();
			data.setTime(dataN);
			String sqlData = data.get(Calendar.YEAR) + "-" + (data.get(Calendar.MONTH) + 1) + "-"
					+ data.get(Calendar.DAY_OF_MONTH); // 2016-12-20

			sql = "SELECT codice_noleggio, auto, socio, inizio,  fine, auto_restituita, nome, cognome FROM noleggi INNER JOIN soci ON socio = soci.cf WHERE inizio = '"
					+ sqlData + "' AND nome = '" + nome + "' ";
			System.out.println(sql);
			// ________________________________query

			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement
			while (rs.next() == true) {
				Noleggio a = new Noleggio(rs.getInt("codice_noleggio"), rs.getString("auto"), rs.getString("nome"),
						rs.getString("cognome"), rs.getDate("inizio"), rs.getDate("fine"),
						rs.getBoolean("auto_restituita"));
				elenco.add(a);
			}

			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
			e.printStackTrace();
		} // fine try-catch

		return elenco;
	}

	public static ArrayList<Auto> nuovoNoleggio(Date inizio, Date fine) {
		ArrayList<Auto> elenco = new ArrayList<Auto>();
		Connection cn;
		Statement st;
		ResultSet rs;
		String sql;
		// ________________________________connessione
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		} // fine try-catch

		try {
			// Creo la connessione al database
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");

			Calendar dataI = Calendar.getInstance();
			dataI.setTime(inizio);
			String sqlDataI = dataI.get(Calendar.YEAR) + "-" + (dataI.get(Calendar.MONTH) + 1) + "-"
					+ dataI.get(Calendar.DAY_OF_MONTH); // 2016-12-20

			Calendar dataF = Calendar.getInstance();
			dataF.setTime(inizio);
			String sqlDataF = dataF.get(Calendar.YEAR) + "-" + (dataF.get(Calendar.MONTH) + 1) + "-"
					+ dataF.get(Calendar.DAY_OF_MONTH); // 2016-12-20

			sql = "SELECT DISTINCT auto.targa, auto.modello, auto.marca, auto.costo_giornaliero FROM noleggi, auto WHERE auto.targa=noleggi.auto AND inizio > '" + sqlDataF+ "'";
			System.out.println(sql);
			// ________________________________query

			st = cn.createStatement(); // creo sempre uno statement sulla
										// connessione
			st.execute(sql); // faccio la query su uno statement

			// connessione
			rs = st.executeQuery(sql); // faccio la query su uno statement
			while (rs.next() == true) {
				Auto a = new Auto(rs.getString("targa"), rs.getString("marca"), rs.getString("modello"),
						rs.getInt("costo_giornaliero"));
				elenco.add(a);
			}

			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch
		return elenco;

	}

	/**
	 * Inserisci un nuovo amico nella tabella
	 * 
	 * @return
	 * @throws SQLException
	 */
	/*
	 * public static void nuovoAmico(Amico a) { Connection cn; Statement st;
	 * String sql; // ________________________________connessione try {
	 * Class.forName("com.mysql.jdbc.Driver"); } catch (ClassNotFoundException
	 * e) { System.out.println("ClassNotFoundException: ");
	 * System.err.println(e.getMessage()); } // fine try-catch
	 * 
	 * try { // Creo la connessione al database cn =
	 * DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/carsharing?user=root&password=");
	 * 
	 * String nome = StringEscapeUtils.escapeSql(a.getNome()); String cognome =
	 * StringEscapeUtils.escapeSql(a.getCognome()); Calendar data =
	 * Calendar.getInstance(); data.setTime(a.getData()); String sqlData =
	 * data.get(Calendar.YEAR) + "-" + data.get(Calendar.MONTH) + "-" +
	 * data.get(Calendar.DAY_OF_MONTH); //2016-12-20
	 * 
	 * sql = "insert into amici (nome, cognome, dataNascita) values ('" + nome +
	 * "','" + cognome + "','" + sqlData + "')"; System.out.println(sql); //
	 * ________________________________query
	 * 
	 * st = cn.createStatement(); // creo sempre uno statement sulla //
	 * connessione st.execute(sql); // faccio la query su uno statement
	 * cn.close(); // chiusura connessione } catch (SQLException e) {
	 * System.out.println("errore:" + e.getMessage()); } // fine try-catch
	 * 
	 * }
	 * 
	 * 
	 * public static void modificaAmico(Amico a) { Connection cn; Statement st;
	 * String sql; // ________________________________connessione try {
	 * Class.forName("com.mysql.jdbc.Driver"); } catch (ClassNotFoundException
	 * e) { System.out.println("ClassNotFoundException: ");
	 * System.err.println(e.getMessage()); } // fine try-catch try { // Creo la
	 * connessione al database cn = DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/carsharing?user=root&password=");
	 * 
	 * // Inserisco nelle variabili i valori da modificare int id = a.getId();
	 * String nome = StringEscapeUtils.escapeSql(a.getNome()); String cognome =
	 * StringEscapeUtils.escapeSql(a.getCognome()); Calendar data =
	 * Calendar.getInstance(); data.setTime(a.getData()); String sqlData =
	 * data.get(Calendar.YEAR) + "-" + data.get(Calendar.MONTH) + "-" +
	 * data.get(Calendar.DAY_OF_MONTH);
	 * 
	 * sql = "update amici set nome='" + nome + "', cognome = '" + cognome +
	 * "', dataNascita='" + sqlData + "' where id=" + id;
	 * System.out.println(sql); // stampa la query //
	 * ________________________________query
	 * 
	 * st = cn.createStatement(); // creo sempre uno statement sulla //
	 * connessione st.execute(sql); // faccio la query su uno statement
	 * cn.close(); // chiusura connessione } catch (SQLException e) {
	 * System.out.println("errore:" + e.getMessage()); } // fine try-catch
	 * 
	 * }
	 * 
	 * 
	 * public static void eliminaAmico(Amico a) { Connection cn; Statement st;
	 * String sql; // ________________________________connessione try {
	 * Class.forName("com.mysql.jdbc.Driver"); } catch (ClassNotFoundException
	 * e) { System.out.println("ClassNotFoundException: ");
	 * System.err.println(e.getMessage()); } // fine try-catch try { // Creo la
	 * connessione al database cn = DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/carsharing?user=root&password=");
	 * 
	 * // Recupero l'id. Se volessi fare altri controlli potrei recuperare //
	 * anche gli altri valori int id = a.getId();
	 * 
	 * sql = "delete from amici where id=" + id; System.out.println(sql); //
	 * stampa la query // ________________________________query
	 * 
	 * st = cn.createStatement(); // creo sempre uno statement sulla //
	 * connessione st.execute(sql); // faccio la query su uno statement
	 * cn.close(); // chiusura connessione } catch (SQLException e) {
	 * System.out.println("errore:" + e.getMessage()); } // fine try-catch
	 * 
	 * }
	 * 
	 * public static void main(String[] args) throws SQLException,
	 * ParseException { java.text.DateFormat df = new
	 * SimpleDateFormat("yyyy-MM-dd"); Database.nuovoAmico(new Amico(1, "1",
	 * "2", df.parse("2016-10-10"))); Database.modificaAmico(new Amico(2,
	 * "Antonio", "Dall'Armi", df.parse("2000-10-10")));
	 * Database.eliminaAmico(new Amico(3, null, null, null));
	 * System.out.println(Database.elencoAmici()); }
	 */
}