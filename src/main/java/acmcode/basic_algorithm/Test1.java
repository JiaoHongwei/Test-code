package acmcode.basic_algorithm;

/**
 * Created by jiaohongwei on 2016/9/4.
 */

import java.util.Scanner;

/**
 * 股神
 * 题目描述
 * 有股神吗？
 * 有，小赛就是！
 * 经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 * 为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int price = getPriceToday(scanner.nextInt());
            System.out.println(price);
        }
    }
    private static int getPriceToday(int n) {
        int price = 1;//当前价格
        int m = 2;//升降一循环的变化天数
        for (int i = 2; i <= n; ) {
            for (int j = m; j > 0 && i <= n; j--) {
                if (j != 1) {
                    price++;
                } else {
                    price--;
                    m++;
                }
                i++;
            }
        }
        return price;
    }

}
