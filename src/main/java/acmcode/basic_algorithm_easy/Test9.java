package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**去哪网笔试题
 * 题目描述：
 给定一个数字，获取大于此数字的下一个数字X， 要求 X 为对称数字
 输入
 随机输入的自然数n
 输出
 对于每个测试实例，要求输出大于n的下一个对称数字

 样例输入
 451
 3840
 3363
 999
 样例输出
 454
 3883
 3443
 1001
 * Created by jiaohongwei on 2016/10/15.
 */
public class Test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = getNum(scanner.nextInt());
            System.out.println(num);
        }
    }

    private static int getNum(int i) {
        while (true) {
            i++;
            boolean a = ifNum(i);
            if (a) return i;
        }
    }

    private static boolean ifNum(int i) {
        String s = String.valueOf(i);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString().equals(s);
    }
}
