package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/21.
 */
public class Test16 {
    /**
     * 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，他是这样定义的：
     * “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，比如：153=1^3+5^3+3^3。
     * 现在要求输出所有在m和n范围内的水仙花数。
     * 输入
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            isFlower(m, n);
        }
    }

    private static void isFlower(int m, int n) {
        if (m < 100 || n > 999 || m > n)
        {
            System.out.println("您输入的范围有错，请重新输入！");
            return;}
        boolean flag=false;
        for (int i = m; i <= n; i++) {
            if ((Math.pow(Integer.parseInt((i+"").substring(0,1)),3) + Math.pow(Integer.parseInt((i+"").substring(1,2)),3) + Math.pow(Integer.parseInt((i+"").substring(2,3)),3) == i)) {
                System.out.print(i+" ");
                flag=true;
            }
        }
        if (!flag) System.out.println("您输入的范围之内没有水仙花数!");
    }
}
