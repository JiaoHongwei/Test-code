package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/23.
 */
public class Test23 {
    /**
     * 383. Ransom Note  QuestionEditorial Solution
     * 判断后面的字符是否全部包含前面的
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String m = scanner.next();
            String n = scanner.next();
            System.out.println(canConstruct1(m, n));
        }
    }

    private static boolean canConstruct1(String ransomNote, String magazine) {
        StringBuilder stringBuilder = new StringBuilder(magazine);
        char[] a = ransomNote.toCharArray();
        int i = 0;
        while (i < a.length && magazine.contains(a[i] + "")) {
            int m = stringBuilder.indexOf(a[i] + "");
            stringBuilder.delete(m, m + 1);
            magazine = stringBuilder.toString();
            i++;
        }
        return a.length == i ? true : false;
    }
}
