
public class Calculator {
	protected double num1;
	protected double num2;
	protected Character operation;
	
	public Calculator(double num1, double num2, Character operation) {
		this.num1 = num1;
		this.num2 = num2;
		this.operation = operation;
	}
	
	public double getResult() {
		switch (operation) {
		case '+':
			return add();
		case '-':
			return subtract();	
	
		case '*':
			return multiply();
			
		case '/':
			return divide();
		
		}
		return 0.0;
	}
	
	public double add() {
		return num1+num2;
	}
	
	public double subtract() {
		return num1-num2;
	}
	
	public double multiply() {
		return num1*num2;
	}
	
	public double divide() {
		if (num2 != 0) return num1/num2;
		else return 0;
	}
	
	
	
}



