package leonardo.ezio.personal.leetcode.algorithm.problem.T1_T200;

/**
 * @ClassName : Solution53
 * @Author : LeonardoEzio
 * @Date : 2020-11-28 12:45
 * @Description : Leet code 53题 题解
 *
 *
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 *
 */
public class Solution53 {

    public static int maxSubArray(int[] nums) {
        int preMax = 0, curMax = nums[0];
        for (int num : nums) {
            preMax = Math.max(preMax + num, num);
            curMax = Math.max(preMax, curMax);
        }
        return curMax;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

}
