// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it. 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vue.MyWindow.Bouton_clear_Listener;
import vue.MyWindow.Bouton_equal_Listener;
import vue.MyWindow.OpsListener;

public class View extends JFrame{

	private JLabel label_result = new JLabel("myLabel");

	private JButton button_1 = new JButton("1");
	private JButton button_2 = new JButton("2");
	private JButton button_3 = new JButton("3");
	private JButton button_4 = new JButton("4");
	private JButton button_5 = new JButton("5");
	private JButton button_6 = new JButton("6");
	private JButton button_7 = new JButton("7");
	private JButton button_8 = new JButton("8");
	private JButton button_9 = new JButton("9");
	private JButton button_0 = new JButton("0");
	private JButton button_equal = new JButton("=");
	private JButton button_dot = new JButton(".");

	private JButton button_clear = new JButton("C");
	private JButton button_add = new JButton("+");
	private JButton button_minus = new JButton("-");
	private JButton button_mult = new JButton("*");
	private JButton button_div = new JButton("/");

	private JPanel panel_result = new JPanel();
	private JPanel panel_numbers = new JPanel();
	private JPanel panel_ops = new JPanel();

	private String actualNumber;
	private String previousNumber;
	private double result = 0;
	private String operation = "";
	private boolean isOpsSelected = false;
	
	
	
	View(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(240, 260);
		this.setTitle("myCalc");

		initComponents();

		this.setVisible(true);

		
	}
		
	public void setDisplay(String solution){
		
		label_result.setText(solution);
		
	}
	
	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed
	
	void addDigitListener(ActionListener listenForDigit){
		
		calculateButton.addActionListener(listenForDigit);
		
	}
	
	
	void addCalculateListener(ActionListener listenForDigitButton){
		
		// boutons actions
		button_1.addActionListener(listenForDigitButton);
		button_2.addActionListener(listenForDigitButton);
		button_3.addActionListener(listenForDigitButton);
		button_4.addActionListener(listenForDigitButton);
		button_5.addActionListener(listenForDigitButton);
		button_6.addActionListener(listenForDigitButton);
		button_7.addActionListener(listenForDigitButton);
		button_8.addActionListener(listenForDigitButton);
		button_9.addActionListener(listenForDigitButton);
		button_0.addActionListener(listenForDigitButton);
		button_dot.addActionListener(listenForDigitButton);
	}
	
	void addOpsListener(ActionListener listenForOpsButton)
	{
		button_add.addActionListener(listenForOpsButton);
		button_minus.addActionListener(listenForOpsButton);
		button_mult.addActionListener(listenForOpsButton);
		button_div.addActionListener(listenForOpsButton);
		button_equal.addActionListener(listenForOpsButton);
		button_clear.addActionListener(listenForOpsButton);
	}

	// Open a popup that contains the error message passed
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
	private void initComponents() {
		// Numbers Panel
		panel_numbers.setLayout(new GridLayout(4, 3));
		panel_numbers.add(button_1);
		panel_numbers.add(button_2);
		panel_numbers.add(button_3);
		panel_numbers.add(button_4);
		panel_numbers.add(button_5);
		panel_numbers.add(button_6);
		panel_numbers.add(button_7);
		panel_numbers.add(button_8);
		panel_numbers.add(button_9);
		panel_numbers.add(button_0);
		panel_numbers.add(button_dot);
		panel_numbers.add(button_equal);

		// Ops Panel
		panel_ops.setLayout(new GridLayout(5, 1));
		panel_ops.add(button_clear);
		panel_ops.add(button_add);
		panel_ops.add(button_minus);
		panel_ops.add(button_mult);
		panel_ops.add(button_div);

		// result panel
		panel_result.add(label_result);
		panel_result.setBorder(BorderFactory.createLineBorder(Color.black));

		label_result.setText("calc results will be here");

		// add panels to frame
		this.getContentPane().add(this.panel_numbers, BorderLayout.CENTER);
		this.getContentPane().add(this.panel_ops, BorderLayout.EAST);
		this.getContentPane().add(this.panel_result, BorderLayout.NORTH);
	}
	
}