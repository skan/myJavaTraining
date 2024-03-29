import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

// The Controller coordinates interactions
// between the View and Model

public class Controller {

	private View theView;
	private Model theModel;

	public Controller(View theView, Model theModel) {
		this.theView = theView;
		this.theModel = theModel;

		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class

		this.theView.addCalculateListener(new listenForDigitButton());
		this.theView.addOpsListener(new listenForOpsButton());
	}

	class listenForDigitButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton) e.getSource()).getText();
			theModel.setDigit(str);
			theView.setDisplay(theModel.getDisplay());
		}
	}

	class listenForOpsButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String str = ((JButton) e.getSource()).getText();
			theModel.setOps(str);
			theView.setDisplay(theModel.getDisplay());
		}
	}

}