package leonardo.ezio.algorithm.problem.T1_T200;

/**
 * @ClassName : Solution58
 * @Author : LeonardoEzio
 * @Date : 2020-11-20 22:36
 * @Description : Leet code 58题 题解
 *
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 *
 */
public class Solution58 {

    public static int lengthOfLastWord(String s) {
        int result = 0;
        String[] split = s.split(" ");
        if (split.length>0){
            result = split[split.length - 1].length();
        }
        return result;
    }

    public static void main(String[] args) {
        int len = lengthOfLastWord("hello world");
        System.out.println(len);
    }
}
