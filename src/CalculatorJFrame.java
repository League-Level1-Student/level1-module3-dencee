import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorJFrame implements ActionListener {
	JFrame myFrame = new JFrame();
	JPanel myPanel = new JPanel();
	JButton addB = new JButton("Add");
	JButton subtractB = new JButton("Subtract");
	JButton multiplyB = new JButton("Multiply");
	JButton divideB = new JButton("Divide");
	JTextField number1 = new JTextField(20);
	JTextField number2 = new JTextField(20);
	JLabel myLabel = new JLabel(" ");
	
	public static void main(String[] args) {
		new CalculatorJFrame().showCalculator();
	}
	
	private void showCalculator() {
		// Setup initial conditions
		this.myFrame.setTitle("Simple Calculator");
		this.myFrame.setSize(500, 500);
		this.myFrame.setVisible(true);
		this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myPanel.setLayout(new GridBagLayout());
		
		// Set constraints
		GridBagConstraints constraints = new GridBagConstraints();
		
		// Setup number 1 and 2 text fields
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		this.myPanel.add(this.number1, constraints);
		constraints.gridx = 2;
		this.myPanel.add(this.number2, constraints);
		
		// Setup add, subtract, multiply, and divide buttons
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.weightx = 0.5;
		constraints.ipadx = 10;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		this.myPanel.add(this.addB, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		this.myPanel.add(this.subtractB, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		this.myPanel.add(this.multiplyB, constraints);
		
		constraints.gridx = 3;
		constraints.gridy = 1;
		this.myPanel.add(this.divideB, constraints);
		
		// Set label
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 4;
		constraints.anchor = GridBagConstraints.CENTER;
		myLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myLabel.setFont(new Font(null, Font.PLAIN, 40));
		this.myPanel.add(this.myLabel, constraints);
		
		// Set action listeners on buttons
		this.addB.addActionListener(this);
		this.subtractB.addActionListener(this);
		this.multiplyB.addActionListener(this);
		this.divideB.addActionListener(this);
		
		// Add panel to the frame
		this.myFrame.getContentPane().add(this.myPanel);
		this.myFrame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("clicked! " + e.getActionCommand());
		
		// Don't compute anything and return if there's no text in either of
		// the fields
		if( this.number1.getText().isEmpty() || this.number2.getText().isEmpty() ) {
			return;
		}

		double number1Double = Double.parseDouble( this.number1.getText() );
		double number2Double = Double.parseDouble( this.number2.getText() );

		if( e.getSource() == this.addB ) {
			myLabel.setText( Double.toString( number1Double + number2Double ) );
		} else if( e.getSource() == this.subtractB ) {
			myLabel.setText( Double.toString( number1Double - number2Double ) );
		} else if( e.getSource() == this.multiplyB ) {
			myLabel.setText( Double.toString( number1Double * number2Double ) );
		} else if( e.getSource() == this.divideB) {
			myLabel.setText( Double.toString( number1Double / number2Double ) );
		}
	}
	
}
