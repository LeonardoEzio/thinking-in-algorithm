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
        List<Integer> sort = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        List<Integer> alreadyRob = new ArrayList<>();
        List<Integer> alreadyRob2 = new ArrayList<>();
        for (int i = 0 ; i<nums.length;i++){
            if (index.contains(i)){
                continue;
            }
            int max = nums[i];
            int maxIndex = i;
            for (int j =0;j<nums.length;j++){
                if (nums[j]> max && !index.contains(j)){
                    max = nums[j];
                    maxIndex = j;
                }
            }
            sort.add(max);
            index.add(maxIndex);
            if (maxIndex != i){
                i--;
            }
        }

        sort.forEach(i->{
            System.out.print(i);
        });
        System.out.println();
        index.forEach(i->{
            System.out.print(i);
        });
        System.out.println();
        int result = 0;
        for (int i = 0; i<sort.size();i++){
            if (!alreadyRob.contains(index.get(i)+1) && !alreadyRob.contains(index.get(i)-1)){
                result += sort.get(i);
                alreadyRob.add(index.get(i));
            }
        }


        int result1 = 0;
        for (int i= sort.size()-1 ; i>=0 ; i--){
            if (!alreadyRob2.contains(index.get(i)+1) && !alreadyRob2.contains(index.get(i)-1)){
                result1 += sort.get(i);
                alreadyRob2.add(index.get(i));
            }
        }

        return Math.max(result, result1);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,7,9,4};
        int solution = solution(arr);
        System.out.println(solution);
    }
}
