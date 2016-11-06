package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/5.
 */

/**
 * 京东笔试题：幸运数字
 * 十进制和二进制的 各位数字相加的和相等，则为幸运数字
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            getLuckNum(n);
        }
    }
    private static void getLuckNum(int n) {
        System.out.println("luck num:");
        for (int i = 0; i < n; i++) {
            int TenLuck=getLuckNumTen(i);
            int twoLuck=getLuckNumTwo(i);
            if (twoLuck==TenLuck){
                System.out.println("i="+i+";"+TenLuck+"="+twoLuck);
            }
        }
    }

    private static int getLuckNumTwo(int n) {
        String a=Integer.toBinaryString(n);
        int sum=0;
        char[] b=a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            sum+=Integer.parseInt(b[i]+"");
        }
        return sum;
    }

    private static int getLuckNumTen(int n) {
        int sum=0;
        int size=(n+"").length();
        int[] a=new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i]= Integer.parseInt((n+"").substring(size-i-1,size-i));
            sum+=a[i];
        }
        return sum;
    }

}
