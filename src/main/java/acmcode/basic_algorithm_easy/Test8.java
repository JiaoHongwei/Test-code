package acmcode.basic_algorithm_easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by jiaohongwei on 2016/10/15.
 * 去哪网笔试题
 * 题目描述：
 * 给定两个均由大写英文字母组成的字符串（A-Z），检查这两个字符串是否包含相同的字母
 * 输入
 * 两个字符串
 * 输出
 * true / false
 *
 * 样例输入
 * FDJ  DJDF
 * MIJJ  MOJI
 * 样例输出
 * true
 * false
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean a = incloud(scanner.next(), scanner.next());
            System.out.println(a);
        }
    }

    private static boolean incloud(String s1, String s2) {
        char[] ss = s1.toCharArray();
        if (s1 == null || s2 == null) return false;
        if (s1 == "" || s2 == "") return false;

        for (int i = 0; i < ss.length - 1; i++) {
            if (s2.contains(ss[i] + "" + ss[i + 1] + "")) {
                return true;
            }
        }
        return false;
    }

    public static boolean in(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Set<Character> set_a = new HashSet<Character>();
        Set<Character> set_b = new HashSet<Character>();
        for (char c : a) {
            set_a.add(c);
        }
        for (char c : b) {
            set_b.add(c);
        }
        if (set_a.size() != set_b.size()) return false;
        boolean flag = false;
        for (Character character : set_a) {
            if (!set_b.contains(character)) {
                return false;
            }
        }
        return true;
    }

    public static boolean incloud2(String s1, String s2) {
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        int[] bCount = new int[256];
        for (int i = 0; i < 256; i++) {
            bCount[i] = 0;
        }
        for (int i = 0; i < b1.length; i++)
            bCount[b1[i] - '0']++;
        for (int i = 0; i < b2.length; i++)
            bCount[b2[i] - '0']--;
        for (int i = 0; i < 256; i++) {
            if (bCount[i] != 0)
                return false;
        }
        return true;
    }
}
