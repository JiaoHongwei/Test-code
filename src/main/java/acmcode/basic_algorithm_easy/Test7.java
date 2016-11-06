package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/10/8.
 */
public class Test7 {
    //    public class Main{

    /**
     * 盛大游戏笔试题
     *
     * 第 3/3 题   编程题 (20.0分)   科目名称：软件编程 试题描述： 题目描述 今天的英语课，王老师为了复习以前学过的单词，提高学生的学习兴趣，想出了一个主意：
     * 读入M组数据，其中每组数据有一个单词L（单词长度≤36个字符）和一个整数N(1≤N≤36)，从该单词最末位开始逐位移到单词的开头，如果还没达到N值，则再从末位开始移动，直到达N值为止，求移N位后的新单词。你能编程帮助贝贝最快完成任务吗？
     *
     * 输入 文件共有2×M+I行，第1行为M，第2行开始为具体数据，每一组数据有2行，第1行字串L，第2行为N。
     *
     * 输出 共M行，每行为旋转后的字串。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int M = scanner.nextInt();
            for (int i = 0; i < M; i++) {
                String input = scanner.next();
                int N = scanner.nextInt();
                String result = getString(input, N);
                System.out.println(result);
            }
        }
    }

    private static String getString(String input, int n) {
        if (n > input.length()) {
            return getString(input, n - input.length());
        }
        int begin = input.length() - n;
        return input.substring(begin, input.length()) + input.substring(0, begin);
    }
}
