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
	boolean isOpsSelected = false;

	public String getActualValue() {
		return actualNumber;
	}

	public void setOps(String str) {
		this.ops = str;
		isOpsSelected = true;
		previousNumber = actualNumber;
		actualNumber = "";
	}

	public String getOps() {
		return this.ops;
	}

	public void digitCompute(String str) {
		this.actualNumber += str;
	}

	public void compute() {
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

	public String getResult() {
		{
			if (this.result == (long) this.result)
				return String.format("%d", (long) this.result);
			else
				return String.format("%s", this.result);
		}
	}
}