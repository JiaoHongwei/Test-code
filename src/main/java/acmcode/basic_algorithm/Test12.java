package acmcode.basic_algorithm;

/**
 * Created by jiaohongwei on 2016/9/17.
 */
public class Test12 {
    /**
     * moveZeros，将一个数组中的0 移到数组的最后，其他元素先后顺序不错
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {12, 3, 4, 0, 2, 0, 2, 0, 3, 3, 3, 4, 0, 2, 0};
        System.out.print("排序前：");
        printArray(a);
        moveZeros(a);
        System.out.println();
        System.out.print("排序后：");
        printArray(a);
    }

    private static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void moveZeros(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                int next = i;
                while (next < a.length) {
                    next = getNextValue(next, a);
                    if (next == -1) break;
                    a[i] = a[next];
                    i++;
                    next++;
                }
                for (int j = i; j < a.length; j++) {
                    a[j] = 0;
                }
                return;
            }

        }
    }

    private static int getNextValue(int i, int[] a) {
        if (a[i] != 0)
            return i;
        else
            return i == a.length - 1 ? -1 : getNextValue(i + 1, a);
    }
}
