package acmcode.basic_algorithm_easy;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/28.
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String time = scanner.next();
            String money = getMoney(Double.valueOf(time));
            System.out.println(money);
        }
    }

    private static String getMoney(double time) {
        double money = 0;
        String m = null;
        if (time > 0 && time <= 3) {
            money = 5 * (time / 3);
            m = (money + "");
        } else if (time > 3) {
            money = 5 + (time - 3) * 2;
            m = money > 50 ? "50.00" : (money + "");
        } else {
            m = "0.00";
        }
        if (m.substring(m.lastIndexOf(".")).length() < 3) {
            int a = 2 - m.substring(m.lastIndexOf(".")).length();
            switch (a) {
                case 0:
                    return m + "0";
                case 1:
                    return m + "0";
            }
            return m;
        } else {
            return m.substring(0, m.lastIndexOf(".") + 3);
        }
    }
}
