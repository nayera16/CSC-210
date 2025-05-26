import java.util.ArrayList;

public class FoodOrder {
	
	// to do: Food food;
	// ArrayList<Food> items;
	
	ArrayList<Food> items = new ArrayList<>();
	private double totalCost;
	private String orderNumber;
	private OrderStatus status;
	public enum OrderStatus{
		PLACED,
		READY,
		ENROUTE,
		DELIVERED
	}
	
	
	// constructor
	public FoodOrder(String orderNumber) {
		this.orderNumber= orderNumber;
	}
	
	public void placeOrder() {
		status = OrderStatus.PLACED;
	}
	
	public void addFood(Food food) {
		items.add(food);
		totalCost += food.getPrice();
	}
	
	public void removeFood(Food food) {
		items.remove(food);
		totalCost -= food.getPrice();
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public OrderStatus getStatus() {
		switch (status) {
		case PLACED:
			return OrderStatus.PLACED;
		case READY:
			return OrderStatus.READY;
		case ENROUTE:
			return OrderStatus.ENROUTE;
		case DELIVERED:
			return OrderStatus.DELIVERED;
		default: 
			return null;
		}
	}
	
	public void setStatus() {
		
	}
}
