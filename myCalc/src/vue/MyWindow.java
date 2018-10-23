package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyWindow extends JFrame {

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

	// Constructor
	public MyWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(240, 260);
		this.setTitle("myCalc");

		initComponents();

		this.setVisible(true);
	}

	// Main method
	public static void main(String[] args) {
		MyWindow fen = new MyWindow();
		fen.setVisible(true);
	}

	class DigitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton) e.getSource()).getText();
			digitCompute(str);
		}
	}

	class Bouton_dot_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (isOpsSelected == false) {
				digitCompute("0.");
			} else {
				digitCompute(".");
			}
		}
	}

	class OpsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton) e.getSource()).getText();
			opsActions(str);
		}
	}
	
	class Bouton_equal_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// compute result versus operation
			if (operation.equals("+")) {
				result = Double.parseDouble(previousNumber) + Double.parseDouble(actualNumber);
			} else if (operation == "-") {
				result = Double.parseDouble(previousNumber) - Double.parseDouble(actualNumber);
			} else if (operation == "*") {
				result = Double.parseDouble(previousNumber) * Double.parseDouble(actualNumber);
			} else if (operation == "/") {
				result = Double.parseDouble(previousNumber) / Double.parseDouble(actualNumber);
			}
			display(fmt_double(result));
			// reset stored numbers
			actualNumber = Double.toString(result);
			isOpsSelected = false;
		}
	}

	class Bouton_clear_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = "";
			previousNumber = "";
			label_result.setText("0");
		}
	}

	private void display(String val) {
		label_result.setText(val);
	}

	private void digitCompute(String str) {
		if (!isOpsSelected) {
			actualNumber = "";
			isOpsSelected = true;
		}
		actualNumber += str;
		try {
			display(actualNumber);
		} catch (Exception e) {
			display(".");
		}

	}

	private void opsActions(String str) {
		previousNumber = actualNumber;
		actualNumber = "";
		label_result.setText(str);
		operation = str;
		isOpsSelected = true;
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

		// boutons actions
		button_1.addActionListener(new DigitListener());
		button_2.addActionListener(new DigitListener());
		button_3.addActionListener(new DigitListener());
		button_4.addActionListener(new DigitListener());
		button_5.addActionListener(new DigitListener());
		button_6.addActionListener(new DigitListener());
		button_7.addActionListener(new DigitListener());
		button_8.addActionListener(new DigitListener());
		button_9.addActionListener(new DigitListener());
		button_0.addActionListener(new DigitListener());
		button_dot.addActionListener(new Bouton_dot_Listener());

		button_add.addActionListener(new OpsListener());
		button_minus.addActionListener(new OpsListener());
		button_equal.addActionListener(new Bouton_equal_Listener());
		button_mult.addActionListener(new OpsListener());
		button_div.addActionListener(new OpsListener());
		button_clear.addActionListener(new Bouton_clear_Listener());
	}
	private static String fmt_double(double d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}
}
