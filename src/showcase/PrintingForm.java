package showcase;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PrintingForm {

	/*****************************************************************
	 * Creates and displays the 3d printing request form
	 *****************************************************************/
	public void createAndShowForm() {
		JFrame frame = form();
		frame.pack();
		frame.setVisible(true);
	}

	private JFrame form() {
		// Window / frame dimensions
		Toolkit tk = Toolkit.getDefaultToolkit();
		int screen_width = tk.getScreenSize().width;
		int screen_height = tk.getScreenSize().height;
		Dimension dim = new Dimension(screen_width, screen_height);
		Dimension third_of_screen = new Dimension(screen_width / 3, screen_height / 3);

		// Create / set up frame
		JFrame frame = new JFrame("3D Print Request Form");
		Container container = new Container();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(dim.width / 3, dim.height / 2);
		frame.setUndecorated(false);
		frame.setMinimumSize(third_of_screen);
		frame.setLocation(screen_width / 3, screen_height / 3);
		
		return frame;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				PrintingForm form = new PrintingForm();
				form.createAndShowForm();
			}
		});

	}

}
