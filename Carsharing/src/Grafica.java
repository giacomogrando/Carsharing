import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import java.text.SimpleDateFormat;



import java.util.Calendar;
//import java.util.Date;
import java.util.Date;

import javax.swing.JList;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;


public class Grafica {

	protected Shell shlCarsharing;
	private Text txtnome;
	Date dateTime = null;
	String nome = null;
	ArrayList<Noleggio> noleggi = new ArrayList<Noleggio>();

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Grafica window = new Grafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCarsharing.open();
		shlCarsharing.layout();
		while (!shlCarsharing.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCarsharing = new Shell();
		shlCarsharing.setSize(707, 528);
		shlCarsharing.setText("Carsharing");

		DateTime dateTime = new DateTime(shlCarsharing, SWT.BORDER);
		dateTime.setBounds(336, 142, 92, 24);

		Label label = new Label(shlCarsharing, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 300, 694, 10);

		List list = new List(shlCarsharing, SWT.BORDER);
		list.setBounds(23, 50, 173, 233);
		
		txtnome = new Text(shlCarsharing, SWT.BORDER);
		txtnome.setBounds(336, 99, 76, 21);

		Button btnNewButton = new Button(shlCarsharing, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nome = txtnome.getText();
				java.text.DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
				Date dataN = null;
				try {
					dataN = (Date)(data.parse(dateTime.getYear() + "-" + dateTime.getMonth() + "-" + dateTime.getDay()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				noleggi = Database.noleggiPerSocio(dataN, nome);
				
				list.removeAll(); // Ripulisco la lista
				
				for (int i = 0; i < noleggi.size(); i++) {
					list.add(noleggi.get(i).getAuto() + " " + noleggi.get(i).getCodice() + " " + noleggi.get(i).getInizio());
				}
				
				
				
			}
		});
		btnNewButton.setText("CERCA");
		btnNewButton.setBounds(245, 232, 124, 51);

		Label lblNewLabel = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Grafica.class, "/img/images.jpg"));
		lblNewLabel.setBounds(481, 0, 200, 227);

		Label lblNewLabel_1 = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel_1.setBounds(68, 19, 134, 25);
		lblNewLabel_1.setText("Elenco dei Nolleggi");

		Label lblCredenzialiRicerca = new Label(shlCarsharing, SWT.NONE);
		lblCredenzialiRicerca.setBounds(245, 35, 124, 15);
		lblCredenzialiRicerca.setText("Credenziali ricerca");

		Label label_1 = new Label(shlCarsharing, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(446, 1, 2, 299);

		Label lblNomeSocio = new Label(shlCarsharing, SWT.NONE);
		lblNomeSocio.setBounds(245, 105, 77, 15);
		lblNomeSocio.setText("Nome socio");

		

		Label lblDataInzio = new Label(shlCarsharing, SWT.NONE);
		lblDataInzio.setBounds(245, 151, 77, 15);
		lblDataInzio.setText("Data inzio");

	}
}
