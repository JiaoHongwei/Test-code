package acmcode.basic_algorithm_easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jiaohongwei on 2016/9/27.
 */
public class Main {
    /**
     * 349. Intersection of Two Arrays  QuestionEditorial Solution
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 6};
        int[] b = {2, 3, 4, 5, 6, 7, 8, 2};
        int[] c = intersection(a, b);
        for (int i : c) {
            System.out.print(i + "-");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<Integer>();
        int[] max = null;
        int[] min = null;
        if (nums1.length > nums2.length) {
            max = nums1;
            min = nums2;
        } else {
            max = nums2;
            min = nums1;
        }
        for (int i : max) {
            for (int i1 : min) {
                if (i == i1) {
                    set.add(i);
                }
            }
        }
        Integer[] list = set.toArray(new Integer[0]);
        int[] a = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            a[i] = list[i];
        }
        return a;
    }
}
