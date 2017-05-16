package acmcode.basic_algorithm_easy;

import java.util.Scanner;


/**
 * Created by jiaohongwei on 2016/12/2. 20 IT is a truth universally acknowledged that a single man
 * in possession of a good fortune must be in want of a wife
 */
public class Test14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int K = scanner.nextInt();
            String a = scanner.nextLine();
            String string = scanner.nextLine();
            printString(K, string);
        }
    }

    private static void printString(int k, String string) {
        String[] b = string.split(" ");
        int begin = 0;
        int length = b[begin].length();
        boolean c = true;
        for (int i = 0; i < b.length - 1; ) {
            if (length <= k) {
                if (!c)
                    System.out.print(" ");
                String m = b[i].toLowerCase();
                System.out.print(m.replaceFirst(m.substring(0,1),m.substring(0,1).toUpperCase()));
                i++;
                c = false;
                length += b[i].length();
            } else {
                System.out.println();
                length = b[i].length();
                c = true;
            }
            if (i == b.length - 1) {
                String m = b[i].toLowerCase();
                System.out.print(" " + m.replaceFirst(m.substring(0,1),m.substring(0,1).toUpperCase()));
            }
        }

    }
}
