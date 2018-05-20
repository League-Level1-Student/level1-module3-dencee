
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.IOException;

public class SimonSays extends KeyAdapter {

	// Complete steps 1 - 7 before you test
	// 1. Make a JFrame variable
	JFrame frame;

	HashMap<Integer, String> images = new HashMap<Integer, String>();
	private int imageIndex;
	private int tries = 0;
	private int simonSays = 0;
	private String speakMessage;
	Date timeAtStart;

	private int points = 0;
	private int maxTries = 3;
	
	private void makeAlbum() {

		// 2. add 4 images which match keyboard keys like this: images.put(new
		// Integer(KeyEvent.VK_UP), "image.jpg");
		images.put(new Integer(KeyEvent.VK_UP), "fortune teller.png");
		images.put(new Integer(KeyEvent.VK_DOWN), "fortune teller.png");
		images.put(new Integer(KeyEvent.VK_LEFT), "fortune teller.png");
		images.put(new Integer(KeyEvent.VK_RIGHT), "fortune teller.png");

		// 3. Tell the user to "Press the matching key when 'Simon says' otherwise press
		// a different key"
		System.out.println("Press the matching key when 'Simon says' otherwise press a different key");

		// 4. call the method to show an image
		showImage();
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		// 16. make a points variable to track the score. tell the user their score at
		// the end.
		boolean correct = false;
		
		// 17. if the keyCode matches the imageIndex and "Simon says..." increase their
		// score
		if( ( keyCode == this.imageIndex )  && ( simonSays != 0 ) ) {
			correct = true;
		}
		
		// 18. if the keyCode doesn't match the imageIndex and "Simon didn't say..."
		// increase their score
		if( ( keyCode != this.imageIndex )  && ( simonSays == 0 ) ) {
			correct = true;
		}
		
		// 19. Use the speak method to tell the user if they were correct or not
		if ( correct ) {
			points++;
			speak("You're correct!");
		} else {
			tries++;
			speak("INCORRECT: you have " + (maxTries - tries) + " tries left");
		}
		
		// 13. increment tries by 1

		// 14. if tries is greater than 9 (or however many you want)
		// 15. exit the program
		if( tries >= maxTries ) {
			speak("Total score: " + points);
			System.exit(0);
		}

		// 11. dispose of the frame
		frame.dispose();

		// 12. call the method to show an image
		showImage();
	}

	private void showImage() {
		// 5. initialize your frame to a new JFrame()
		frame = new JFrame();

		// 6. set the frame to visible
		frame.setVisible(true);

		//7. rename to the name of your frame
		// frame.add(getNextRandomImage());
		frame.add(getNextRandomImage());
		
		// 8. set the size of the frame
		Dimension frameSize = frame.getSize();

		// 9. add a key listener to the frame
		frame.addKeyListener(this);
		
		frame.pack();

		// 10. Use the speak method to either say "Simon says press this key" or "Press
		// this key"
		// Hint: use the simonSays int and a random number
		simonSays = new Random().nextInt(2);
		
		speakMessage = "";
		
		if( simonSays != 0 ) {
			speakMessage += "Simon says ";
		}
		
		if( this.imageIndex == KeyEvent.VK_UP ) {
			speakMessage += "Press the UP key";
		} else if( this.imageIndex == KeyEvent.VK_DOWN ) {
			speakMessage += "Press the DOWN key";
		} else if( this.imageIndex == KeyEvent.VK_LEFT ) {
			speakMessage += "Press the LEFT key";
		} else if( this.imageIndex == KeyEvent.VK_RIGHT ) {
			speakMessage += "Press the RIGHT key";
		}
		
		speak(speakMessage);
	}

	private Component getNextRandomImage() {
		this.imageIndex = new Random().nextInt(4) + 37;
		return loadImage(images.get(imageIndex));
	}

	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

	void speak(String words) {
		try {
//			Runtime.getRuntime().exec("say " + words).waitFor();
			System.out.println(words);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new SimonSays().makeAlbum();
	}
}

/*
 * 20. add a timer ~~~ where the code starts running ~~~ timeAtStart = new
 * Date();
 *
 * ~~~ where the code ends ~~~ Date timeAtEnd = new Date();
 * System.out.println((timeAtEnd.getTime()-timeAtStart.getTime())/1000);
 * System.exit(0);
 */
