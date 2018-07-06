package extra;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class ChuckleClicker implements ActionListener {
	JFrame myFrame = new JFrame();
	JPanel myPanel = new JPanel();
	JButton jokeB = new JButton("Joke");
	JButton punchlineB = new JButton("Punchline");
	JLabel myLabel = new JLabel("");
	GridBagLayout grid = new GridBagLayout();
	boolean jokePressed = false;
	
	public static void main(String[] args) {
		new ChuckleClicker().makeButtons();
	}

	public void makeButtons() {
		// Setup initial conditions
		this.myFrame.setTitle("Chuckle Clicker");
		this.myFrame.setSize(500, 100);
		this.myFrame.setVisible(true);
		this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myPanel.setLayout(grid);
		this.myLabel.setText("This is a good joke");
		
		// Set constraints
		GridBagConstraints jokeBConst = new GridBagConstraints();
		GridBagConstraints punchlineBConst = new GridBagConstraints();
		GridBagConstraints labelConst = new GridBagConstraints();
		GridBagConstraints panelConst = new GridBagConstraints();
		
		// Setup joke button
		jokeBConst.gridx = 0;
		jokeBConst.gridy = 0;
		jokeBConst.weightx = 0.5;
		jokeBConst.ipadx = 10;
		jokeBConst.anchor = GridBagConstraints.LINE_START;
		jokeBConst.fill = GridBagConstraints.HORIZONTAL;
		
		// Setup punchline button
		punchlineBConst.gridx = 1;
		punchlineBConst.gridy = 0;
		punchlineBConst.weightx = 0.5;
		punchlineBConst.anchor = GridBagConstraints.LINE_START;
		punchlineBConst.fill = GridBagConstraints.HORIZONTAL;
		
		// Setup joke label
		labelConst.gridx = 0;
		labelConst.gridy = 1;
		labelConst.gridwidth = 2;
		labelConst.anchor = GridBagConstraints.LINE_START;
		labelConst.fill = GridBagConstraints.HORIZONTAL;
		
		// Set action listeners on buttons
		this.jokeB.addActionListener(this);
		this.punchlineB.addActionListener(this);
		
		// Add buttons, panels, and pack frame
		this.myPanel.add(this.jokeB, jokeBConst);
		this.myPanel.add(this.punchlineB, punchlineBConst);
		this.myPanel.add(this.myLabel, labelConst);
		this.myFrame.getContentPane().add(this.myPanel);
		//this.myFrame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("clicked! " + e.getActionCommand());
		
		if( e.getSource() == this.jokeB ) {
			this.jokePressed = true;
			this.myLabel.setText("What is Bruce Lee's favorite drink?");
			System.out.println("What is Bruce Lee's favorite drink?");
//			this.myFrame.pack();
		} else if( e.getSource() == this.punchlineB ) {
			if( this.jokePressed ) {
				System.out.println("Wataaa!");
				this.myLabel.setText("Wataaa!");
//				this.myFrame.pack();
			} else {
				System.out.println("Press the joke button first");
				this.myLabel.setText("Press the joke button first");
//				this.myFrame.pack();
			}
		}
	}
}


