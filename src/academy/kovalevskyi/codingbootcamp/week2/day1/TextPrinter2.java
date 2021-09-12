package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter2 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide 2 input argument, current amount: " + args.length);
            return;
        }
        String text = args[1];
        int width = text.length() + 4;
        char firstArgsParam = args[0].toCharArray()[0];
        System.out.println(builderFirstAndSecondString(width, firstArgsParam));
        System.out.println(buildCenterStrings(width, firstArgsParam, text));
        System.out.println(builderFirstAndSecondString(width, firstArgsParam));
    }

    public static String builderFirstAndSecondString(int width, char firstArgsParam) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            stringBuilder.append(firstArgsParam);
        }
        return stringBuilder.toString();
    }

    public static String buildCenterStrings(int width, char firstArgsParam, String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) {
                stringBuilder.append(firstArgsParam);
            } else if (i == 1 || i == width - 2) {
                stringBuilder.append(' ');
            } else if (i == 2) {
                stringBuilder.append(text);
            }
        }
        return stringBuilder.toString();
    }
}