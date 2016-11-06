package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/21.
 */
public class Test18 {
    /**
     * 搜狐，从一个数中删除k个数，保证剩下的数（顺序不变）最大
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer str = new StringBuffer(scanner.nextLine());
        int k = scanner.nextInt();
        System.out.println(getResult(str, k));
    }

    private static StringBuffer getResult(StringBuffer str, int k) {
        for (int i = 0; i < k; i++) {
            int value = str.charAt(0);
            int j = 1;
            boolean deleted = false;
            for (; j < str.length(); j++) {
                if (value < str.charAt(j)) {
                    str.deleteCharAt(j - 1);
                    deleted = true;
                    break;
                } else {
                    value = str.charAt(j);
                }
            }
            if (!deleted)
                str.deleteCharAt(str.length() - 1);
        }
        return str;
    }
}
