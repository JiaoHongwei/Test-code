package acmcode.big_data;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jiaohongwei on 2017/6/12.
 */

/**
 * 大数据排序算法
 * 1、海量日志数据，提取出某日访问百度次数最多的那个IP

 分析 ：百度作为国内第一大搜索引擎，每天访问它的IP数量巨大，如果想一次性把所有IP数据装进内存处理，则内存容量明显不够，故针对数据太大，内存受限的情况，可以把大文件转化成（取模映射）小文件，从而大而化小，逐个处理。

 换言之，先映射，而后统计，最后排序。

 解法 ：具体分为以下3个步骤

 1.分而治之/hash映射
 首先把这一天访问百度日志的所有IP提取出来，然后逐个写入到一个大文件中，接着采用映射的方法，比如%1000，把整个大文件映射为1000个小文件。
 2.hash_map统计
 当大文件转化成了小文件，那么我们便可以采用hash_map(ip, value)来分别对1000个小文件中的IP进行频率统计，再找出每个小文件中出现频率最大的IP。
 3.堆/快速排序
 统计出1000个频率最大的IP后，依据各自频率的大小进行排序(可采取堆排序)，找出那个频率最大的IP，即为所求。
 注 ：Hash取模是一种等价映射，不会存在同一个元素分散到不同小文件中去的情况，即这里采用的是%1000算法，那么同一个IP在hash后，只可能落在同一个文件中，不可能被分散的。
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
//        hashSort();   拆分文件
//        MapSort();
        queryIps();
    }

    private static void hashSort() throws IOException {
        FileInputStream inputStream = null;
        BufferedWriter output = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("E:\\ip\\random_ip.txt");
            sc = new Scanner(inputStream, "UTF-8");
            List<String> list = new ArrayList<String>();
            while (sc.hasNextLine()) {
                String ip = sc.nextLine();
                int value = ip.hashCode() % 10;
                output = new BufferedWriter(new FileWriter("E:\\ip\\random" + value + ".txt", true));
                output.write(ip);
                output.newLine();
                output.close();
                list.add(ip);
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

    public static void MapSort() {
        FileInputStream inputStream = null;
        Scanner sc = null;
        int[] ips = {0, -1, 1, 2, -2, 3, -3, 4, -4, 5, -5, 6, -6, 7, -7, 8, -8, 9, -9};
        try {
            List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();

            for (int i = 0; i < ips.length; i++) {
                inputStream = new FileInputStream("E:\\ip\\random" + ips[i] + ".txt");
                sc = new Scanner(inputStream, "UTF-8");
                Map<String, Integer> map = new HashMap<String, Integer>();
                while (sc.hasNextLine()) {
                    String ip = sc.nextLine();
                    if (map.containsKey(ip)) {
                        map.put(ip, map.get(ip) + 1);
                    } else {
                        map.put(ip, 1);
                    }
                }
                sc.close();
                inputStream.close();
                Map<String, Integer> newMap = sortByValue(map);
                list.add(newMap);
            }
            Map<String, Integer> resultMap = new HashMap<String, Integer>();

            for (int i = 0; i < list.size(); i++) {
                Map<String, Integer> result = list.get(i);

                Iterator<Map.Entry<String, Integer>> it = result.entrySet().iterator();
                int num = 0;
                while (it.hasNext() && num < 10) {
                    num++;
                    Map.Entry<String, Integer> entry = it.next();
                    resultMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, Integer> r = sortByValue(resultMap);

            Iterator<Map.Entry<String, Integer>> s = r.entrySet().iterator();
            int num = 0;
            while (s.hasNext() && num < 10) {
                num++;
                Map.Entry<String, Integer> entry = s.next();
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//                resultMap.put(entry.getKey(), entry.getValue());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void queryIps() throws IOException {
        FileInputStream inputStream = null;
        BufferedWriter output = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("E:\\ip\\random_ip.txt");
            sc = new Scanner(inputStream, "UTF-8");
            Map<String,Integer> map = new HashMap<String, Integer>();

            List<String> list = new ArrayList<String>();
            while (sc.hasNextLine()) {
                String ip = sc.nextLine();
                if (map.containsKey(ip)) {
                    map.put(ip, map.get(ip) + 1);
                } else {
                    map.put(ip, 1);
                }
            }
            map = sortByValue(map);

            Iterator<Map.Entry<String, Integer>> s = map.entrySet().iterator();
            int num = 0;
            while (s.hasNext() && num < 10) {
                num++;
                Map.Entry<String, Integer> entry = s.next();
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//                resultMap.put(entry.getKey(), entry.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sc.close();
            inputStream.close();
        }


    }


}
