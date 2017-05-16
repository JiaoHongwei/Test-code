package acmcode.data_structure;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = null;

        Scanner sc = null;
        try {
            inputStream = new FileInputStream("E:\\张世龙\\seq.fasta");
            BufferedWriter output = new BufferedWriter(new FileWriter("E:\\张世龙\\result_seq.txt"));
            sc = new Scanner(inputStream, "UTF-8");
            int length = 0;    //序列总长度
            int len = 0;    //筛选序列长度
            int start = 0;  //符合条件的序列开始位置
            int num = 0;    //记录筛选的条件
            long start_time = System.currentTimeMillis();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                char[] a = line.toCharArray();
                for (int z = 0; z < a.length; z++) {

                    length++;
                    if (a[z] == 'N') {
                        if (len == 0) {
                            start = length;
                        }
                        len++;
                    } else if (len != 0) {

                        if (len >= 100){
                            num++;
                            String result = "第" + num + "次出现N,从第" + start + "个开始,共" + len + "个";
                            output.write(result);
                            output.newLine();
                        }
                        len = 0;
                    }

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