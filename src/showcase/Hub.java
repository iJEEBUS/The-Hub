package showcase;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class Hub extends JFrame {
	/*****************************************************************
	 * Generated Serialized ID number
	 *****************************************************************/
	private static final long serialVersionUID = 2833726655594634320L;

	/*****************************************************************
	 * Constructor for the GUI class. Creates and sets visible the 
	 * custom frame.
	 *****************************************************************/
	public Hub() {
		JFrame frame = customFrame();
		frame.pack();
		frame.setVisible(true);
	}

	/*****************************************************************
	 * Custom frame that uses the hub background.
	 * 
	 * @return frame - the custom JFrame
	 *****************************************************************/
	private JFrame customFrame() {

		// Window / frame dimensions
		Toolkit tk = Toolkit.getDefaultToolkit();
		int screen_width = tk.getScreenSize().width;
		int screen_height = tk.getScreenSize().height;
		Dimension dim = new Dimension(screen_width, screen_height);

		// Create / set up frame
		JFrame frame = new JFrame("The Hub");
		Container container = new Container();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(dim);
		frame.setUndecorated(true);
		frame.setMinimumSize(dim);

		// Create backdrop
		File background_file = new File("./images/Background_v2.png");
		JLabel background = createBackground(background_file, dim);
		container.add(background);

		// Reading in images for buttons
		File printing_records_file = new File("./images/Printing_records.png");
		File printing_form_file = new File("./images/Background.png");
		File rental_records_file = new File("./images/Rental_records.png");
		File rental_form_file = new File("./images/Rental_form.png");
		File time_clock_file = new File("./images/Time_clock.png");

		JButton printing_button = buttonWithImage(printing_records_file, dim);
		JButton printing_form_button = buttonWithImage(printing_form_file, dim);
		JButton rental_button = buttonWithImage(rental_records_file, dim);
		JButton rental_form_button = buttonWithImage(rental_form_file, dim);
		JButton time_clock_button = buttonWithImage(time_clock_file, dim);

		// Adding buttons
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Add a blank space in the top row
		gbc.gridx = 0;
		gbc.gridy = 0;
		background.add(Box.createVerticalStrut((dim.height / 12)), gbc);
		
		// Printing records
		gbc.gridx = 0;
		gbc.gridy = 2;
		background.add(printing_button, gbc);
		
		// Printing form
		gbc.gridx = 0;
		gbc.gridy = 4;
		background.add(printing_form_button, gbc);
		
		// Add blank spaces between the buttons
		gbc.gridx = 1;
		gbc.gridy = 2;
		int width = (int) (dim.width / 2.5);
		background.add(Box.createHorizontalStrut(width), gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		background.add(Box.createVerticalStrut((dim.height / 24)), gbc);
		
		// Rental button
		gbc.gridx = 2;
		gbc.gridy = 2;
		background.add(rental_button, gbc);

		// Rental form button
		gbc.gridx = 2;
		gbc.gridy = 4;
		background.add(rental_form_button, gbc);
		frame.add(container);
		return frame;
	}

	/*****************************************************************
	 * Helper method that generates the background in the form of 
	 * a JLabel. Must pass the file of the image to use and the 
	 * dimensions required (typically screen width and height).
	 * 
	 * @param file - File - the image to make the button
	 * @param dim - Dimension - the dimensions of the background
	 * @return
	 *****************************************************************/
	private JLabel createBackground(File file, Dimension dim) {

		JLabel background = new JLabel();
		
		// Change layout so you can overlay buttons onto the JLabel
		background.setLayout(new GridBagLayout());
		background.setSize(dim);
		
		// Load in and set image of JLabel
		try {
			BufferedImage img = ImageIO.read(file);
			Image full_screen_img = img.getScaledInstance(dim.width, dim.height, Image.SCALE_AREA_AVERAGING);
			background.setIcon(new ImageIcon(full_screen_img));
			background.setSize(dim);
		} catch (IOException e) {
			System.out.println("*** ERROR*** : Background image cannot be found. :: " + e.getMessage());
		}

		return background;
	}

	/*****************************************************************
	 * Helper method that generates a new JButton from an image from
	 * a file that is passed as an argument.
	 * 
	 * @param file - File - the image to make the button
	 * @return
	 *****************************************************************/
	private JButton buttonWithImage(File file, Dimension dim) {
		JButton btn = new JButton();
		try {
			BufferedImage image = ImageIO.read(file);
			Image scaled_image = image.getScaledInstance(dim.width / 5, dim.width / 5, Image.SCALE_AREA_AVERAGING);
			btn.setIcon(new ImageIcon(scaled_image));
		} catch (IOException e) {
			System.out.println("*** ERROR*** : Background image cannot be found. Reverting to backup :: " + e.getMessage());
		}

		return btn;
	}

	/*****************************************************************
	 * Entry point for the program.
	 * 
	 * @param args
	 *****************************************************************/
	public static void main(String[] args) {
		Hub hub = new Hub();
	}
}