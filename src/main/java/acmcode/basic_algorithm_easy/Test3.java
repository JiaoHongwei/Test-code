package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/28.
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int time = scanner.nextInt();
            System.out.println(getAandB(time));
        }
    }

    private static String getAandB(int time) {
        if (time == 1) {
            return "0 1";
        }
        int t = 1;
        int a_num = 0;
        int b_num = 1;
        String string = new String("B");
        StringBuffer stringBuffer = new StringBuffer(string);
        while (time > t) {
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ("B".equals(chars[i] + "")) {
                    stringBuffer.insert(i + 1, "A");
                    a_num++;
                } else {
                    stringBuffer.replace(i, i + 1, "B");
                    b_num++;
                }

            }
            t++;
            string = stringBuffer.toString();

        }
        return a_num + " " + b_num;
    }
}
