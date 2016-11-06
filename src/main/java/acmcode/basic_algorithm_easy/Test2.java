package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/28.
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            int num = titleToNumber(input);
            System.out.println(num);
        }
    }

    public static int titleToNumber(String s) {
        char nums[] = s.toCharArray();

        int m = 0;
        int count = 0;
        while (m < nums.length) {
            count += getNum(nums[m]);
            m++;
        }
        return count;
    }

    private static int getNum(char num) {
        char n[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < n.length; i++) {
            if (n[i] == num) {
                return i + 1;
            }
        }
        return 0;
    }
}
