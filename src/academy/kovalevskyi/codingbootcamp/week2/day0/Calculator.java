package academy.kovalevskyi.codingbootcamp.week2.day0;

public class Calculator {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide 3 input arguments, example: 2 + 3");
            return;
        }
        long args1 = Integer.parseInt(args[0]);
        String args2 = args[1];
        long args3 = Integer.parseInt(args[2]);
        long rsl = 0;
        switch (args[1]) {
            case "+":
                rsl = args1 + args3;
                break;
            case "-":
                rsl = args1 - args3;
                break;
            case "/":
                if (args3 == 0) {
                    System.out.println("Division by zero is impossible");
                    return;
                }
                rsl = args1 / args3;
                break;
            case "*":
                rsl = args1 * args3;
                break;
            case "%":
                if (args3 == 0) {
                    System.out.println("Division by zero is impossible");
                    return;
                }
                rsl = args1 % args3;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.out.println("result: " + rsl);
    }
}
