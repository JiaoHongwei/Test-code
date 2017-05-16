package acmcode.data_structure;

/**
 * Created by LI on 2017/4/14.
 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test10 {

    public static void main(String[] args) {

//        checkData("CK1_CK2_vs_CK5d2_CK5d3.txt", "H:\\0\\All_Combination.Transcripts.fa");

//        checkData("CK1_CK2_vs_Mn6h1_Mn6h2_Mn6h3.txt", "H:\\1\\All_Combination.Transcripts.fa");
//
//        checkData("CK1_CK2_vs_Mn12h1_Mn12h2.txt", "H:\\2\\All_Combination.Transcripts.fa");
//
//        checkData("CK5d2_CK5d3_vs_Mn5d2_Mn5d3.txt", "H:\\3\\All_Combination.Transcripts.fa");
//
//        checkData("Mn6h1_Mn6h2_Mn6h3_vs_Mn5d2_Mn5d3.txt", "H:\\4\\All_Combination.Transcripts.fa");
//
//        checkData("Mn6h1_Mn6h2_Mn6h3_vs_Mn12h1_Mn12h2.txt", "H:\\5\\All_Combination.Transcripts.fa");
//
//        checkData("Mn12h1_Mn12h2_vs_Mn5d2_Mn5d3.txt", "H:\\6\\All_Combination.Transcripts.fa");
        checkData("Mn5d.txt", "E:\\焦宏伟\\All_Combination.Transcripts.fa");

//        /**
//         * 多线程运行
//         */
//        ExecutorService threadPool = Executors.newFixedThreadPool(6);
//        threadPool.execute(new Runnable() {
//            public void run() {
//            }
//        });
//
//        threadPool.execute(new Runnable() {
//            public void run() {
//            }
//        });
//        threadPool.execute(new Runnable() {
//            public void run() {
//            }
//        });
//        threadPool.execute(new Runnable() {
//            public void run() {
//            }
//        });
//        threadPool.execute(new Runnable() {
//            public void run() {
//            }
//        });
//        threadPool.execute(new Runnable() {
//            public void run() {
//            }
//        });

    }

    public static void checkData(String filename, String total_path) {
        /**
         * for me
         */
        FileInputStream inputStream = null;
        FileInputStream inputStream1 = null;
        Scanner sc = null;
        Scanner sc1 = null;
        try {
            //先读出需要筛选的蛋白质序列
            inputStream = new FileInputStream("E:\\result\\" + filename);
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
            BufferedWriter output = new BufferedWriter(new FileWriter("E:\\result\\" + filename + ".fasta"));
            int num = 0;
            int total = list.size();

            inputStream1 = new FileInputStream(total_path);
            sc1 = new Scanner(inputStream1, "UTF-8");
            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                checkLine(sc1, list, output, line);
            }

            output.close();

            long end = System.currentTimeMillis();

            System.out.println(filename + "筛选结束，共耗时：" + (end - start_time) / 1000 + "s");

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

    private static void checkLine(Scanner sc1, List<String> list, BufferedWriter output, String line) throws IOException {
        if (line.startsWith(">")) {
            String[] line_array = line.split(" ");
            String target_gene = line_array[0].substring(1, line_array[0].lastIndexOf("_"));
            for (String s : list) {
                if (s.equals(target_gene)){
                    output.write(line);
                    output.newLine();
                    String new_line=null;
                    in:while (sc1.hasNext() ){
                        new_line=sc1.nextLine();
                        if (!new_line.startsWith(">")){
                            output.write(new_line);
                            output.newLine();
                        }else {
                            break in;
                        }
                    }
                    checkLine(sc1,list,output,new_line);
                }
            }

        }
    }

    //529   1324  123  28  1879  2291
}