package acmcode.basic_algorithm;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jiaohongwei on 2016/9/5.
 * 单词反转
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个英文单词：");
        while (scanner.hasNext()) {
            getReverseString(scanner.next());
        }
    }

    private static void getReverseString(String next) {
        Stack stack = new Stack();
        char[] characters = next.toCharArray();
        for (char character : characters) {
            stack.push(character);//压入栈中
        }
        while (stack.elements().hasMoreElements()) {
            System.out.print(stack.pop());//取栈头
        }
    }
}
