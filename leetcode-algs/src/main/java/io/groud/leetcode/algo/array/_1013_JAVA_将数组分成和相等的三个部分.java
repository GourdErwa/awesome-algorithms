package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 *
 * @author Li.Wei by 2020/3/11
 */
public class _1013_JAVA_将数组分成和相等的三个部分 {

    // 暴力循环
    static class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            int length = A.length;
            int sumI = 0;

            for (int i = 0; i < length - 2; i++) {
                sumI += A[i];
                int sumJ = 0;
                for (int j = i + 1; j < length - 1; j++) {
                    sumJ += A[j];
                    if (sumI != sumJ) continue; // 如果前 2 部分不相等直接跳出
                    int sumM = 0;
                    for (int m = j + 1; m < length; m++) {
                        sumM += A[m];
                    }
                    if (sumJ == sumM) return true; // 如果相等返回
                }
            }
            return false;
        }
    }

    // 逐份计算
    static class Solution1 {
        public boolean canThreePartsEqualSum(int[] A) {
            int length = A.length;

            // 计算整个数组的和，如果和不能被 3 整除说明肯定不能分三份
            int sumA = 0;
            for (int i : A) sumA += i;
            if (sumA % 3 != 0) return false;

            int partSum = sumA / 3; // 每份的和

            // 寻找第一部分的 partSum

            int i = 0;
            int sum = 0;
            while (i < length - 2) {
                sum += A[i];
                if (sum == partSum) break;
                i++;
            }
            // 如果第一部分的下标越界到最后一个位置说明该部分和不成立
            if (i == length - 2) return false;

            // 寻找第二部分的 partSum

            i++; // 下标前进 1
            sum = 0; // 计数归 0
            while (i < length - 1) {
                sum += A[i];
                if (sum == partSum) break;
                i++;
            }
            // 如果第二部分的下标越界到最后一个位置说明该部分和不成立
            return i == length - 1;
        }
    }

    // 逐份计算
    static class Solution2 {
        public boolean canThreePartsEqualSum(int[] A) {
            int sumA = 0;
            for (int i : A) sumA += i;
            if (sumA % 3 != 0) return false; // 不是 3 的倍数肯定不合法
            int partSum = sumA / 3; // 每份的和
            int sum = 0;
            int count = 0;
            for (int a : A) {
                sum += a;
                if (sum == partSum) { // 求和成功，计数加一并将求和变量归 0
                    count++;
                    sum = 0;
                }
            }
            return count > 2;
        }
    }

    // [14,6,-10,2,18,-7,-4,11]
    public static void main(String[] args) {
        Solution o = new Solution();
        System.out.println(o.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
    }
}
