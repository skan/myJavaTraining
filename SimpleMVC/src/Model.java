// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class Model {

	private String actualNumber = "";
	private String previousNumber = "0";
	private String ops = "";
	private double result = 0.0;
	private String display = "0";
	boolean isOpsSelected = false;

	public void setOps(String str) {
		if (str.equals("=")) {
			compute();
			isOpsSelected = false;
		} else if (str.equals("C")) {
			resetCalc();
		} else {
			if (isOpsSelected == true) {
				compute();
			} else {
				this.ops = str;
				isOpsSelected = true;
				previousNumber = actualNumber;
				actualNumber = "";
				this.display = this.ops;
			}
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
		this.display = formatResult(this.result);
		this.previousNumber = display;
		this.actualNumber = "";
	}

	private String formatResult(double d) {
		{
			if (d == (long) d)
				return String.format("%d", (long) d);
			else
				return String.format("%s", d);
		}
	}

	private void resetCalc() {
		this.display = "0";
		this.actualNumber = "";
		this.previousNumber = "";
		isOpsSelected = false;
		result = 0.0;
	}
}