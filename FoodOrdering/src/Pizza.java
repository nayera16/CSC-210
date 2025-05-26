
public class Pizza extends Food {
	
	private Size size;
	public enum Size{ SMALL, MEDIUM, LARGE };
	private Flavor flavor;
	public enum Flavor {
		CHEESE,
		PEPPERONI
	}
	
	// constructor for Pizza
	
	public Pizza(Flavor flavor, Size size) {
		this.label = "pizza";
		this.flavor = flavor;
		this.size = size;
	}
	// get and set
	
	public double getPrice() {
		switch (flavor){
		case CHEESE:
			return 8.80 + size.ordinal() * 5;
		case PEPPERONI:
			return 9.90 + size.ordinal() * 5;
		default:
			return 0;
		}
	}
	
	@Override
	public Food getFoodType() {
		// TODO Auto-generated method stub
		return null;
	}
}
