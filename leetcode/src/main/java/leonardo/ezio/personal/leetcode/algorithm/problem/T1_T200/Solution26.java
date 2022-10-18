package leonardo.ezio.personal.leetcode.algorithm.problem.T1_T200;

/**
 * @ClassName : Solution26
 * @Author : LeonardoEzio
 * @Date : 2020-11-20 22:41
 * @Description : Leet code 26题 题解
 *
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 */
public class Solution26 {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0 ; i<len-1; i++){
            if (nums[i] == nums[i+1]){
                for (int j = i ; j<len-1 ; j++){
                    nums[j] = nums[j+1];
                }
                i--;
                len--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int size = removeDuplicates(nums);
        System.out.println(size);
        System.out.println("=========================");
        for(int i = 0 ; i<size ;i++){
            System.out.println(nums[i]);
        }
    }
}
