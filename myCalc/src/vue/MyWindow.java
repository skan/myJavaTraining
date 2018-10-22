package vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

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
	
	public MyWindow() {
		// setup JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(400, 400);
		
		// Numbers Panel
		panel_numbers.setLayout(new GridLayout(4,3));
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
		panel_ops.setLayout(new GridLayout(5,1));
		panel_ops.add(button_clear);                 
		panel_ops.add(button_add);                 
		panel_ops.add(button_minus);                 
		panel_ops.add(button_mult);
		panel_ops.add(button_div);
		
		// result panel
		panel_result.add(label_result);
		label_result.setText("calc results will be here");
		
		this.getContentPane().add(this.panel_numbers, BorderLayout.CENTER);
		this.getContentPane().add(this.panel_ops, BorderLayout.EAST);
		this.getContentPane().add(this.panel_result, BorderLayout.NORTH);
		
		
		this.setVisible(true);
	}

	// Main method
	public static void main(String[] args) {
		MyWindow fen = new MyWindow();
		//fen.setVisible(true);
	}
}