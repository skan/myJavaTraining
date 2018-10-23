package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton button_equal = new JButton("equal");
	private JButton button_dot = new JButton(".");

	private JButton button_clear = new JButton("C");
	private JButton button_add = new JButton("+");
	private JButton button_minus = new JButton("-");
	private JButton button_mult = new JButton("*");
	private JButton button_div = new JButton("/");

	private JPanel panel_result = new JPanel();
	private JPanel panel_numbers = new JPanel();
	private JPanel panel_ops = new JPanel();

	private int actualNumber;
	private int previousNumber;
	private int result = 0;
	private String operation = "";

	public MyWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(400, 400);

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
		label_result.setText("calc results will be here");

		// add panels to frame
		this.getContentPane().add(this.panel_numbers, BorderLayout.CENTER);
		this.getContentPane().add(this.panel_ops, BorderLayout.EAST);
		this.getContentPane().add(this.panel_result, BorderLayout.NORTH);

		// boutons actions
		button_1.addActionListener(new Bouton_1_Listener());
		button_2.addActionListener(new Bouton_2_Listener());
		button_3.addActionListener(new Bouton_3_Listener());
		button_4.addActionListener(new Bouton_4_Listener());
		button_5.addActionListener(new Bouton_5_Listener());
		button_6.addActionListener(new Bouton_6_Listener());
		button_7.addActionListener(new Bouton_7_Listener());
		button_8.addActionListener(new Bouton_8_Listener());
		button_9.addActionListener(new Bouton_9_Listener());
		button_0.addActionListener(new Bouton_0_Listener());
		button_add.addActionListener(new Bouton_add_Listener());
		button_minus.addActionListener(new Bouton_minus_Listener());
		button_equal.addActionListener(new Bouton_equal_Listener());
		button_mult.addActionListener(new Bouton_mult_Listener());
		button_div.addActionListener(new Bouton_div_Listener());
		
		
		button_clear.addActionListener(new Bouton_clear_Listener());

		this.setVisible(true);
	}

	// Main method
	public static void main(String[] args) {
		MyWindow fen = new MyWindow();
		fen.setVisible(true);
	}

	class Bouton_1_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 1;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	
	class Bouton_2_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 2;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	
	class Bouton_3_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 3;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	class Bouton_4_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 4;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	class Bouton_5_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 5;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	class Bouton_6_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 6;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	class Bouton_7_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 7;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	class Bouton_8_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 8;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	class Bouton_9_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 9;
			label_result.setText(Integer.toString(actualNumber));
		}
	}
	class Bouton_0_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = actualNumber * 10 + 0;
			label_result.setText(Integer.toString(actualNumber));
		}
	}

	class Bouton_add_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			previousNumber = actualNumber;
			actualNumber = 0;
			label_result.setText("+");
			operation = "+";
		}
	}
	
	class Bouton_minus_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			previousNumber = actualNumber;
			actualNumber = 0;
			label_result.setText("-");
			operation = "-";
		}
	}
	
	class Bouton_mult_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			previousNumber = actualNumber;
			actualNumber = 0;
			label_result.setText("*");
			operation = "*";
		}
	}
	
	class Bouton_div_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			previousNumber = actualNumber;
			actualNumber = 0;
			label_result.setText("/");
			operation = "/";
		}
	}

	class Bouton_equal_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// compute result verus operation
			if (operation == "+") {
				label_result.setText(Integer.toString(previousNumber + actualNumber));
			}
			else if (operation == "-") {
				label_result.setText(Integer.toString(previousNumber - actualNumber));
			}
			else if (operation == "*") {
				label_result.setText(Integer.toString(previousNumber * actualNumber));
			}
			else if (operation == "/") {
				label_result.setText(Integer.toString(previousNumber / actualNumber));
			}
			// reset stored numbers
			actualNumber = 0;
			previousNumber = 0;
		}
	}

	class Bouton_clear_Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			actualNumber = 0;
			previousNumber = 0;
			label_result.setText("0");
		}
	}
}