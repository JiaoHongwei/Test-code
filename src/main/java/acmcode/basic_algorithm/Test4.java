package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/6.
 */

/**
 * Nim game博弈游戏，
 * 一张纸上，画若干条线，双方一人划一次，每次划掉1~3条线。可以选择画1条，也可以划2条，也可以3条。具体划去几条线完全看自己的策略。谁划掉最后一条线，就是赢家。
 *
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean flag = canWinNim(scanner.nextInt());
            System.out.println(flag);
        }
    }

    private static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
