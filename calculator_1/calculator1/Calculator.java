package calculator1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	
	private static double number1;
	private static double number2;
	
	private final static JTextField field1 = new JTextField();
	private final static JTextField field2 = new JTextField();
	private final static JTextField fieldResult = new JTextField();
	
	private static JButton add;
	private static JButton sub;
	private static JButton mul;
	private static JButton div;

	public static void main(String[] args) {
				
		//the main frame
		JFrame frame = new JFrame("Simple Calculator");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);	//centered frame
		
		//the main panel
		JPanel mainPanel = new JPanel(new GridLayout(3, 0));
		JPanel panel1 = new JPanel(new GridLayout(2, 0));
		JPanel panel2 = new JPanel(new FlowLayout());
		panel2.setBackground(Color.blue);
		JPanel panel3 = new JPanel(new GridLayout(1, 0));
		
		panel1.add(new JLabel("1st #:"));
		panel1.add(field1);
		panel1.add(new JLabel("2nd #:"));
		panel1.add(field2);
		
		//adding panels to the main panel
		mainPanel.add(panel1, BorderLayout.NORTH);
		mainPanel.add(panel2, BorderLayout.CENTER);
		mainPanel.add(panel3, BorderLayout.SOUTH);
		
		//math methods
		makeAdd();
		makeSub();
		makeMul();
		makeDiv();
		
		//adding methods to the sub panel
		panel2.add(add);
		panel2.add(sub);
		panel2.add(mul);
		panel2.add(div);
		
		//the result panel
		panel3.add(new JLabel("result:"));
		panel3.add(fieldResult);
		
		//changing the color and the font of the result
		new javax.swing.Timer(100, new ActionListener() {
			Random random = new Random();
			public void actionPerformed(ActionEvent arg) {
				Color color = new Color(random.nextInt(256), 
						random.nextInt(256), random.nextInt(256));
				fieldResult.setForeground(color);
				Font font = new Font("Courier", Font.BOLD, 12);
				fieldResult.setFont(font);
			}
		}).start();
		
		//adding the main panel to the main frame 
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	/**
	 * methods for the math operations (using inner class + Exception)
	 */
	public static void makeAdd() {
		add = new JButton("+");
		add.addActionListener(new ActionListener(){	//inner class 
			public void actionPerformed(ActionEvent e) {	
				try {
					number1 = Double.parseDouble(field1.getText());
					number2 = Double.parseDouble(field2.getText());
					fieldResult.setText(String.valueOf(number1 + number2));
				} catch (NumberFormatException ex) {
					fieldResult.setText(String.valueOf("only numbers are allowed!"));
				}
			}
		});
	}
	
	public static void makeSub() {
		sub = new JButton("-");
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					number1 = Double.parseDouble(field1.getText());
					number2 = Double.parseDouble(field2.getText());
					fieldResult.setText(String.valueOf(number1 - number2));
				} catch (NumberFormatException ex) {
					fieldResult.setText(String.valueOf("only numbers are allowed!"));
				}
			}
		});
	}
	
	public static void makeMul() {
		mul = new JButton("*");
		mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					number1 = Double.parseDouble(field1.getText());
					number2 = Double.parseDouble(field2.getText());
					fieldResult.setText(String.valueOf(number1 * number2));
				} catch (NumberFormatException ex) {
					fieldResult.setText(String.valueOf("only numbers are allowed!"));
				}
			}
		});
	}
	
	public static void makeDiv() {
		div = new JButton("/");
		div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				number1 = Double.parseDouble(field1.getText());
				number2 = Double.parseDouble(field2.getText());
				fieldResult.setText(String.valueOf(number1 / number2));
				} catch (NumberFormatException ex) {
					fieldResult.setText(String.valueOf("only numbers are allowed!"));
				}
			}
		});
	}
}

