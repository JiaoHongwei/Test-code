package acmcode.basic_algorithm;

import java.util.*;

/**
 * Created by jiaohongwei on 2016/9/6.
 */

/**
 * 任意给一个整数数组，找出其中没有重复的数字；
 */
public class Test5 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String input = scanner.nextLine();
//            if (input.length() == 0) return;
//            String[] a = input.split(",");
//            int[] b = new int[a.length];
//            for (int i = 0; i < a.length; i++) {
//                b[i] = Integer.parseInt((a[i]));
//            }
//            System.out.println(getSingleNumber(b));
//            System.out.println(getSingleNumberEasy(b));
//            System.out.println(getSingleNumberQuickly(b));
//        }
//    }

    /**
     * 时间最快的
     * @param b
     * @return
     */
    private static int getSingleNumberQuickly(int[] b) {
        int num = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < b.length; i++) {
            if (map.get(b[i]) != null) {
                num -= b[i];
            } else {
                num += b[i];
                map.put(b[i], 1);
            }
        }
        return num;
    }

    private static int getSingleNumberEasy(int[] b) {
        for (int i = 0; i < b.length; i++) {
            boolean flag = false;
            for (int j = 0; j < b.length; j++) {
                if (i != j && b[i] == b[j]) {
                    flag = true;
                }
            }
            if (!flag) return b[i];
        }
        return 0;
    }

    private static int getSingleNumber(int[] b) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : b) {
            map.put(i, map.get(i) != null ? 2 : 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /*
     * 快速排序
	 *
	 * 参数说明：
	 *     a -- 待排序的数组
	 *     l -- 数组的左边界(例如，从起始位置开始排序，则l=0)
	 *     r -- 数组的右边界(例如，排序截至到数组末尾，则r=a.length-1)
	 */
    public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int i, j, x;
            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            printArray(a);
            quickSort(a, l, i - 1); /* 递归调用 */
            quickSort(a, i + 1, r); /* 递归调用 */
        }
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"->");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int [] a={2,4,5,1,3};
        quickSort(a,0,4);
    }


}
