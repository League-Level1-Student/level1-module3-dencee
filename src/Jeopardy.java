import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.File;

/* This recipe is to be used with the Jeopardy Handout: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton;
	
	private JPanel quizPanel;
	int score = 0;
	JLabel scoreBox = new JLabel("0");
	int buttonCount = 0;

	public static void main(String[] args) {
		new Jeopardy().start();
	}

	private void start() {
		JFrame frame = new JFrame();
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());
		
		// 1. Make the frame show up
		frame.setVisible(true);

		// 2. Give your frame a title
		frame.setTitle("DMC's Frame");
		
		// 3. Create a JPanel variable to hold the header using the createHeader method
		JPanel jButtonHeader = createHeader("Category 1");
		JPanel jButtonHeader2 = createHeader("Category 2");
		
		// 4. Add the header component to the quizPanel
		quizPanel.add(jButtonHeader);
		
		// 5. Add the quizPanel to the frame
		frame.getContentPane().add(quizPanel);
		
		// 6. Use the createButton method to set the value of firstButton
		firstButton = createButton("$$ button 1");
	
		// 7. Add the firstButton to the quizPanel
		quizPanel.add(firstButton);
		
		// 8. Write the code inside the createButton() method below. Check that your game looks like Figure 1 in the Jeopardy Handout - http://bit.ly/1bvnvd4.
		
		// 9. Use the secondButton variable to hold a button using the createButton method
		secondButton = createButton("button 2");
		
		// 10. Add the secondButton to the quizPanel
		quizPanel.add(secondButton);
		
		// 11. Add action listeners to the buttons (2 lines of code)
		firstButton.addActionListener(this);
		secondButton.addActionListener(this);

		// 12. Fill in the actionPerformed() method below
		
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount+1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height, Toolkit.getDefaultToolkit().getScreenSize().width);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	/*
	 * 13. Use the method provided to play the Jeopardy theme music 
	 * 
	 * 14. Add buttons so that you have $200, $400, $600, $800 and $1000 questions
	 *
	 * [optional] Use the showImage or playSound methods when the user answers a question 
	 */
	
	private JButton createButton(String dollarAmount) {
		// Create a new JButton
		JButton jb = new JButton();
		
		// Set the text of the button to the dollarAmount
		jb.setText(dollarAmount);
		
		// Increment the buttonCount (this should make the layout vertical)
		buttonCount++;
		
		// Return your new button instead of the temporary button
		return jb;
	}

	public void actionPerformed(ActionEvent arg0) {
		// Remove this temporary message:
		JOptionPane.showMessageDialog(null,"pressed " + ((JButton)arg0.getSource()).getText() + " button");

		// Use the method that plays the jeopardy theme music.

		JButton buttonPressed = (JButton) arg0.getSource();
		// If the buttonPressed was the firstButton
		if( buttonPressed == firstButton ) {
			// Call the askQuestion() method
			
			// Fill in the askQuestion() method. When you play the game, the score should change.
			askQuestion("today's date?", "Friday", 200);
			firstButton.setText("");
		} else if( buttonPressed == secondButton ) {
			// Call the askQuestion() method with a harder question.
			askQuestion("hard question", "hard", 2000);
			secondButton.setText("");
		}
		
		// Clear the button text (set the button text to nothing)
	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
//		JOptionPane.showMessageDialog(null, question);
		// Use a pop up to ask the user the question
		String userAnswer = JOptionPane.showInputDialog(question);
		
		// If the answer is correct
		if( userAnswer.equals(correctAnswer) ) {
		
			// Increase the score by the prizeMoney
			score += prizeMoney;
			
			// Call the updateScore() method
			updateScore();
			
			// Pop up a message to tell the user they were correct
			System.out.println("You were correct!!!");
			
		// Otherwise
		} else {
		
			// Decrement the score by the prizeMoney
			score -= prizeMoney;

			// Call the updateScore() method
			updateScore();
			
			// Pop up a message to tell the user the correct answer
			System.out.println("The correct answer is: " + correctAnswer);
		}
	}


public void playJeopardyTheme() {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/Users/League/Google Drive/league-sounds/jeopardy.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip scream = JApplet.newAudioClip(getClass().getResource(fileName));
		scream.play();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}
