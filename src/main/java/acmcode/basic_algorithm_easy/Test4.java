package acmcode.basic_algorithm_easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by jiaohongwei on 2016/9/29.
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int T = scanner.nextInt();
            int j = 0;
            while (j < T) {
                int num = scanner.nextInt();
                List<List<String>> list = new ArrayList<List<String>>();

                for (int i = 0; i < num; i++) {
                    List<String> l = new ArrayList<String>();
                    l.add(scanner.nextLine());
                }

                System.out.println("Case #" + (j + 1) + ":");
                Set<String> a = getAorB(list);
                Set<String> b = getAandB(list);
                j++;
            }
        }
    }


    private static Set<String> getAorB(List<List<String>> list) {
        Set<String> set = new HashSet<String>();
        int size = list.size();
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                int j = i + 1;
                if (j < size) {
                    list.get(0).retainAll(list.get(j));
                    if (i == size - 2) {
                        List<String> resultList = list.get(0);
                        for (String name : resultList) {
                            set.add(name);
                        }
                    }
                }
            }
        } else {
            for (List<String> list2 : list) {
                for (String name : list2) {
                    set.add(name);
                }
            }
        }
        return set;
    }


    private static Set<String> getAandB(List<List<String>> list) {
        Set<String> set = new HashSet<String>();
        if (list == null) {
            list = new ArrayList<List<String>>();
        }
        int size = list.size();
        if (size > 1) {
            for (int i = 0; i < size; i++) {
                int j = i + 1;
                if (j < size) {
                    list.get(0).removeAll(list.get(j));
                    list.get(0).addAll(list.get(j));
                    if (i == size - 2) {
                        List<String> resultList = list.get(0);
                        for (String name : resultList) {
                            set.add(name);
                        }
                    }
                }
            }
        } else {
            for (List<String> list2 : list) {
                for (String name : list2) {
                    set.add(name);
                }
            }
        }
        return set;
    }
}
