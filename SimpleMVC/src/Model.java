// The Model performs all the calculations needed
// and that is it. It doesn't know the View 
// exists

public class Model {

	// Holds the value of the sum of the numbers
	// entered in the view
	
	private String actualValue = "";
	public String getActualValue()
	{
		return actualValue;
	}
	
	public void digitCompute(String str)
	{
		this.actualValue += str;		
	}
	
}