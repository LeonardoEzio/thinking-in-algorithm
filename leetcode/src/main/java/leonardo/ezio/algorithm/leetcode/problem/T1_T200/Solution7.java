package leonardo.ezio.algorithm.leetcode.problem.T1_T200;

/**
 * @ClassName : Solution7
 * @Author : LeonardoEzio
 * @Date : 2020-11-20 22:26
 * @Description : Leet Code第七题题解
 *
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 *
 *
 */
public class Solution7 {

    public static int reverse(int x) {
        String numStr = String.valueOf(x);
        String resultNum = "";
        if (x<-2147483648 || x> 2147483647){
            return 0;
        }
        if (x>=0){
            for (int i=numStr.length()-1;i>=0;i--){
                resultNum += numStr.charAt(i);
            }
        }else {
            resultNum = "-";
            for (int i=numStr.length()-1;i>0;i--){
                resultNum += numStr.charAt(i);
            }
        }
        Long aLong = Long.valueOf(resultNum);
        if (aLong<-2147483648 || aLong> 2147483647){
            return 0;
        }
        return aLong.intValue();
    }

    public static void main(String[] args) {
        int reverse = reverse(7682);
        System.out.println(reverse);
    }
}
