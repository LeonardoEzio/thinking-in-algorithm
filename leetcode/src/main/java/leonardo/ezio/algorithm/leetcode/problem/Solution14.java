package leonardo.ezio.algorithm.leetcode.problem;

/**
 * @ClassName : Solution14
 * @Author : LeonardoEzio
 * @Date : 2020-11-20 22:32
 * @Description : Leet code 14题 题解
 *
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 */
public class Solution14 {

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length==0){
            return result;
        }
        result = strs[0];
        for (int i = 1; i<strs.length;i++){
            int j = 0;
            for (;j<result.length()&&j<strs[i].length();j++){
                if (result.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            result = result.substring(0, j);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
}
