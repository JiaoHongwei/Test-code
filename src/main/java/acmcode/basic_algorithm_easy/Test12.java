package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/12/2.
 */
public class Test12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            countNum(n, m);
        }
    }

    private static void countNum(int n, int m) {
        for (int i = n; i <= m; i++) {
            int a = 0, b = i;
            while (m>0){
                int c=b%10;
                a+=a;
            }
        }

    }
}
