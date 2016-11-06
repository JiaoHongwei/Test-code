package acmcode.basic_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/21.
 */
public class Test21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] d = new int[n];
            for (int i = 0; i < d.length; i++) {
                d[i] = scanner.nextInt();
            }
            int min = getMaxNum(n, m, d);
            System.out.println(min);
        }
    }

    private static int getMaxNum(int n, int m, int[] d) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < d.length; i++) {
            StringBuffer a = new StringBuffer(Integer.toBinaryString(d[i]));
            for (int j = i + 1; j <= d.length - 1; j++) {

                StringBuffer b = new StringBuffer(Integer.toBinaryString(d[j]));
                StringBuffer result = new StringBuffer();
                int max = a.length() > b.length() ? a.length() : b.length();
                if (a.length() > b.length()) {
                    int num = max - b.length();
                    for (int i1 = 0; i1 < num; i1++) {
                        b = b.insert(0, 0);
                    }
                } else {
                    int num = max - a.length();
                    for (int i1 = 0; i1 < num; i1++) {
                        a = a.insert(0, 0);
                    }
                }
                char[] a_nums = a.toString().toCharArray();
                char[] b_nums = b.toString().toCharArray();

                for (int i1 = 0; i1 < max; i1++) {
                    if (a_nums[i1] == (b_nums[i1])) {
                        result.append(0);
                    } else {
                        result.append(1);
                    }
                }
                int c = Integer.valueOf(result.toString(), 2);
                if (c > m) list.add(c);
            }
        }
        return list.size();
    }
}
