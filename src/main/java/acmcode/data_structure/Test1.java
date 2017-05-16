package acmcode.data_structure;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2017/3/7.
 */
public class Test1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            ifNum(a);
            System.out.println(a);
        }
    }

    private static void ifNum(int a) {

    }

}
