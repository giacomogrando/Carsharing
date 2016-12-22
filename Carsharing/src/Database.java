import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Database {
	private static Connection cn;
	private static Statement st;
	private static ResultSet rs;

	ArrayList<Noleggio> elenco = new ArrayList<Noleggio>();
	String sql;

	// Creo la connessione al database
	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/carsharing?user=root&password=");

	sql="SELECT * FROM noleggi WHERE inizio>='"+dataI+"' AND socio='"+nome+"';";
	// ________________________________query

	st=cn.createStatement(); // creo sempre uno statement sulla
								// connessione
	rs=st.executeQuery(sql); // faccio la query su uno statement
	while(rs.next()==true)

	{
		Noleggio n = new Noleggio(rs.getString("codice_noleggio"), rs.getString("auto"), rs.getString("socio"),
				rs.getDate("inizio"), rs.getDate("fine"), rs.getInt("auto_restituita"));
		elenco.add(n);
	}

	cn.close(); // chiusura connessione

	return elenco;
}}
