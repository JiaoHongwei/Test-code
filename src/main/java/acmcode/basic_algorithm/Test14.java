package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/19.
 */
public class Test14 {

    /**
     * 完美世界 / 求输入的 范围之内的 孪生质数；
     * 即两个质数的差为2；
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            getNums(min, max);
        }

    }

    public static boolean isPrime(int x) {
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    private static void getNums(int min, int max) {

        for (int i = min; i <= max - 2; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.print(i + " " + (i + 2) + " ");
            }
        }
    }


}
