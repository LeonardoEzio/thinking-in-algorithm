package leonardo.ezio.personal.leetcode.algorithm.problem.T400_T600;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : Solution454
 * @Author : LeonardoEzio
 * @Date : 2020-11-29 22:05
 * @Description : Leet code 454题 题解
 *
 *
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 *
 */
public class Solution454 {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumHash = new HashMap<>();
        //将AB 的和放入 hash表中
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                sumHash.put(A[i] + B[i1], sumHash.getOrDefault(A[i] + B[i1], 0) + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < C.length; i++) {
            for (int i1 = 0; i1 < D.length; i1++) {
                int key = -(C[i] + D[i1]);
                result += sumHash.getOrDefault(key,0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int result = fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println(result);
    }

}
