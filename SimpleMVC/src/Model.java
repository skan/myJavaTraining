// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class Model {

	// Holds the value of the sum of the numbers
	// entered in the view

	private String actualNumber = "";
	private String previousNumber = "";
	private String ops = "";
	private double result = 0.0;
	private String display = "";
	boolean isOpsSelected = false;

	public void setOps(String str) {
		if (str.equals("=")){
			compute();
			this.display = formatResult(this.result);
		}
		else if (str.equals("C")){
			this.display = "0";
			this.actualNumber="";
			this.previousNumber="";
		}
		else {
			this.ops = str;
			isOpsSelected = true;
			previousNumber = actualNumber;
			actualNumber = "";
			this.display = this.ops;
		}
	}

	public String getDisplay() {
		return this.display;
	}

	public void setDigit(String str) {
		this.actualNumber += str;
		this.display = actualNumber;
	}

	private void compute() {
		if (this.ops.equals("+")) {
			this.result = Double.parseDouble(previousNumber) + Double.parseDouble(actualNumber);
		} else if (this.ops == "-") {
			this.result = Double.parseDouble(previousNumber) - Double.parseDouble(actualNumber);
		} else if (this.ops == "*") {
			this.result = Double.parseDouble(previousNumber) * Double.parseDouble(actualNumber);
		} else if (this.ops == "/") {
			this.result = Double.parseDouble(previousNumber) / Double.parseDouble(actualNumber);
		}
	}

	private String formatResult(double d) {
		{
			if (d == (long) d)
				return String.format("%d", (long) d);
			else
				return String.format("%s", d);
		}
	}
}