package acmcode.basic_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/21.
 */
public class Test17 {
    /**
     * 搜狐后端  彩色珠宝项链
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            getMax(scanner.next());
        }
    }

    private static void getMax(String input) {
        if (input.length() < 5) {
            System.out.println(0);
            return;
        }
        String a = input + input;
        char b[] = a.toCharArray();
        int[] d = new int[b.length];
        for (int i = 0; i < input.length(); i++) {
            List<Character> list = new ArrayList<Character>();
            list.add('A');
            list.add('B');
            list.add('C');
            list.add('D');
            list.add('E');
            d[i] = input.length() - getResult(i, b, list);
        }
        int max = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        System.out.println(max);

    }

    private static int getResult(int i, char[] b, List<Character> c) {
        int m = i;
        while (c.size() > 0 && m < b.length) {
            int num = ifExeite(b[m] + "", c);
            if (num >= 0) {
                c.remove(num);
            }
            m++;
        }
        if (c.size() > 0) return b.length / 2;
        return m - i;
    }

    private static int ifExeite(String s, List<Character> c) {
        String a = "ABCDE";
        for (int i = 0; i < c.size(); i++) {
            if (s.equals(c.get(i) + "")) {
                return i;
            }
        }
        return -1;
    }
}
