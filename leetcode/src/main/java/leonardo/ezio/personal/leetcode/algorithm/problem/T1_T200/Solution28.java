package leonardo.ezio.personal.leetcode.algorithm.problem.T1_T200;

/**
 * @ClassName : Solution28
 * @Author : LeonardoEzio
 * @Date : 2020-11-29 22:13
 * @Description : Leet code 28题 题解
 *
 *
 *
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *
 *
 */
public class Solution28 {

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle.trim())){
            return 0;
        }
        if (needle.length()>haystack.length()){
            return -1;
        }
        a:for (int i = 0 ; i < haystack.length() ; i++){
            int tempI = i;
            if (haystack.length()-i<needle.length()){
                return -1;
            }
            b:for (int j = 0 ; j < needle.length() ; j++){
                if (haystack.charAt(i) == needle.charAt(j)){
                    i++;
                }else {
                    i = tempI;
                    j = 0;
                    break b;
                }
            }
            if (tempI != i){
                return tempI;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int i = strStr("hello", "ll");
        System.out.println(i);
    }

}
