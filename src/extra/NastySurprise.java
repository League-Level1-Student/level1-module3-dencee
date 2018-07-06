package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
	JFrame myFrame = new JFrame();
	JPanel myPanel = new JPanel();
	JButton trickB = new JButton("Trick");
	JButton treatB = new JButton("Treat");
	String cuteImageURL = "https://media.newyorker.com/photos/59095c67ebe912338a37455d/master/w_649,c_limit/Stokes-Hello-Kitty2.jpg";
	String scaryImageURL = "https://orig00.deviantart.net/97f1/f/2009/186/c/c/scared_kitten_by_bebekexo.jpg";
	
	public static void main(String[] args) {
		new NastySurprise().trickOrTreat();
	}

	public void trickOrTreat() {
		// Setup frame
		this.myFrame.setVisible(true);
		this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set action listeners on buttons
		this.trickB.addActionListener(this);
		this.treatB.addActionListener(this);
		
		// Add buttons, panels, and pack frame
		this.myPanel.add(this.treatB);
		this.myPanel.add(this.trickB);
		this.myFrame.getContentPane().add(this.myPanel);
		this.myFrame.pack();
	}
	
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	         URL url = new URL(imageUrl);
	         Icon icon = new ImageIcon(url);
	         JLabel imageLabel = new JLabel(icon);
	         JFrame frame = new JFrame();
	         frame.add(imageLabel);
	         frame.setVisible(true);
	         frame.pack();
	    } catch (MalformedURLException e) {
	         e.printStackTrace();
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("clicked! " + e.getActionCommand());
		
		if( e.getSource() == this.trickB ) {
			showPictureFromTheInternet(this.scaryImageURL);
		} else if( e.getSource() == this.treatB ) {
			showPictureFromTheInternet(this.cuteImageURL);
		}
	}
}


