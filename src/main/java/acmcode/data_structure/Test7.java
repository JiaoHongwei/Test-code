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
public class Test7 {
    /**
     * =
     */

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = null;

        Scanner sc = null;
        try {
            inputStream = new FileInputStream("E:\\焦宏伟\\genome_result.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter("E:\\焦宏伟\\genome_id_result.txt"));
            sc = new Scanner(inputStream, "UTF-8");
            int num = 0;
            long start_time = System.currentTimeMillis();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.contains("Genome ID:")) {
                    output.write(line.substring(11, line.length()));
                    output.newLine();
                    num++;
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("程序运行结束，共" + num + "个，共耗时：" + (end - start_time) / 1000 + "s");
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
