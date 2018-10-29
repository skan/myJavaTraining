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
			this.display = formatResult(this.result);
			this.previousNumber = display;
			this.actualNumber = "";
			isOpsSelected = false;
		} else if (str.equals("C")) {
			resetCalc();
		} else {
			if (isOpsSelected == true) {
				System.out.println("debug into ops select true");
				compute();
				this.display = formatResult(this.result);
				this.previousNumber = this.display;
			} else {
				this.ops = str;
				this.display = this.ops;
				System.out.println("into the else : previous = 0");
				if (this.actualNumber != "") // case ops button is called after equal ops
					this.previousNumber = this.actualNumber;
			}
			this.ops = str;
			isOpsSelected = true;
			actualNumber = "";
		}
	}

	public String getDisplay() {
		return this.display;
	}

	public void setDigit(String str) {
		if ((str == ".") && (this.actualNumber == ""))
			this.actualNumber = "0.";
		else
			this.actualNumber += str;
		this.display = actualNumber;
	}

	private void compute() {
		System.out.println("debug previous number: " + this.previousNumber);
		System.out.println("debug actual number  : " + this.actualNumber);
		if ((this.actualNumber != "") && this.previousNumber != "") {
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