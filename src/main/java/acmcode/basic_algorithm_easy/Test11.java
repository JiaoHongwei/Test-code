package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/12/2.
 * 保留两位小数！！！！！！！！！！！！！！！！！！！
 */

/**
 * 题目描述：
 * 数列的定义如下：
 * 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * 输入
 * 输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 * 输出
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 *
 * 样例输入
 * 81 4
 * 2 2
 * 样例输出
 * 94.73
 * 3.41
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            double value = getCount(n, m);
            System.out.printf("%.2f", value);
            System.out.println();
        }
    }

    private static double getCount(int n, int m) {
        double value = n;
        double count = value;
        if (n == 1) {
            return m * 1;
        }
        if (m == 1) {
            return n;
        }
        for (int i = 1; i < m; i++) {
            value = Math.sqrt(value);
            count += value;
        }
        return count;
    }
}
