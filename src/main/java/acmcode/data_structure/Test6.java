package acmcode.data_structure;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jiaohongwei on 2017/4/10.
 */
public class Test6 {
    /**
     * 张士龙
     */

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = null;

        Scanner sc = null;
        try {
            inputStream = new FileInputStream("E:\\张世龙\\小麦.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter("E:\\张世龙\\result_小麦.txt"));
            sc = new Scanner(inputStream, "UTF-8");

            long start_time = System.currentTimeMillis();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("heading \"Genomic\"")){
                    String nextLine=sc.nextLine();
                    output.newLine();
                    output.write(nextLine.substring(nextLine.indexOf("\"")+1,nextLine.length()-2));
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("程序运行结束，共耗时：" + (end - start_time) / 1000 + "s");
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
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }

        }
    }
}
