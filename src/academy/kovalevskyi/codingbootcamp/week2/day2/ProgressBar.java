package academy.kovalevskyi.codingbootcamp.week2.day2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProgressBar {

    public static void main(String[] args) throws InterruptedException {
        int[] arr1 = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            arr1[i - 1] = Integer.parseInt(args[i]);
        }
        int countElem = Integer.parseInt(args[0]);
        int[] arr2 = new int[countElem + 1];
        int time = 0;
        Random random = new Random();
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[random.nextInt(arr1.length)];
            time += arr2[i];
        }
        int procent = 100 / countElem;
        for (int i = 0; i < countElem + 1; i++) {
            printStringProgressBar(procent * i, i, countElem, time);
            TimeUnit.SECONDS.sleep(arr2[i]);
            time -= arr2[i];
        }
        printStringProgressBar(100, countElem, countElem, 0);
    }

    public static void printStringProgressBar(int procent, int count, int countElem, int time) {
        System.out.print("\r" + String.format("%3d%% [", procent)
                + "=".repeat(procent)
                + ">"
                + " ".repeat(100 - procent)
                + "] "
                + String.format("%d/%d ", count, countElem)
                + timer(time));
    }

    private static String timer(int seconds) {
        int hour = (seconds % 86400) / 3600;
        int min = ((seconds % 86400) % 3600) / 60;
        int sec = (((seconds % 86400) % 3600) % 60);
        return String.format("ETA: %02d:%02d:%02d", hour, min, sec);
    }
}


//        long total = 235;
//        long startTIme = System.currentTimeMillis();
//
//        for (int i = 1; i <= total; i++) {
//            try {
//                Thread.sleep(50);
//                printProgress(startTIme, total, i);
//            } catch (InterruptedException e) {
//            }
//        }
//    }
//
//    private static void printProgress(long startTime, long total, long current) {
//        long eta = current == 0 ? 0 : (total - current) * (System.currentTimeMillis() - startTime) / current;
//
//        String etaHms = current == 0 ? "N/A" : String.format("%2d:%2d:%2d", TimeUnit.MILLISECONDS.toHours(eta),
//                TimeUnit.MILLISECONDS.toMinutes(eta) % TimeUnit.HOURS.toMinutes(1),
//                TimeUnit.MILLISECONDS.toSeconds(eta) % TimeUnit.MINUTES.toSeconds(1));
//
//        StringBuilder stringBuilder = new StringBuilder(140);
//        int percent = (int) (current * 100 / total);
//        stringBuilder.append('\r')
//                .append(String.join("", Collections.nCopies(percent == 0 ? 2
//                        : 2 - (int) (Math.log10(percent)), " ")))
//                .append(String.format(" %d%% [", percent))
//                .append(String.join("", Collections.nCopies(percent, "=")))
//                .append('>')
//                .append(String.join("", Collections.nCopies(current == 0 ? (int) (Math.log10(total))
//                        : (int) (Math.log10(total)) - (int) (Math.log10(current)), " ")))
//                .append(String.format(" %d%d, ETA: %s", current, total, etaHms));
//        System.out.print(stringBuilder);