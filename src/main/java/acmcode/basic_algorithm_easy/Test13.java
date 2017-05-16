package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/12/2.
 */
public class Test13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                int[] a = new int[6];
                for (int i1 = 0; i1 < a.length; i1++) {
                    a[i1]=scanner.nextInt();
                }
                String time = getTime(a);
                System.out.println(time);
            }
        }
    }

    private static String getTime(int[] a) {
        int hours = a[0] + a[3];
        int minute = a[1] + a[4];
        int second = a[2] + a[5];
        while (second >= 60) {
            second -= 60;
            minute++;
        }
        while (minute >= 60) {
            minute -= 60;
            hours++;
        }
        return hours + " " + minute + " " + second;
    }
}
