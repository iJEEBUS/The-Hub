package showcase;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
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

		// Reading in / creating the background
		String path = "./images/Background_v2.png"; 
		File file = new File(path);
		JLabel background = new JLabel();
		background.setLayout(new GridBagLayout());
		background.setSize(dim);
		try {
			BufferedImage img = ImageIO.read(file);
			Image full_screen_img = img.getScaledInstance(screen_width, screen_height, Image.SCALE_AREA_AVERAGING);
			background.setIcon(new ImageIcon(full_screen_img));
			
			background.setSize(dim);
			container.add(background);
		} catch (IOException e) {
			System.out.println("*** ERROR*** : Background image cannot be found. Reverting to backup :: " + e.getMessage());
		}

		
		// Reading in images for buttons
		String printing_records = "./images/Printing_records.png";
		String rental_records = "./images/Rental_records.png";
		String time_clock = "./images/Time_clock.png";
		File printing_records_file = new File(printing_records);
		File rental_records_file = new File(rental_records);
		File time_clock_file = new File(time_clock);
		JButton printing_button = new JButton();
		JButton rental_button = new JButton();
		JButton time_clock_button = new JButton();

		try {
			BufferedImage printing_records_img = ImageIO.read(printing_records_file);
			Image printing_records_img_scaled = printing_records_img.getScaledInstance(500, 500, Image.SCALE_AREA_AVERAGING);
			printing_button.setIcon(new ImageIcon(printing_records_img_scaled));
			
			BufferedImage rental_records_img = ImageIO.read(rental_records_file);
			Image rental_records_img_scaled = rental_records_img.getScaledInstance(500, 500, Image.SCALE_AREA_AVERAGING);
			rental_button.setIcon(new ImageIcon(rental_records_img_scaled));
			
			BufferedImage time_clock_img = ImageIO.read(time_clock_file);
			Image time_clock_img_scaled = time_clock_img.getScaledInstance(500, 500, Image.SCALE_AREA_AVERAGING);
			time_clock_button.setIcon(new ImageIcon(time_clock_img_scaled));

		} catch (IOException e) {
			System.out.println("*** ERROR*** : Background image cannot be found. Reverting to backup :: " + e.getMessage());
		}
		
		
		// Adding buttons
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		background.add(printing_button, gbc);
		
		// Add a blank space between the buttons
		gbc.gridx++;
		gbc.gridy = 3;
		background.add(Box.createHorizontalStrut(500), gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		background.add(rental_button, gbc);
		
		
		// Add the time to the top right of the application
//		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.US).withZone(ZoneId.systemDefault());
//		String date_time_string = formatter.format(Instant.now());
//		JLabel time_lbl = new JLabel(date_time_string);
//		gbc.gridx = 3;
//		gbc.gridy = 0;
//		background.add(time_lbl);
//		
		frame.add(container);
		return frame;
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
