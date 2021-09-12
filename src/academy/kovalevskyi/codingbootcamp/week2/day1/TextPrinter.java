package academy.kovalevskyi.codingbootcamp.week2.day1;

import javax.swing.*;

public class TextPrinter {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide only one input argument, current amount: " + args.length);
            return;
        }
        String text = args[0];
        int width = text.length() + 4;
        System.out.println(builderFirstString(width, '#', '/', '\\'));
        System.out.println(buildCenterStrings(width, '#', text));
        System.out.println(builderLastString(width, '#', '\\', '/'));
    }

    public static String builderFirstString(int width, char firstArgsParam, char secondArgsParam, char thirdArgsParam) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i == 0) {
                stringBuilder.append(secondArgsParam);
            } else if (i == width - 1) {
                stringBuilder.append(thirdArgsParam);
            } else {
                stringBuilder.append(firstArgsParam);
            }
        }
        return stringBuilder.toString();
    }

    public static String builderLastString(int width, char firstArgsParam, char secondArgsParam, char thirdArgsParam) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i == 0) {
                stringBuilder.append(secondArgsParam);
            } else if (i == width - 1) {
                stringBuilder.append(thirdArgsParam);
            } else {
                stringBuilder.append(firstArgsParam);
            }
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
//   StringBuilder sb = new StringBuilder();
//        String text = args.length > 0 ? args[0] : "";
//        int weight = text.length() + 2;
//        String line = "#".repeat(weight);
//        sb.append(String.format("/%s\\%n", line))
//                .append(String.format("# %s", text))
//                .append(String.format("\\%s/", line));
//        System.out.println(sb);
//    }