package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/26.
 */
public class Test26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = getNum(scanner.nextInt());
            System.out.println(num);
            int sum = getSum(scanner.nextInt(), scanner.nextInt());
            System.out.println(sum);
        }
    }

    private static int getSum(int i, int i1) {
        return i + i1;
    }

    private static int getNum(int i) {
        int[] n = new int[i];
        n[0] = 1;
        n[1] = 1;
        for (int j = 2; j < i; j++) {
            n[j] = n[j - 1] + n[j - 2];
        }
        return n[i - 1];
    }
}
