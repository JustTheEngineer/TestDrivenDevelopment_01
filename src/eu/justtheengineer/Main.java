package eu.justtheengineer;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int a = 2, b = -3, c = 5, d = -7, e = 11;

        System.out.println("result of addition is: " + calculator.add(a, b, c, d, e));
        System.out.println("result of subtraction is: " + calculator.subtract(a, b, c, d, e));
        System.out.println("result of multiplication is: " + calculator.multiply(a, b, c, d, e));
        System.out.println("result of division is: " + calculator.divide(a, b, c, d, e));

        // Trying to divide by zero!
        System.out.println("result of division is: " + calculator.divide(a, 0));
    }
}
