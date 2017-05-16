package acmcode.data_structure;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaohongwei on 2017/3/30.
 */
public class Test5 {

    public static void main(String[] args) {

        FileInputStream inputStream = null;
        FileInputStream inputStream2 = null;

        Scanner sc = null;
        Scanner sc2 = null;

        try {
            inputStream = new FileInputStream("C:\\Users\\jiaohongwei\\Desktop\\LRR序列号\\被减数\\result.txt");
            inputStream2 = new FileInputStream("C:\\Users\\jiaohongwei\\Desktop\\LRR序列号\\减数1\\NB-LRR.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter("C:\\Users\\jiaohongwei\\Desktop\\LRR序列号\\被减数\\result2.txt"));
            sc = new Scanner(inputStream, "UTF-8");
            List<String> set =new ArrayList<String>();

            long start_time = System.currentTimeMillis();
            int num = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                set.add(line);
                num++;
            }
            sc2 = new Scanner(inputStream2, "UTF-8");
            List<String> set2 =new ArrayList<String>();

            int num2 = 0;
            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                set2.add(line);
                num2++;
            }
            set.removeAll(set2);

            System.out.println("一共" + num + "个");
            for (String s : set) {
                output.write(s);
                output.newLine();
            }

            long end = System.currentTimeMillis();
            System.out.println("程序运行结束，共耗时：" + (end - start_time) / 1000 + "s");
            inputStream.close();
            inputStream2.close();
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
