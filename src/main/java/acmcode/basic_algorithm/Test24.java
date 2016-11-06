package acmcode.basic_algorithm;

import java.util.Scanner;

/**
 * Created by jiaohongwei on 2016/9/23.
 */
public class Test24 {
    /**
     * 滴滴笔试题
     * 把一个整数M转换成N进制的数，若N大于9 则用ABCD……表示
     * <p>
     * * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int M = scanner.nextInt();
//            int N = scanner.nextInt();
//            String num = getResult(M, N);
            String num = toHex(M);
            System.out.println(num);
        }
    }

    //思路就是……根据转换公式得，转成几进制就除以几求余……循环然后把得到的余数拼接起来
    private static String getResult(int m, int n) {
        if (n < 2 || n > 16) return null;
        StringBuffer stringBuffer = new StringBuffer();
        while (m != 0) {//循环
            int a = m % n;//最后一位
            m = m / n;
            if (a > 9) {
                stringBuffer.insert(0, getABC(a));
            } else {
                stringBuffer.insert(0, a);
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 装成二进制
     *
     * @param m
     * @return
     */
    private static String toEr(int m) {
        StringBuffer stringBuffer = new StringBuffer();
        while (m != 0) {
            int a = m % 2;
            m = m / 2;
            stringBuffer.insert(0, a);
        }
        return stringBuffer.toString();
    }

    private static char getABC(int a) {
        int num = a - 10;
        char[] n = {'a', 'b', 'c', 'd', 'e', 'f'};
        return n[num];
    }
    public static String binaryString2hexString(String bString)
    {
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)
            return null;
        StringBuffer tmp = new StringBuffer();
        int iTmp = 0;
        for (int i = 0; i < bString.length(); i += 4)
        {
            iTmp = 0;
            for (int j = 0; j < 4; j++)
            {
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
            }
            tmp.append(Integer.toHexString(iTmp));
        }
        return tmp.toString();
    }

    public static String toHex(int m) {
        if (m < 0) {
            String a = toEr(m);
            System.out.println(a);
            long b = ~Integer.parseInt(a);
            System.out.println(b);
            long c = b + 1;
            return binaryString2hexString(c+"");
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (m == 0) return "0";
        while (m != 0) {//循环
            int a = m % 16;//最后一位
            m = m / 16;
            if (a > 9) {
                stringBuffer.insert(0, getABC(a));
            } else {
                stringBuffer.insert(0, a);
            }
        }
        return stringBuffer.toString();
    }
}
