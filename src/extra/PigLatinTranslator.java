package extra;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField pigLatinText = new JTextField();
	JTextField translatedText = new JTextField();
	JButton translateButton = new JButton();
	
	public static void main(String[] args) {
		new PigLatinTranslator().start();

	}
	
	void start() {
		setUpFrame(frame, panel);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		this.panel.add(pigLatinText, c);
		
		c.gridx = 1;
		c.gridy = 0;
		this.panel.add(translateButton, c);
		
		c.gridx = 2;
		c.gridy = 0;
		this.panel.add(translatedText, c);
		
		
	}
	
	void setUpFrame(JFrame frame, JPanel panel) {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridBagLayout());
	}

}
