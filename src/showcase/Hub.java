package showcase;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Hub extends JFrame {
	/*****************************************************************
	 * Generated Serialized ID number
	 *****************************************************************/
	private static final long serialVersionUID = 2833726655594634320L;

	/*****************************************************************
	 * Creates and displays the Tech Showcase Hub
	 *****************************************************************/
	public void createAndShowHub() {
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
		JLabel background = createBackground("/images/Background.png", dim);
		container.add(background);

		// Reading in images for labels (used as buttons)
		JLabel printing_button = labelWithImage("/images/Print_queue.png", dim);
		JLabel printing_form_button = labelWithImage("/images/Print_form.png", dim);
		JLabel rental_button = labelWithImage("/images/Rental_records.png", dim);
		JLabel rental_form_button = labelWithImage("/images/Rental_records.png", dim);
		JLabel time_clock_button = labelWithImage("/images/Time_clock.png", dim, true);

		// Adding buttons
		GridBagConstraints gbc = new GridBagConstraints();

		// Add a blank space in the top row
		gbc.gridx = 0;
		gbc.gridy = 0;
		background.add(Box.createVerticalStrut((dim.height / 14)), gbc);

		// Printing queue button
		gbc.gridx = 0;
		gbc.gridy = 2;
		background.add(printing_button, gbc);

		// Printing form button
		gbc.gridx = 0;
		gbc.gridy = 3;
		background.add(printing_form_button, gbc);

		// Add blank spaces between the buttons
		gbc.gridx = 1;
		gbc.gridy = 2;
		int width = (int) (dim.width / 2.75);
		background.add(Box.createHorizontalStrut(width), gbc);
		
		// Rental records button
		gbc.gridx = 2;
		gbc.gridy = 2;
		background.add(rental_button, gbc);

		// Rental form button
		gbc.gridx = 2;
		gbc.gridy = 3;
		background.add(rental_form_button, gbc);
		
		// Time clock button
		gbc.gridx = 1;
		gbc.gridy = 4;
		background.add(time_clock_button, gbc);
		
		background.setVisible(true);
		container.setVisible(true);
		frame.add(container);
		return frame;
	}

	/*****************************************************************
	 * Helper method that generates the background in the form of 
	 * a JLabel. Must pass the file of the image to use and the 
	 * dimensions required (typically screen width and height).
	 * 
	 * @param file_path - String - the path to the image
	 * @param dim - Dimension - the dimensions of the background
	 * @return background - JLabel - background image as label
	 *****************************************************************/
	private JLabel createBackground(String file_path, Dimension dim) {

		JLabel background = new JLabel();

		// Change layout so you can overlay buttons onto the JLabel
		background.setLayout(new GridBagLayout());
		background.setSize(dim);

		// Load in and set image of JLabel
		try {
			
			int background_width = dim.width;
			int background_height = dim.height;
			
			BufferedImage img = ImageIO.read(ResourceLoader.load(file));
			Image full_screen_img = img.getScaledInstance(background_width, background_height, Image.SCALE_AREA_AVERAGING);
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
	 * @param file_path - String - the path to the image
	 * @param dim - Dimension - the requested dimensions of the image
	 * @return lbl -JLabel - the sized label with an image
	 *****************************************************************/
	private JLabel labelWithImage(String file_path, Dimension dim) {
		
		JLabel lbl = new JLabel();
		
		// Load in and set image of JLabel
		try {
			
			int image_width = dim.width / 4;
			int image_height = image_width;
			
			BufferedImage image = ImageIO.read(ResourceLoader.load(file));
			Image scaled_image = image.getScaledInstance(image_width, image_height, Image.SCALE_AREA_AVERAGING);
			lbl.setIcon(new ImageIcon(scaled_image));
		} catch (IOException e) {
			System.out.println("*** ERROR*** : Background image cannot be found. Reverting to backup :: " + e.getMessage());
		}

		return lbl;
	}
	
	/*****************************************************************
	 * Helper method that generates a new time clock JButton from an 
	 * image from a file that is passed as an argument.
	 * 
	 * @param file_path - String - the path to the image
	 * @param dim - Dimension - the requested dimensions of the image
	 * @param time_clock - boolean - optional, creates a time clock
	 * @return lbl -JLabel - the sized label with an image
	 *****************************************************************/
	private JLabel labelWithImage(String file_path, Dimension dim, boolean time_clock) {
		
		JLabel lbl = new JLabel();
		
		// Load in and set image of JLabel
		try {
			
			double width = dim.width / 7;
			double height = dim.height / 14;
			int image_width = (int) width;
			int image_height = (int) height;
			
			BufferedImage image = ImageIO.read(ResourceLoader.load(file));
			Image scaled_image = image.getScaledInstance(image_width, image_height, Image.SCALE_AREA_AVERAGING);
			lbl.setIcon(new ImageIcon(scaled_image));
		} catch (IOException e) {
			System.out.println("*** ERROR*** : Background image cannot be found. Reverting to backup :: " + e.getMessage());
		}

		return lbl;
	}

	/*****************************************************************
	 * Entry point for the program.
	 * 
	 * @param args
	 *****************************************************************/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Hub hub = new Hub();
				hub.createAndShowHub();
			}
		});
	}
}