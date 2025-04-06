import java.util.*;

public class Calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("|       Welcome to Calculator         |");
        System.out.println("---------------------------------------");

        while (true) {
            String expression;
            while (true) {
                System.out.print("\nEnter a number and indicate operator (Ex, 1+3*2/2) or type 'exit' to quit: ");
                expression = input.nextLine();

                if (expression.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting calculator thank you and goodbye!");
                    return;
                }

                if (expression.matches("[0-9+\\-*/ ]+")) {
                    break;
                }
                System.out.println("Invalid input! Please enter a valid Operator (numbers)");
            }

            double result = 0;
            int i = 0;
            char Operator = '+';

            while (i < expression.length()) {
                char Char = expression.charAt(i);

                if (Char == ' ') {
                    i++;
                    continue;
                }
                
                if (Character.isDigit(Char)) {
                    StringBuilder numStr = new StringBuilder();
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        numStr.append(expression.charAt(i));
                        i++;
                    }

                    double num = Double.parseDouble(numStr.toString());

                    switch (Operator) {
                        case '+':
                            result += num;
                            break;
                        case '-':
                            result -= num;
                            break;
                        case '*':
                            result *= num;
                            break;
                        case '/':
                            if (num != 0) {
                                result /= num;
                            } else {
                                System.out.println("Error: Division by zero.");
                                return;
                            }
                            break;
                    }
                }

                if (Char == '+' || Char == '-' || Char == '*' || Char == '/') {
                    Operator = Char;
                    i++;
                }
            }
            System.out.println("---------------------------------------");
            System.out.println("|        The Result of Calculation    |");
            System.out.println("---------------------------------------");
            System.out.println("Result: " + result);
        }
    }
}