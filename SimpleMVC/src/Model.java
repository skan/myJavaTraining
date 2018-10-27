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

	public String getActualValue() {
		return actualNumber;
	}

	public void setOps(String str) {
		if (str.equals("="))
		{
			compute();
			display = formatResult(this.result);
		}
		else
		{
			display = actualNumber;
			this.ops = str;
			isOpsSelected = true;
			previousNumber = actualNumber;
			actualNumber = "";
		}
	}

	public String getOps() {
		return this.ops;
	}
	
	public String getDisplay() {
		return this.display;
	}

	public void digitCompute(String str) {
		this.actualNumber += str;
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