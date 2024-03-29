package leonardo.ezio.personal.leetcode.algorithm.problem.T1_T200;

/**
 * @ClassName : Solution35
 * @Author : LeonardoEzio
 * @Date : 2020-11-28 12:40
 * @Description : Leet code 35题 题解
 *
 *
 *
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 *
 *
 */
public class Solution35 {

    public static int searchInsert(int[] nums, int target) {
        int result = -1;
        for (int i = 0 ; i <nums.length ; i++){
            if (target == nums[i]){
                result = i;
                break;
            }
            if (i == 0 && target < nums[i]){
                result = i;
                break;
            } else if (i != 0 && target>nums[i-1] && target<nums[i]){
                result = i;
                break;
            } else {
                result = i+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6};
        int i = searchInsert(arr, 5);
        System.out.println(i);
    }
}
