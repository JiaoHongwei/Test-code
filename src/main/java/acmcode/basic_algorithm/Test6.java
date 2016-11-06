package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/8.
 */

/**
 * 把输入的整数各位相加，如果和为一位数字则返回，大于一位继续拆分相加
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = addDigits(scanner.nextInt());
            System.out.println(num);
        }
    }

    private static int addDigits(int num) {
        int count = getCount(num + "", 0);
        return count;
    }

    private static int getCount(String numString, int count) {
        for (int i = 0; i < numString.length(); i++) {
            count += Integer.parseInt(numString.substring(i, i + 1));
        }
        if (count > 9) {
            return getCount(count + "", 0);
        }
        return count;
    }
}
