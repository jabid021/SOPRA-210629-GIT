package demoJunit;

public class Calculatrice {
	public double addition(double a, double b) {
		return a + b;
	}

	public double soustraction(double a, double b) {
		return a - b;
	}

	public double multiplication(double a, double b) {
		return a * b;
	}

	public double division(double a, double b) throws DivisionParZero {
		if (b == 0)
			throw new DivisionParZero();
		return a / b;
	}
}
