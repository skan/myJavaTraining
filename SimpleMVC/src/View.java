import java.awt.Button;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.Label;
import java.awt.event.WindowEvent; //for CloseListener()
import java.awt.event.WindowAdapter; //for CloseListener()
import java.lang.Integer; //int from Model is passed as an Integer
import java.util.Observable; //for update();

class View implements java.util.Observer {

	private TextField myTextField;
	private Button button;

	View() {
		System.out.println("View()");

		Frame frame = new Frame("simple MVC");
		frame.add("North", new Label("counter"));

		myTextField = new TextField();
		frame.add("Center", myTextField);

		Panel panel = new Panel();
		button = new Button("PressMe");
		panel.add(button);
		frame.add("South", panel);

		frame.addWindowListener(new CloseListener());
		frame.setSize(200, 100);
		frame.setLocation(100, 100);
		frame.setVisible(true);

	} 
	
	// Called from the Model
	public void update(Observable obs, Object obj) {
		myTextField.setText("" + ((Integer) obj).intValue()); // obj is an Object, need to cast to an Integer
	} 

	// to initialise TextField
	public void setValue(int v) {
		myTextField.setText("" + v);
	} 
	
	public void addController(Controller controller) {
		System.out.println("View      : adding controller");
		button.addActionListener(controller); // need controller before adding it as a listener
	} 

	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} 
	} 

} // View