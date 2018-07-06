import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	char currentLetter;
	int numRandChars = 0;
	int numMistakes = 0;
	int maxChars = 50;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Date timeAtStart;
	
	public static void main(String[] args) {
		new TypingTutor().displayTutor();
	}
	
	public void displayTutor() {				
		// Set up frame
		setupFrame(this.frame, "Typing Tutor");
		
		// Get current letter
		this.currentLetter = generateRandomLetter();
		
		// Set up label
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setHorizontalTextPosition(JLabel.LEFT);
		label.setFont( new Font(null, Font.PLAIN, 200) );
		label.setText("" + currentLetter);
		panel.add(label, constraints);
		
		frame.addKeyListener(this);
		frame.getContentPane().add(panel);
		frame.pack();
	}

	char generateRandomLetter() {
	      Random r = new Random();
	      return (char) (r.nextInt(26) + 'a');
	}
	
	private void setupFrame( JFrame frame, String title ) {
		frame.setVisible(true);
		frame.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
	}

	private void showTypingSpeed(int numberOfCorrectCharactersTyped) {
	      Date timeAtEnd = new Date();
	      long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	      long gameInSeconds = (gameDuration / 1000) % 60;
	      double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	      int charactersPerMinute = (int) (charactersPerSecond * 60);
	      JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " characters per minute with " + numMistakes + " mistakes.");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		char pressedChar = e.getKeyChar();
		System.out.print("letter " + currentLetter + ": " + pressedChar );
		
		if( numRandChars == 0 ) {
			timeAtStart = new Date();
		}
		
		if( pressedChar == this.currentLetter ) {
			frame.getContentPane().setBackground(Color.GREEN);
			panel.setBackground(Color.GREEN);
			System.out.print(" CORRECT!\n");
		} else {
			frame.getContentPane().setBackground(Color.RED);
			panel.setBackground(Color.RED);
			System.out.print("\n");
			++numMistakes;
		}
		
		++numRandChars;
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println("key released!");
		
		this.currentLetter = generateRandomLetter();
		label.setText("" + this.currentLetter);
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("key typed!");
		
		if( this.numRandChars >= this.maxChars ) {
			showTypingSpeed(this.numRandChars);
		}
	}
	
}
