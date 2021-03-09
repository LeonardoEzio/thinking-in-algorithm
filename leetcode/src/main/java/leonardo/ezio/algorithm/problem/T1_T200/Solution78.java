package leonardo.ezio.algorithm.problem.T1_T200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : Solution78
 * @Author : LeonardoEzio
 * @Date : 2021-02-26 20:43
 * @Description : Leet code 78题 题解
 *
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 */
public class Solution78 {

    /**
    * description : <排列组合解法>
    *
    * @methodName : subsets
    * @param nums
    * @return {@link List< List< Integer>> }
    * @date : 2021/2/26 20:47
    **/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> totalR = new ArrayList<>();
        totalR.add(new ArrayList<>());
        for (int i = 1 ; i<=nums.length; i++){
            combine(nums, new ArrayList<>(), i,totalR);
        }
        return totalR;
    }

    /**
    * description : <排列>
    *
    * @methodName : combine
    * @param waitChoice 待选择的数
    * @param result 结果集
    * @param len 挑选几个元素
    * @return {@link List< List< Integer>> }
    * @date : 2021/2/26 20:56
    **/
    public void combine(int [] waitChoice, List<Integer> result, int len,List<List<Integer>> total){
        // 挑选完了 m 个元素，输出结果
        if (result.size() == len) {
            total.add(result);
            return;
        }

        for (int i = 0 ; i<waitChoice.length; i++){

            List<Integer> copyResult = new ArrayList<>();
            copyResult.addAll(result);
            //选择一个加入
            copyResult.add(waitChoice[i]);
            //从剩下的再选择
            int[] newWait = Arrays.copyOfRange(waitChoice, i+1, waitChoice.length);
            combine(newWait, copyResult, len,total);
        }

        //思考如何替换掉递归
    }


    /**
    * description : <二进制求子集解法>
    *
    * @methodName : subsets1
    * @param nums
    * @return {@link List< List< Integer>> }
    * @date : 2021/2/26 21:43
    **/
    public List<List<Integer>> subsets1(int[] nums) {
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            t.clear();
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        List<List<Integer>> subsets = solution78.subsets1(new int[]{5,2,9});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
//        List<List<Integer>> totalR = new ArrayList<>();
//        solution78.combine(new int[]{1, 2, 3}, new ArrayList<>(), 1,totalR);
//        for (List<Integer> integers : totalR) {
//            System.out.println(integers);
//        }
    }
}
