package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/10/8.
 */
public class Test6 {
    /**
     * 盛大游戏笔试题
     *
     *
     * 一个给定的子序列是在该序列中删去若干元素后得到的序列。例如，序列z=<B,C,D,B>  是序列X=<A,B,C,B,D,A,B>的子序列；
     * 给定两个序列X和Y，当另一序列Z既是X的子序列又是Y的子序列时，称Z是序列X，Y的公共子序列。
     * 例如，若X=<A,B,C,B,D,A,B>，Y=<B,D,C,A,B,A>，
     * 那么：<B,C,A>是X和Y的一个公共子序列，<B,C,B,A>也是X和Y的一个公共子序列；
     * 编程求出给定的两个序列中，最长公共子序列的长度。
     *
     * 输入
     * 共两行，各一个字符串，第一个字符串表示第一个序列，第二个字符串表示第二个序列，两个字符串长度均小于1000。
     *
     * 输出
     * 一个整数，即两个序列的公共子序列的长度。
     */
    //    public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            int num = getLongNum(s1, s2);
            System.out.println(num);
        }
    }

    public static int getLongNum(String s1, String s2) {
        int s1_length = s1.length() + 1;
        int s2_length = s2.length() + 1;

        int max = s1_length > s2_length ? s1_length : s2_length;
        int min = s1_length < s2_length ? s1_length : s2_length;

        int[][] c = new int[max][min];

        for (int i = 1; i < max; i++) {
            for (int j = 1; j < min; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = c[i][j - 1];
                }
            }
        }
        return c[s1_length - 1][s2_length - 1];
    }

    public static int getLongSequence(String str1, String str2) {
        int[][] nums = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); i++) {
            nums[i][0] = 0;
        }
        for (int j = 0; j < str2.length(); j++) {
            nums[0][j] = 0;
        }
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    nums[i][j] = nums[i - 1][j - 1] + 1;
                } else {
                    nums[i][j] = (nums[i - 1][j] >= nums[i][j - 1] ? nums[i - 1][j] : nums[i][j - 1]);
                }
            }
        }
        return nums[str1.length() - 1][str2.length() - 1];
    }


}
