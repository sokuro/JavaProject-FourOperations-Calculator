package calculator2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorSim extends JPanel implements ActionListener {

		//GUI
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField result = new JTextField();
		
		JButton add = new JButton("+");
		JButton sub = new JButton("-");
		JButton mul = new JButton("*");
		JButton div = new JButton("/");
		
		public CalculatorSim() {	//constructor
			
			super(new GridLayout(4, 1));	//the main construct
			
			//adding ActionEvents to buttons
			add.addActionListener(this);
			sub.addActionListener(this);
			mul.addActionListener(this);
			div.addActionListener(this);
			
			//creating the button panel
			JPanel buttons = new JPanel(new FlowLayout());
			buttons.add(add);
			buttons.add(sub);
			buttons.add(mul);
			buttons.add(div);
			buttons.setBackground(Color.blue);
			
			//creating the calculator panel
			this.add(field1);
			this.add(field2);
			this.add(buttons);
			this.add(result);
			this.setBackground(Color.blue);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Double number1 = null;
			Double number2 = null;
			try {
				number1 = Double.parseDouble(field1.getText());
				number2 = Double.parseDouble(field2.getText());
				Double tempResult;
				if (e.getSource() == add)
					tempResult = number1 + number2;
				else if (e.getSource() == sub)
					tempResult = number1 - number2;
				else if (e.getSource() == mul)
					tempResult = number1 * number2;
				else 
					tempResult = number1 / number2;
				result.setText(String.valueOf(tempResult));
			} catch (NumberFormatException ex) {
				result.setText(String.valueOf("only numbers are allowed!"));
				if (number1 == null) {
					field1.selectAll();
					field2.requestFocus();
				}
				else {
					field2.selectAll();
					field2.requestFocus();
				}
			}
		}
}
