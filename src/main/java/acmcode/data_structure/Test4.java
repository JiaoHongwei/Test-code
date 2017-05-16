package acmcode.data_structure;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by jiaohongwei on 2017/3/30.
 */
public class Test4 {
    public static void main(String[] args) {

        /**
         * 去重
         */
        FileInputStream inputStream = null;

        Scanner sc = null;
        try {
            inputStream = new FileInputStream("C:\\Users\\jiaohongwei\\Desktop\\LRR序列号\\被减数\\total.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter("C:\\Users\\jiaohongwei\\Desktop\\LRR序列号\\被减数\\result.txt"));
            sc = new Scanner(inputStream, "UTF-8");
            Set<String> set = new HashSet<String>();

            long start_time = System.currentTimeMillis();
            int num = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                set.add(line);
                num++;
            }
            System.out.println("一共" + num + "个");
            System.out.println("去重成功，剩余" + set.size() + "个");
            for (String s : set) {
                output.write(s);
                output.newLine();
            }

            long end = System.currentTimeMillis();
            System.out.println("程序运行结束，共耗时：" + (end - start_time) / 1000 + "s");
            inputStream.close();
            output.close();
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }

        } catch (
                FileNotFoundException e)

        {
            e.printStackTrace();
        } catch (
                IOException e)

        {
            e.printStackTrace();
        } finally

        {
            if (sc != null) {
                sc.close();
            }

        }
    }
}