package leonardo.ezio.algorithm.leetcode.problem;

/**
 * @ClassName : Solution1
 * @Author : LeonardoEzio
 * @Date : 2020-09-09 20:07
 * @Description : leetcode 题1
 *  * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *      * <p>
 *      * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *      * <p>
 *      *  
 *      * <p>
 *      * 示例:
 *      * <p>
 *      * 给定 nums = [2, 7, 11, 15], target = 9
 *      * <p>
 *      * 因为 nums[0] + nums[1] = 2 + 7 = 9
 *      * 所以返回 [0, 1]
 *      * <p>
 *      * 来源：力扣（LeetCode）
 *      * 链接：https://leetcode-cn.com/problems/two-sum
 *      * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *      *
 */
public class Solution1 {

    /**
     * description : <求指定数组中两数之和>
     * @param nums   给定数组
     * @param target 目标和
     * @return {@link int[] } 符合条件的数据下标
     * @methodName : twoSum
     * @date : 2020/9/9 20:10
     **/
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0;i<nums.length-1;i++){
            for (int j = i+1 ; j<=nums.length-1;j++){
                if (nums[i]+nums[j] == target){
                    res[0]=i;
                    res[1]=j;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4};
        int[] ints = twoSum(arr, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
