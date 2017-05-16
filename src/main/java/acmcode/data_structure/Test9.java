package acmcode.data_structure;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test9 {

    public static void main(String[] args){

        /**
         * for me
         */
        FileInputStream inputStream = null;
        FileInputStream inputStream1 = null;
        Scanner sc = null;
        Scanner sc1 = null;
        String filename = "Pkinase-remove";
        try {
            //先读出需要筛选的蛋白质序列
            inputStream = new FileInputStream("E:\\bio\\" + filename + ".txt");
            sc = new Scanner(inputStream, "UTF-8");
            long start_time = System.currentTimeMillis();
            List<String> list = new ArrayList<String>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.trim() != null && line.trim() != "")
                    System.out.println(line);
                    list.add(line.trim());
            }
            System.out.println("共" + list.size() + "条需要筛选的数据");
            sc.close();
            inputStream.close();

            //遍历循环，查找文件，比对成功的输出到文件中
            BufferedWriter output = new BufferedWriter(new FileWriter("E:\\bio\\result\\" + filename + ".fasta"));
            loop:
            for (String s : list) {
                inputStream1 = new FileInputStream("E:\\bio\\五万.fasta");
                sc1 = new Scanner(inputStream1, "UTF-8");
                while (sc1.hasNext()) {
                    String line = sc1.nextLine();
                    if (line.contains("|" + s + "|")) {
                        output.write(line);
                        output.newLine();
                        while (sc1.hasNext()) {
                            String line_a = sc1.nextLine();
                            if (!line_a.contains(">")) {
                                output.write(line_a);
                                output.newLine();
                            } else {
                                System.out.println(s + "查找成功");
                                sc1.close();
                                inputStream1.close();
                                continue loop;
                            }

                        }
                    }
                }
            }

            output.close();

            long end = System.currentTimeMillis();
            System.out.println("程序运行结束，共耗时：" + (end - start_time) / 1000 + "s");

            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }

        }
    }
}