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
	ArrayList<Auto> auto = new ArrayList<Auto>();
	

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
		label.setBounds(0, 275, 714, 10);

		List list = new List(shlCarsharing, SWT.BORDER);
		list.setBounds(10, 89, 76, 180);
		
		txtnome = new Text(shlCarsharing, SWT.BORDER);
		txtnome.setBounds(352, 102, 76, 21);
		
		Label lblDataInzio = new Label(shlCarsharing, SWT.NONE);
		lblDataInzio.setBounds(264, 151, 64, 15);
		lblDataInzio.setText("Data inzio");
		
		List list_1 = new List(shlCarsharing, SWT.BORDER);
		list_1.setBounds(92, 89, 76, 180);
		
		List list_2 = new List(shlCarsharing, SWT.BORDER);
		list_2.setBounds(174, 89, 76, 180);
		
		Label lblNome = new Label(shlCarsharing, SWT.NONE);
		lblNome.setBounds(10, 69, 55, 15);
		lblNome.setText("Nome");
		
		Label lblAuto = new Label(shlCarsharing, SWT.NONE);
		lblAuto.setBounds(92, 69, 55, 15);
		lblAuto.setText("Auto");
		
		Label lblDataInizio = new Label(shlCarsharing, SWT.NONE);
		lblDataInizio.setBounds(174, 69, 55, 15);
		lblDataInizio.setText("Data inizio");

		Button btnNewButton = new Button(shlCarsharing, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nome = txtnome.getText();
				java.text.DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
				Date dataN = null;
				try {
					dataN = (Date)(data.parse(dateTime.getYear() + "-" + (dateTime.getMonth()+1) + "-" + dateTime.getDay()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				noleggi = Database.noleggiPerSocio(dataN, nome);
			
				
				for (int i = 0; i < noleggi.size(); i++) {
					list.add(noleggi.get(i).getNome());
					list_1.add(noleggi.get(i).getAuto());
					list_2.add(noleggi.get(i).getInizio().toString());
				}
				
				
				
			}
		});
		btnNewButton.setText("CERCA");
		btnNewButton.setBounds(281, 187, 124, 51);

		Label lblNewLabel = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Grafica.class, "/img/images.jpg"));
		lblNewLabel.setBounds(481, 0, 200, 227);

		Label lblNewLabel_1 = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel_1.setBounds(69, 25, 134, 25);
		lblNewLabel_1.setText("Elenco dei Noleggi");

		Label lblCredenzialiRicerca = new Label(shlCarsharing, SWT.NONE);
		lblCredenzialiRicerca.setBounds(304, 69, 124, 15);
		lblCredenzialiRicerca.setText("Credenziali ricerca");

		Label label_1 = new Label(shlCarsharing, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBounds(446, 1, 2, 277);

		Label lblNomeSocio = new Label(shlCarsharing, SWT.NONE);
		lblNomeSocio.setBounds(264, 105, 77, 15);
		lblNomeSocio.setText("Nome socio");
		
		Label lblInizio = new Label(shlCarsharing, SWT.NONE);
		lblInizio.setBounds(319, 331, 55, 15);
		lblInizio.setText("Inizio :");
		
		Label lblFine = new Label(shlCarsharing, SWT.NONE);
		lblFine.setBounds(419, 331, 55, 15);
		lblFine.setText("Fine : ");
		
		List list_10 = new List(shlCarsharing, SWT.BORDER);
		list_10.setBounds(15, 312, 71, 168);
		
		List list_20 = new List(shlCarsharing, SWT.BORDER);
		list_20.setBounds(112, 312, 71, 168);
		
		List list_30 = new List(shlCarsharing, SWT.BORDER);
		list_30.setBounds(207, 312, 71, 168);
		
		Label lblTarga = new Label(shlCarsharing, SWT.NONE);
		lblTarga.setBounds(15, 291, 55, 15);
		lblTarga.setText("Targa ");
		
		Label lblMarca = new Label(shlCarsharing, SWT.NONE);
		lblMarca.setBounds(113, 291, 55, 15);
		lblMarca.setText("Marca");
		
		Label lblModello = new Label(shlCarsharing, SWT.NONE);
		lblModello.setBounds(207, 291, 55, 15);
		lblModello.setText("Modello");

		
		Button btnAutoDisponibili = new Button(shlCarsharing, SWT.NONE);
		btnAutoDisponibili.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				java.text.DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
				Date dataInizio = null;
				try {
					dataInizio = (Date)(data.parse(dateTime.getYear() + "-" + (dateTime.getMonth()+1) + "-" + dateTime.getDay()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				java.text.DateFormat data1 = new SimpleDateFormat("yyyy-MM-dd");
				Date dataFine = null;
				try {
					dataFine = (Date)(data.parse(dateTime.getYear() + "-" + (dateTime.getMonth()+1) + "-" + dateTime.getDay()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				auto = Database.nuovoNoleggio(dataInizio, dataFine);
			
				
				for (int i = 0; i < auto.size(); i++) {
					list_10.add(auto.get(i).getTarga());
					list_20.add(auto.get(i).getMarca());
					list_30.add(auto.get(i).getModello());
				}
			}
		});
		btnAutoDisponibili.setBounds(537, 351, 124, 25);
		btnAutoDisponibili.setText("Auto disponibili");
		
		DateTime dInizio = new DateTime(shlCarsharing, SWT.BORDER);
		dInizio.setBounds(320, 369, 80, 24);
		
		DateTime dFine = new DateTime(shlCarsharing, SWT.BORDER);
		dFine.setBounds(419, 369, 80, 24);
		
		
		

		

	}
}
