package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/23.
 */
public class Test25 {
    /**
     * 滴滴笔试题
     * 从n个数中 任取数字使其 和=M，求一共的组合数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < A.length; i++) {
                A[i] = scanner.nextInt();
            }
            int mm = getResult2(A, sum);
            System.out.println(mm);
        }
    }

    private static int getResult2(int[] a, int sum) {
        int count = 0;
        int num = a.length;
        while (num > 0) {
            for (int i = 0; i < a.length; i++) {
                int i_sum = a[i];
                for (int j = i + 1; j < a.length; j++) {
                    int j_num = num;
                    int z = j;
                    while (j_num > 0) {
                        if (z >= a.length) {
                            if (z - a.length > i) {
                                break;
                            }
                            i_sum += a[z - a.length];
                        } else {
                            i_sum += a[z];
                        }
                        z++;
                        j_num--;
                    }
                    if (i_sum == sum) {
                        count++;
                    }
                }
            }
            num--;
        }
        return count;
    }
}
