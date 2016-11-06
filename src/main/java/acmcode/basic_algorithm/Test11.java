package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/17.
 */
public class Test11 {
    /**
     * 输入两个数，第一个数从n开始，第二个是执行m次
     * 即count=n^1/2+(n^1/2)^1/2+……
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(countNum(n, m));
        }
    }

    private static String countNum(double n, double m) {
        if (n == 0 || m == 0) {
            return "";
        }
        double values = 0;
        while (m > 0) {
            values += n;
            n = Math.sqrt(n);
            m--;
        }
        return String.valueOf((double) Math.round(values*100)/100.0);
    }
}
