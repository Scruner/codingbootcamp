package academy.kovalevskyi.codingbootcamp.week2.day1;

public class BoxGenerator {

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Please provide 4 input arguments, current amount: " + args.length);
            return;
        }
        if (!(
                Integer.parseInt(args[0]) >= 0 && Integer.parseInt(args[1]) >= 0 && args[2].toCharArray().length == 1 && args[3].toCharArray().length == 1)) {
            throw new IllegalArgumentException();
        }
        int width = Integer.parseInt(args[0]);
        int length = Integer.parseInt(args[1]);
        char firstArgsParam = args[2].toCharArray()[0];
        char secondArgsParam = args[3].toCharArray()[0];
        if (width == 0 || length == 0) {
            System.out.print("");
            return;
        }
        int index = 0;
        while (index < length) {
            if (index == 0 || index == length - 1) {
                System.out.println(builderStrings(width, firstArgsParam, secondArgsParam));
            } else {
                System.out.println(builderStrings(width, ' ', firstArgsParam));
            }
            index++;
        }
    }

    public static String builderStrings(int width, char firstArgsParam, char secondArgsParam) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) {
                stringBuilder.append(secondArgsParam);
            } else {
                stringBuilder.append(firstArgsParam);
            }
        }
        return stringBuilder.toString();
    }
}


