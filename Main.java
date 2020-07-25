package Calculator;

import java.util.Scanner;

abstract class Variables {
	private double a;
	private double b;

	protected void setParam1(double a) {
		this.a = a;
	}

	protected void setParam2(double b) {
		this.b = b;
	}

	protected double getParam1() {
		return this.a;
	}

	protected double getParam2() {
		return this.b;
	}

	public abstract double operation();
}

class Add extends Variables {
	@Override
	public double operation() {
		return getParam1() + getParam2();
	}
}

class Multiply extends Variables {
	@Override
	public double operation() {
		return getParam1() * getParam2();
	}
}

class Subtract extends Variables {
	@Override
	public double operation() {
		return getParam1() - getParam2();
	}
}

class Divide extends Variables {
	@Override
	public double operation() {
		return getParam1() / getParam2();
	}
}

public class Main {

	public static void main(String[] args) {

		double num1, num2;
		Scanner scanner = new Scanner(System.in);

		Variables var;

		while (true) {
			System.out.println("Y to continue and N to exit");
			char operator; 
			operator = scanner.next().charAt(0);
			if(operator == 'N' || operator == 'n') System.exit(0);
			
			System.out.println("Enter an operator (+, -, *, /):");
			
			System.out.println("Enter first number:");
			num1 = scanner.nextDouble();
			
			System.out.println("Enter second number:");
			num2 = scanner.nextDouble();
			
			operator = scanner.next().charAt(0);
			
			double output;

			switch (operator) {
			case '+':
				var = new Add();
				var.setParam1(num1);
				var.setParam2(num2);
				output = var.operation();
				break;

			case '-':
				var = new Subtract();
				var.setParam1(num1);
				var.setParam2(num2);
				output = var.operation();
				break;

			case '*':
				var = new Multiply();
				var.setParam1(num1);
				var.setParam2(num2);
				output = var.operation();
				break;

			case '/':
				var = new Divide();
				var.setParam1(num1);
				var.setParam2(num2);
				output = var.operation();
				break;
			case 'e':
				System.exit(0);
			default:
				System.out.printf("You have entered wrong operator");
				return;
			}

			System.out.println(num1 + " " + operator + " " + num2 + ": " + output);
			
		}
	}
}