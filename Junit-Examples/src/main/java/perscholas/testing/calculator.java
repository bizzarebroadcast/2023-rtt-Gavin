package perscholas.testing;

public class calculator {
	public double add(double x, double y) {
		return x + y;
	}
	
	public double subtract(double x, double y) {
		return x - y;
	}
	
	public double multiply(double x, double y) {
		return x * y;
	}
	
	public double divide(double x, double y) {
		return x / y;
	}
	
	
	public static void main(String[] args) {
		calculator c = new calculator();
		
		double sum = c.add(5.0, 6.0);
		double sub = c.subtract(10.0, 3.9);
	}
}
