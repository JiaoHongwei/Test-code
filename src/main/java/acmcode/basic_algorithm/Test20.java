package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/21.
 */
public class Test20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] d = new int[n];
            for (int i = 0; i < d.length; i++) {
                d[i]=scanner.nextInt();
            }
            int min=getMinNum(n,d);
            System.out.println(min);
        }
    }

    private static int getMinNum(int n, int[] d) {

        return 0;
    }
}
