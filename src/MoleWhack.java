import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoleWhack implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	GridBagConstraints constraints;
	JButton randButton = null;
	int rows = 8;
	int cols = 3;
	
	public static void main(String[] args) {
		new MoleWhack().start();
	}
	
	public void start() {
		setUpFrame(this.frame, this.panel, "Whack a Button for Fame and Glory");
		this.constraints = new GridBagConstraints();
		
		CreateJButtons( this.panel, constraints );
	}
	
	void CreateJButtons( JPanel panel, GridBagConstraints constraints ) {
		int randRow = new Random().nextInt(rows);
		int randCol = new Random().nextInt(cols);
		
		System.out.println("" + randRow + " " + randCol);
		
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 10;
		constraints.ipady = 10;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		for( int buttonRow = 0; buttonRow < this.rows; ++buttonRow ) {
			constraints.gridy = buttonRow;
			
			for( int buttonCol = 0; buttonCol < this.cols; ++buttonCol ) {
				constraints.gridx = buttonCol;
				
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(80, 40));
				button.addActionListener(this);
				
				if( ( buttonRow == randRow ) && ( buttonCol == randCol ) ) {
					button.setText("Mole!");
					this.randButton = button;
				}
				
				panel.add(button, constraints);
			}
		}
		
		frame.pack();
	}

	void setUpFrame(JFrame frame, JPanel panel, String title) {
		frame.setTitle(title);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridBagLayout());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("clicked!");
		
		if( this.randButton == (JButton)e.getSource() ) {
			System.out.println("Mole clicked!!!");
			
			
			//frame.dispose();
			frame.getContentPane().removeAll();
			panel = new JPanel();
			setUpFrame(frame, panel, "Whack");
			this.randButton.setText("");
			this.randButton = null;
			CreateJButtons(this.panel, this.constraints);
		}
	}
	
	void speak(String words) {
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	          + " moles per second.");
	}
	
	private void playSound(String fileName) {
	     AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	     sound.play();
	}
}
