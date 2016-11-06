package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/18.
 */
public class Test13 {
    /**
     * 完美世界 java游戏开发测试题，实现对单链表的  尾部添加元素，中间插入元素 ，指定位置删除元素
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int add = scanner.nextInt();
            int adds[] = new int[add];
            int i = 0;
            while (i < add) {
                adds[i] = scanner.nextInt();
                i++;
            }

            ListNode linkList = new ListNode(adds[0]);
            addNumToEnd(linkList, adds);

            int insert = scanner.nextInt();
            int insert_value = scanner.nextInt();
            insertNum(linkList, insert, insert_value);
            int delete = scanner.nextInt();
            deleteNum(linkList, delete);
            printLinkList(linkList);
        }
    }

    private static void deleteNum(ListNode linkList, int delete) {
        int i = 0;
        if (delete == 0) linkList = null;
        while (i < delete - 1) {
            linkList = linkList.next;
            i++;
        }
        if (linkList.next.next == null) {
            linkList.next = null;

        }
        linkList.next = linkList.next.next;
    }

    private static void printLinkList(ListNode linkList) {
        while (linkList != null) {
            System.out.print(linkList.val + " ");
            linkList = linkList.next;
        }
    }

    private static void insertNum(ListNode head, int insert, int insert_value) {
        ListNode add = new ListNode(insert_value);
        if (insert == 0) {
            add.next = head;
            head = add;
        } else {
            while (head.next != null && insert > 1) {
                head = head.next;
                insert--;
            }
            add.next = head.next;
            head.next = add;
        }
    }

    private static void addNumToEnd(ListNode linkList, int[] adds) {
        if (adds.length <= 0) return;
        for (int j = 1; j < adds.length; j++) {
            linkList.next = new ListNode(adds[j]);
            linkList = linkList.next;
        }
    }
}
