
public abstract class Food {
	protected String label;
	protected double price;
	
	// constructor
	
	
	
	
	// get and set label
	
	public String getLabel() {
		return label;
	}
	
	public abstract double getPrice();
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public abstract Food getFoodType();
	
	
	
}
