import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	String cherry = "Cherry.png";
	String bar = "bar.png";
	String orange = "Orange.png";
	int score = 0;
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton spin = new JButton();
	JLabel image1 = new JLabel( new ImageIcon(getClass().getResource(cherry)));
	JLabel image2 = new JLabel( new ImageIcon(getClass().getResource(bar)));
	JLabel image3 = new JLabel( new ImageIcon(getClass().getResource(orange)));
	
	public static void main(String[] args) {
		new SlotMachine().playSlot();
	}
	
	public void playSlot() {
		// TODO Auto-generated method stub
		setUpFrame(frame, panel, "Slot Machine");
		
		spin.setText("SPIN");
		spin.addActionListener(this);
		
		frame.add(panel);
		panel.add(spin);
		panel.add(image1);
		panel.add(image2);
		panel.add(image3);
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
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("spin clicked");
		
		frame.getContentPane().removeAll();
		
		panel = new JPanel();
		spin = new JButton();
		setUpFrame(frame, panel, "Slot Machine");
		
		frame.add(panel);
		panel.add(spin);
		spin.setText("SPIN");
		spin.addActionListener(this);
		
		int randImage1 = new Random().nextInt(3);
		panel.add(getRandomImage(randImage1));
		int randImage2 = new Random().nextInt(3);
		panel.add(getRandomImage(randImage2));
		int randImage3 = new Random().nextInt(3);
		panel.add(getRandomImage(randImage3));
		frame.pack();
		
		if( (randImage1 == randImage2) && (randImage1 == randImage3) ) {
			score++;
			JOptionPane.showMessageDialog(null, "you won!\nScore = " + score);
		}
		
	}
	
	JLabel getRandomImage(int randImage) {
		ImageIcon image = new ImageIcon();
		
		if( randImage == 0 ) {
			image = new ImageIcon(getClass().getResource(bar));
		} else if( randImage == 1 ) {
			image = new ImageIcon(getClass().getResource(cherry));
		} else if( randImage == 2 ) {
			image = new ImageIcon(getClass().getResource(orange));
		}
		
		return new JLabel(image);
	}
	
}
