package cohen.change;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*; 


public class ChangeGUI extends JFrame {
	JTextField price = new JTextField("");
	JTextField paid = new JTextField("");
	JTextField quarters = new JTextField();
	JTextField dimes = new JTextField();
	JTextField nickels = new JTextField();
	JTextField pennies = new JTextField();
	JButton makeChange = new JButton("				Make Change");


	public ChangeGUI() {
		setTitle("Change Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
				
		panel.add(new JLabel("				Price: "));
		panel.add(price);
		panel.add(new JLabel("				Paid: "));
		panel.add(paid);
		panel.add(new JLabel("				Change: "));
		panel.add(makeChange);
		panel.add(new JLabel("				Quarters: "));
		panel.add(quarters);
		panel.add(new JLabel("				Dimes: "));
		panel.add(dimes);
		panel.add(new JLabel("				Nickels: "));
		panel.add(nickels);
		panel.add(new JLabel("				Pennies: "));
		panel.add(pennies);
		
		makeChange.addActionListener(this::changeTextFields);
		
		add(panel);
	}
	

	
	public void changeTextFields(ActionEvent event) {
		//textfield.setText("Action Performed");
		Change c = VendingMachine.pay(Double.parseDouble(price.getText()),Double.parseDouble(paid.getText()));
		quarters.setText(Integer.toString(c.getQuarters()));
		dimes.setText(Integer.toString(c.getDimes()));
		nickels.setText(Integer.toString(c.getNickles()));
		pennies.setText(Integer.toString(c.getPennies()));
		price.setText("");
		paid.setText("");		
	}
	
	
	public static void main(String[] args) {
		new ChangeGUI().setVisible(true);	
	}
}