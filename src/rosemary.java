//    Copyright (c) The League of Amazing Programmers 2013-2017
//    Level 0

import java.net.URI;

import javax.swing.JOptionPane;

public class rosemary {
	public static void main(String[] args) {
		// 1. Ask the user how many cats they have
		int catsint = cats("how many cats do you have:");

		// 2. Convert their answer into an int

		// 3. If they have more than 3 cats, tell them they're a crazy cat lady
		if ( catsint >= 3 ) {
			JOptionPane.showMessageDialog(null, "You are a crazy cat lady!");
		}

		else if ( catsint == 0 ) {
			playVideo("https://youtu.be/W_juM14WHNQ");
		}
		
		// 4. If they have 3 or less, call the method below to show them a cat video
		else if ( catsint <= 3 ) {
			playVideo("https://youtu.be/agi4geKb8v8");
		}
		
		// 5. If they say 0, show them a video of A Frog Sitting on a Bench Like a Human
	
	}

	public static int cats(String message) {
		String animal = JOptionPane.showInputDialog(message);
		int catsint = Integer.parseInt(animal);
		return catsint;
	}

	static void playVideo(String videoURL) {
		try {
			URI uri = new URI(videoURL);
			java.awt.Desktop.getDesktop().browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}