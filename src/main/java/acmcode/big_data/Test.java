package acmcode.big_data;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by jiaohongwei on 2017/6/12.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        insertRandom();
        sortRandom();
    }

    private static void insertRandom() throws IOException {
        FileInputStream inputStream = null;
        BufferedWriter output = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("E:\\ip\\ip.txt");
            output = new BufferedWriter(new FileWriter("E:\\ip\\new_ip.txt"));
            sc = new Scanner(inputStream, "UTF-8");
            int num = 0;
            while (sc.hasNextLine()) {
                num++;
                int random = random(100,0);
                String ip = sc.nextLine();
                for (int i = 0; i < random; i++) {
                    output.write(ip);
                    output.newLine();
                }
            }

        } finally {
            sc.close();
            inputStream.close();
            output.close();
        }
    }

    public static void sortRandom() throws IOException {
        FileInputStream inputStream = null;
        BufferedWriter output = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("E:\\ip\\new_ip.txt");
            output = new BufferedWriter(new FileWriter("E:\\ip\\random_ip.txt"));
            sc = new Scanner(inputStream, "UTF-8");
            List<String> list = new ArrayList<String>();
            while (sc.hasNextLine()) {
                String ip = sc.nextLine();
                list.add(ip);
            }

            for (int i = 0; i < list.size(); i++) {
                int random = random(100,0);
                String temp = list.get(i);
                list.set(i,list.get(random));
                list.set(random,temp);
            }

            for (String s : list) {
                output.write(s);
                output.newLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
            inputStream.close();
            output.close();
        }
    }

    public static int random(int max,int min){
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }
}
