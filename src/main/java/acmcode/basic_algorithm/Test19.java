package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/21.
 */
public class Test19 {
    /**
     * 搜狐，袋鼠过河问题，
     */
    public static class Node {
        int value;
        Node next;

        public Node(int n) {
            this.value = n;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
            }
            int num = getResult(n, a);
            System.out.println(num);
        }
    }

    private static int getResult(int n, int[] a) {

        if (a.length < 0) return -1;
        Node node = new Node(a[0]);

        int b=0;
        for (int i = 0; i < a.length; ) {
            if (a[0] == 0) return -1;
            else {
                node.next = new Node(a[i]);
                node = node.next;
                b++;
                i = i + a[i];
                if (i>n){
                    return b;
                }
            }
        }
        return 0;
    }

}
