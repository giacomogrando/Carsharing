import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class Grafica {

	protected Shell shlCarsharing;

	/**
	 * Launch the application.
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
		shlCarsharing.setSize(688, 507);
		shlCarsharing.setText("Carsharing");
		
		Label label = new Label(shlCarsharing, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 233, 694, 10);
		
		List list = new List(shlCarsharing, SWT.BORDER);
		list.setBounds(23, 10, 200, 195);
		
		Button btnNewButton = new Button(shlCarsharing, SWT.NONE);
		btnNewButton.setText("ELENCO NOLLEGGI");
		btnNewButton.setBounds(259, 22, 114, 70);
		
		Label lblNewLabel = new Label(shlCarsharing, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(Grafica.class, "/img/images.jpg"));
		lblNewLabel.setBounds(462, 0, 200, 227);

	}
}
