package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/10/8.
 */
public class Test5 {
//    public class Main{

    /**
     * 试题描述：盛大游戏笔试题
     * 题目描述
     * 要把  m  升的水倒入  n  个相同的容器中（假设容器足够大），允许有的容器是空的，问共有多少种不同的倒法？（用k表示）5，1，1和1，5，1和  1,1,5  是同一种倒法。
     *
     * 输入
     * 第一行是测试数据的数目  x（0  <=  x  <=  20）。以下每行均包含二个整数m和n，以空格分开。1<=m，n<=10。
     *
     * 输出
     * 对输入的每行数据m和n，用一行输出相应的k。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] nums = new int[num];
            for (int i = 0; i < num; i++) {
                int m = scanner.nextInt();
                int n = scanner.nextInt();
                nums[i] = getAllTimes(m, n);
            }
            for (int i : nums) {
                System.out.print(i + " ");
            }
        }
    }

    private static int getAllTimes(int m, int n) {
        int sum = 0;
        if (m == 1 || m == 0 || n == 1)
            return 1;
        if (m < n) {
            n = m;
        }
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sum += getAllTimes(m, i);
            } else {
                sum += getAllTimes(m - i, i);
            }
        }
        return sum;
    }
}
