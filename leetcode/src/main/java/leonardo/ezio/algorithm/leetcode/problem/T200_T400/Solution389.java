package leonardo.ezio.algorithm.leetcode.problem.T200_T400;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName : Solution389
 * @Author : LeonardoEzio
 * @Date : 2020-12-18 23:58
 * @Description : Leet code 389题 题解
 *
 *
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *
 *
 */
public class Solution389 {

    public static char findTheDifference(String s, String t) {
        if ("".equals(s)){
            return t.charAt(0);
        }
        Map<Character, Integer> charCounts = new HashMap<>();
        char[] chars = t.toCharArray();
        for (int i = 0 ; i<chars.length ; i++){
            Integer integer = charCounts.get(chars[i]);
            if (null != integer && integer != 0){
                integer+=1;
                charCounts.put(chars[i], ++integer);
            }else {
                charCounts.put(chars[i],1);
            }
        }
        char[] chars1 = s.toCharArray();
        for (int i = 0 ; i<chars1.length ; i++){
            Integer integer = charCounts.get(chars1[i]);
            if (integer!=0){
                charCounts.put(chars1[i], --integer);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = charCounts.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue()>0){
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        char theDifference = findTheDifference("ae", "aea");
        System.out.println(theDifference);
    }
}
