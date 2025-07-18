import java.util.Scanner;

public class ScientificCalculator {

    // Addition
    static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    static double multiply(double a, double b) {
        return a * b;
    }

    // Division
    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero");
            return Double.NaN;
        }
        return a / b;
    }

    // Power: x^y
    static double power(double x, int y) {
        double result = 1;
        for (int i = 0; i < Math.abs(y); i++) {
            result *= x;
        }
        return y < 0 ? 1 / result : result;
    }

    // Factorial
    static long factorial(int n) {
        if (n < 0) return -1;
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Sine using Taylor Series (radians)
    static double sin(double x) {
        x = x % (2 * Math.PI);  // Reduce range
        double term = x, sum = x;
        for (int i = 1; i <= 10; i++) {
            term *= -1 * x * x / ((2 * i) * (2 * i + 1));
            sum += term;
        }
        return sum;
    }

    // Cosine using Taylor Series (radians)
    static double cos(double x) {
        x = x % (2 * Math.PI);  // Reduce range
        double term = 1, sum = 1;
        for (int i = 1; i <= 10; i++) {
            term *= -1 * x * x / ((2 * i - 1) * (2 * i));
            sum += term;
        }
        return sum;
    }

    // Natural Logarithm (ln) using Taylor Series around 1: ln(1 + x)
    static double ln(double x) {
        if (x <= 0) {
            System.out.println("Error: ln(x) for x <= 0 is undefined");
            return Double.NaN;
        }
        x = (x - 1) / (x + 1);
        double result = 0;
        for (int i = 1; i <= 99; i += 2) {
            result += (1.0 / i) * power(x, i);
        }
        return 2 * result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Scientific Calculator");
        System.out.println("Choose operation: +, -, *, /, ^, sin, cos, ln, !");
        String op = sc.next();

        switch (op) {
            case "+":
                System.out.print("Enter two numbers: ");
                System.out.println("Result: " + add(sc.nextDouble(), sc.nextDouble()));
                break;
            case "-":
                System.out.print("Enter two numbers: ");
                System.out.println("Result: " + subtract(sc.nextDouble(), sc.nextDouble()));
                break;
            case "*":
                System.out.print("Enter two numbers: ");
                System.out.println("Result: " + multiply(sc.nextDouble(), sc.nextDouble()));
                break;
            case "/":
                System.out.print("Enter two numbers: ");
                System.out.println("Result: " + divide(sc.nextDouble(), sc.nextDouble()));
                break;
            case "^":
                System.out.print("Enter base and exponent: ");
                System.out.println("Result: " + power(sc.nextDouble(), sc.nextInt()));
                break;
            case "sin":
                System.out.print("Enter angle in radians: ");
                System.out.println("Result: " + sin(sc.nextDouble()));
                break;
            case "cos":
                System.out.print("Enter angle in radians: ");
                System.out.println("Result: " + cos(sc.nextDouble()));
                break;
            case "ln":
                System.out.print("Enter positive number: ");
                System.out.println("Result: " + ln(sc.nextDouble()));
                break;
            case "!":
                System.out.print("Enter integer: ");
                System.out.println("Result: " + factorial(sc.nextInt()));
                break;
            default:
                System.out.println("Invalid operation");
        }

        sc.close();
    }
}
