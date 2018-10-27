// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class Model {

	// Holds the value of the sum of the numbers
	// entered in the view
	
	private String actualValue = "";
	private String previousValue ="";
	private String ops ="";
	boolean isOpsSelected = false;
	
	public String getActualValue()
	{
		return actualValue;
	}
	public void setOps(String str ) {
		this.ops = str;
		isOpsSelected = true;
		previousValue = actualValue;
		actualValue = "";
	}
	public String getOps() {
		return this.ops;
	}
	public void digitCompute(String str)
	{
		this.actualValue += str;		
	}
	
}