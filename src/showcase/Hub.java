package showcase;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(dim);
		frame.setUndecorated(true);
		frame.setMinimumSize(dim);

		// Reading in / creating the background
		//String path = "./images/Background.png"; // this says "The Hub"
		String path = "./images/Background_v2.png"; // this removes "The Hub"
		File file = new File(path);
		try {
			BufferedImage img = ImageIO.read(file);
			Image full_screen_img = img.getScaledInstance(screen_width, screen_height, Image.SCALE_AREA_AVERAGING);
			JLabel lbl = new JLabel(new ImageIcon(full_screen_img));
			lbl.setSize(dim);
			frame.add(lbl);
		} catch (IOException e) {
			System.out.println("*** ERROR*** : Background image cannot be found. Reverting to backup :: " + e.getMessage());
		} 
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
