package acmcode.basic_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/20.
 */
public class Test15 {
    /**
     * Binary Watch
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            readBinaryWatch(scanner.nextInt());
        }
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        if (num == 0) {
            list.add("0:00");
            return list;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = num-i; j < 6; j++) {

            }
        }
        return list;
    }
}
