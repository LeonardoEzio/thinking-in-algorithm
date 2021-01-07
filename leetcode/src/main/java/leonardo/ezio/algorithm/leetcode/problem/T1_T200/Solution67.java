package leonardo.ezio.algorithm.leetcode.problem.T1_T200;

import java.util.Stack;

/**
 * @ClassName : Solution67
 * @Author : LeonardoEzio
 * @Date : 2020-11-28 11:33
 * @Description : Leet code 67题 题解
 *
 *
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Solution67 {

    public static String addBinary(String a, String b) {
        Stack<Character> characters = new Stack<>();
        int alen = a.length()-1;
        int blen = b.length()-1;
        int upgrad = 0;
        while (alen >= 0 || blen >= 0){
            int aValue = 0;
            if (alen >=0 ){
                aValue = a.charAt(alen)-48;
            }
            int bValue = 0;
            if (blen >= 0){
                bValue = b.charAt(blen)-48;
            }
            if (aValue + bValue == 2){
                if (upgrad == 1){
                    characters.push('1');
                }else if (upgrad == 0){
                    characters.push('0');
                }
                upgrad = 1;
            }else if (aValue + bValue == 1){
                if (upgrad == 1){
                    characters.push('0');
                    upgrad = 1;
                }else {
                    characters.push('1');
                    upgrad = 0;
                }
            }else if (aValue + bValue ==0){
                if (upgrad == 1){
                    characters.push('1');
                }else {
                    characters.push('0');
                }
                upgrad = 0;
            }
            alen--;
            blen--;
        }
        StringBuffer resultBuffer = new StringBuffer();
        if (upgrad != 0){
            resultBuffer.append(upgrad);
        }
        while (!characters.isEmpty()){
            resultBuffer.append(characters.pop());
        }
        return resultBuffer.toString();
    }


    public static void main(String[] args) {
        String result = addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
        System.out.println(result);
    }

}
