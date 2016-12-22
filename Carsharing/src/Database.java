import java.io.IOException;
import java.sql.*;

public class Database {
	public static void main(String[] args) {
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
			// modifico nome database con il mio (prova)

			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");
			// jdbc:mysql://localhost:3306/Contatti?user=root&password=secret

			sql = "SELECT * FROM noleggi;";
			// ________________________________query
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() == true) {
				
				System.out.println(rs.getInt("codice_noleggio") + "\t" + rs.getString("auto") + "\t"
						+ rs.getString("socio") + "\t" + rs.getDate("inzio") + "\t" + rs.getDate("fine") + "\t"
						+ rs.getBoolean("auto_restituita"));

			}
			cn.close(); // chiusura connessione
		} catch (SQLException e) {
			System.out.println("errore:" + e.getMessage());
		} // fine try-catch

	}// fine main
}// fine classe
