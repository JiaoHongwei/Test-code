package acmcode.basic_algorithm;

/**
 * Created by jiaohongwei on 2016/9/10.
 */
public class Test9 {
    public static class Node {
        int value;
        Node next;
        public Node(int n) {
            this.value = n;
            this.next = null;
        }
    }


    /**
     * moveZeroes
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 0, 2, 0, 4, 3};
        moveZeroes(a);

        for (int i : a) {
            System.out.print(i+"_");
        }
    }

    public static void moveZeroes(int[] nums) {
        int zero = 0, start = 0, end = 0;
        while(true) {
            while(zero < nums.length && nums[zero] != 0)
                zero++;
            if(zero == nums.length)
                return;
            start = zero + 1;
            while(start < nums.length && nums[start] == 0)
                start++;
            if(start == nums.length)
                return;
            end = start;
            while(end < nums.length && nums[end] != 0)
                end++;
            end--;
            for(int i = start; i <= end; i++) {
                nums[zero] = nums[i];
                zero++;
            }
            for(int i = zero; i <= end; i++)
                nums[i] = 0;
        }
    }


}
