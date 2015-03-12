package calculator2;

import javax.swing.JFrame;


public class CalculatorSimMain {

	public static void main(String[] args) {
	//creating the main frame
	JFrame frame = new JFrame("Simplier Calculator");
	frame.setSize(400, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setContentPane(new CalculatorSim());
	frame.pack();
	frame.setVisible(true);
	}
}
