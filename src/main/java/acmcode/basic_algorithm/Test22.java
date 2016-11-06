package acmcode.basic_algorithm;

/**
 * Created by jiaohongwei on 2016/9/23.
 */
public class Test22 {
    /**
     * 237. Delete Node in a Linked List  QuestionEditorial Solution
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int a) {
            val = a;
        }
    }

    public void deleteNode(ListNode node) {
        if(node==null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
