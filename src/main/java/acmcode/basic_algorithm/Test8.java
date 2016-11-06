package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/10.
 */
public class Test8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            String first = scanner.next();
            String next = scanner.next();
            String info=getValue(input, first, next);
            System.out.println(info);
        }
    }

    private static String getValue(String input, String first, String next) {
        if (!input.contains(first) && !input.contains(next)) {
            return "invalid";
        }
        char[] a = input.toCharArray();
        int first_num_before = 0;
        int first_num_end = 0;
        int next_num = 0;
        boolean b = false;
        boolean c = false;
        for (int i = 0; i < a.length; i++) {
            if (first.equals(a[i]+"") && !c) {
                first_num_before = i+1;
                c = true;
            }
            if (first.equals(a[i]+"")) {
                first_num_end = i+1;
            }
            if (next.equals(a[i]+"") && !b) {
                next_num = i+1;
                b = true;
            }
        }
        if (next_num > first_num_end) {
            return "forward";
        }else if (next_num <first_num_before){
            return "backward";
        }else {
            return "both";
        }
    }
}
