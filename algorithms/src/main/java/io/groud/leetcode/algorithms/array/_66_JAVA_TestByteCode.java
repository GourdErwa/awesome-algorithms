package io.groud.leetcode.algorithms.array;

/**
 * 测试方法不同写法的字节码
 *
 * @author Li.Wei by 2020/2/6
 */
class _66_JAVA_TestByteCode {
    /*
     0 aload_1
 1 arraylength
 2 istore_2
 3 iload_2
 4 iconst_1
 5 isub
 6 istore_3
 7 iload_3
 8 iflt 39 (+31)
11 aload_1
12 iload_3
13 iaload
14 iconst_1
15 iadd
16 bipush 10
18 irem
19 istore 4
21 aload_1
22 iload_3
23 iload 4
25 iastore
26 iload 4
28 ifeq 33 (+5)
31 aload_1
32 areturn
33 iinc 3 by -1
36 goto 7 (-29)
39 aconst_null
40 areturn

     */
    public int[] plusOne1(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            int num = (digits[i] + 1) % 10;
            digits[i] = num;
            if (num != 0) { // 是否发生进位
                return digits;
            }
        }
        return null;
    }

    /*
     0 aload_1
 1 arraylength
 2 istore_2
 3 iload_2
 4 iconst_1
 5 isub
 6 istore_3
 7 iload_3
 8 iflt 34 (+26)
11 aload_1
12 iload_3
13 aload_1
14 iload_3
15 iaload
16 iconst_1
17 iadd
18 bipush 10
20 irem
21 dup_x2
22 iastore
23 ifeq 28 (+5)
26 aload_1
27 areturn
28 iinc 3 by -1
31 goto 7 (-24)
34 aconst_null
35 areturn

     */
    public int[] plusOne2(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if ((digits[i] = ((digits[i] + 1) % 10)) != 0) { // 是否发生进位
                return digits;
            }
        }
        return null;
    }
}
