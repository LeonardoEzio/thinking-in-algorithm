package leonardo.ezio.algorithm.leetcode.problem;


import java.util.ArrayList;
import java.util.List;

/**
 * 198. 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * */
public class Solution198 {

    /**
     * 贪心算法实现，不能实现全局最优解
     * */
    public static int solution(int [] nums){
        int n = nums.length;
        if (n <= 0){
            return 0;
        }
        //存储偷或不偷得到的收益
        int[][] robs = new int[n][2];
        //初始化偷第一家所能偷到的金额
        robs[0][0] = nums[0];
        //初始化不偷第一家的金额
        robs[0][1] = 0;
        for (int i = 1; i<n ; i++){
            //状态转移
            //偷这家 由不偷上一家转移而来
            robs[i][0] = robs[i - 1][1] + nums[i];
            //不偷这家 可由 不偷上一家 以及偷上一家转移而来 取其最大值
            robs[i][1] = Math.max(robs[i - 1][1], robs[i - 1][0]);
        }
        return Math.max(robs[n-1][0],robs[n-1][1]);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,7,9,3,1};
        int solution = solution(arr);
        System.out.println(solution);
    }
}
